package com.sneakers.store.domain.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.ByteArrayOutputStream;

@AllArgsConstructor
public class PdfServiceImpl implements PdfService{

    @Override
    public byte[] generarFacturaPdf(String numeroFactura, String cliente, String fecha, String descripcion, double total) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, out);
        document.open();

        // Título
        Font titleFont = new Font(Font.HELVETICA, 22, Font.BOLD, new Color(40, 40, 150));
        Paragraph title = new Paragraph("Factura", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Info básica
        Font infoFont = new Font(Font.HELVETICA, 12, Font.NORMAL);
        document.add(new Paragraph("Número de Factura: " + numeroFactura, infoFont));
        document.add(new Paragraph("Cliente: " + cliente, infoFont));
        document.add(new Paragraph("Fecha de emisión: " + fecha, infoFont));
        document.add(Chunk.NEWLINE);

        // Descripción
        document.add(new Paragraph("Descripción:", infoFont));
        document.add(new Paragraph(descripcion, new Font(Font.HELVETICA, 12, Font.ITALIC)));
        document.add(Chunk.NEWLINE);

        // Total
        Font totalFont = new Font(Font.HELVETICA, 14, Font.BOLD);
        Paragraph totalParrafo = new Paragraph("Total: $" + String.format("%.2f", total), totalFont);
        totalParrafo.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalParrafo);

        // Footer
        document.add(Chunk.NEWLINE);
        Paragraph footer = new Paragraph("Gracias por su compra", new Font(Font.HELVETICA, 10, Font.ITALIC, new Color(100, 100, 100)));
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);

        document.close();
        return out.toByteArray();
    }

}
