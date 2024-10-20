package com.payperless.kybapi.service;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class OCRService {

    public String processImage(MultipartFile document) {
        Tesseract tesseract = new Tesseract();
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        try {
            return tesseract.doOCR(ImageIO.read(document.getInputStream()));
        } catch (TesseractException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
