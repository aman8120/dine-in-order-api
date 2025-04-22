package com.example.dio.service.imp;

import com.example.dio.service.QRService;
import com.example.dio.util.QRCodeGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QRServiceImpl implements QRService {
    @Override
    public byte[] generateQRCode(String url) throws Exception {
        return QRCodeGenerator.generateQRCodeImage(url);
    }
}
