package com.sneakers.store.domain.service;

public interface PdfService {

    byte[] generarFacturaPdf(String numeroFactura, String cliente, String fecha, String descripcion, double total) throws Exception;
}
