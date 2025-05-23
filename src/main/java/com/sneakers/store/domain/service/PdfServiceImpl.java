package com.sneakers.store.domain.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sneakers.store.domain.model.ProductItem;
import lombok.AllArgsConstructor;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@AllArgsConstructor
public class PdfServiceImpl implements PdfService{
    @Override
    public  byte[]  generateInvoice(String invoiceNo, String issueDate,  String clientName, String clientAddress,
                                List<ProductItem> products) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, baos);
        document.open();

        // Fuentes
        Font titleFont = new Font(Font.HELVETICA, 14, Font.BOLD, new Color(80, 72, 70));
        Font boldFont = new Font(Font.HELVETICA, 10, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 10);
        Font grayFont = new Font(Font.HELVETICA, 10, Font.NORMAL, Color.GRAY);
        Color headerBgColor = new Color(233, 229, 226);

        // Título
        Paragraph logo = new Paragraph("S", new Font(Font.HELVETICA, 30, Font.BOLD, new Color(198, 190, 182)));
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);

        Paragraph businessName = new Paragraph("STEP UP", titleFont);
        businessName.setAlignment(Element.ALIGN_CENTER);
        document.add(businessName);

        Paragraph subtitle = new Paragraph("Sube tu estilo. Cada paso cuenta.", grayFont);
        subtitle.setAlignment(Element.ALIGN_CENTER);
        subtitle.setSpacingAfter(20);
        document.add(subtitle);

        // Datos cliente y factura
        PdfPTable clientTable = new PdfPTable(2);
        clientTable.setWidthPercentage(100);
        clientTable.setWidths(new int[]{1, 1});

        PdfPCell left = new PdfPCell();
        left.setBorder(Rectangle.NO_BORDER);
        left.addElement(new Paragraph("Cliente:", boldFont));
        left.addElement(new Paragraph(clientName, normalFont));
        left.addElement(new Paragraph("STENP UP", normalFont));
        left.addElement(new Paragraph(clientAddress, normalFont));

        PdfPCell right = new PdfPCell();
        right.setBorder(Rectangle.NO_BORDER);
        right.addElement(new Paragraph("Numero de factura: " + invoiceNo, normalFont));
        right.addElement(new Paragraph("Fecha de emision: " + issueDate, normalFont));

        clientTable.addCell(left);
        clientTable.addCell(right);
        clientTable.setSpacingAfter(20);
        document.add(clientTable);

        // Tabla productos
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{4, 2, 1, 2});

        String[] headers = {"Descripcion", "precio", "Cantidad", "Total"};
        for (String h : headers) {
            PdfPCell header = new PdfPCell(new Phrase(h, boldFont));
            header.setBackgroundColor(headerBgColor);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header);
        }

        BigDecimal subtotal = new BigDecimal(0);
        for (ProductItem item : products) {
            BigDecimal total = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            subtotal = subtotal.add(total);

            table.addCell(new Phrase(item.getDescription(), normalFont));
            table.addCell(new Phrase("€" + item.getUnitPrice().setScale(2, RoundingMode.HALF_UP), normalFont));
            table.addCell(new Phrase(String.valueOf(item.getQuantity()), normalFont));
            table.addCell(new Phrase("€" + total.setScale(2, RoundingMode.HALF_UP), normalFont));
        }

        // Subtotal
        PdfPCell subTotalCell = new PdfPCell(new Phrase("SubTotal", boldFont));
        subTotalCell.setColspan(3);
        subTotalCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(subTotalCell);
        table.addCell(new Phrase("€" + subtotal.setScale(2, RoundingMode.HALF_UP), boldFont));

        // Tax
        PdfPCell taxLabel = new PdfPCell(new Phrase("IVA", normalFont));
        taxLabel.setColspan(3);
        taxLabel.setBorder(Rectangle.NO_BORDER);
        table.addCell(taxLabel);
        table.addCell(new Phrase("21" + "%", normalFont));

        // Total
        PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL", boldFont));
        totalLabel.setColspan(3);
        totalLabel.setBackgroundColor(headerBgColor);
        table.addCell(totalLabel);
        PdfPCell totalValue = new PdfPCell(new Phrase("€" + subtotal.setScale(2, RoundingMode.HALF_UP), boldFont));
        totalValue.setBackgroundColor(headerBgColor);
        table.addCell(totalValue);

        table.setSpacingAfter(20);
        document.add(table);


        // Agradecimiento
        Paragraph thanks = new Paragraph("Gracias por tu compra", boldFont);
        thanks.setAlignment(Element.ALIGN_RIGHT);
        thanks.setSpacingBefore(20);
        document.add(thanks);

        Paragraph signature = new Paragraph("- Step up INC", new Font(Font.COURIER, 14, Font.ITALIC));
        signature.setAlignment(Element.ALIGN_RIGHT);
        document.add(signature);

        document.close();
        return baos.toByteArray();
    }
}
