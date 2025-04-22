package com.example.dio.controller;

import com.example.dio.service.QRService;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("${app.base-url}")
public class QRController {
//private static final Logger log = LoggerFactory.getLogger(QRController.class);
    private QRService qrService;



    @GetMapping(value = "/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestParam("url") String url) {
        try {
            // Generate a 250x250 QR code image for the provided URL
            byte[] qrImage = qrService.generateQRCode(url);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
        } catch (WriterException | IOException e) {
            log.error("Failed to generate QR code message: {}, rootCause: ", e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            log.error("Unexpected error occurred: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
