package com.example.dio.service;

public interface QRService {
    byte[] generateQRCode(String url) throws Exception;
}
