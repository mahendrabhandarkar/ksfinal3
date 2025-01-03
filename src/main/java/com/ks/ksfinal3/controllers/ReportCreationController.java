package com.ks.ksfinal3.controllers;

import com.ks.ksfinal3.services.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportCreationController {

    @Autowired
    ReportService reportService;

    // Used to create word document
    @GetMapping("/generateDoc")
    public byte[] generateDoc() throws IOException {
        // create a new Word Document
        XWPFDocument document = new XWPFDocument();
        // create a paragraph
        XWPFParagraph paragraph1 = document.createParagraph();
        paragraph1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run1 = paragraph1.createRun();
        run1.setText("Test Document");
        run1.setBold(true);
        run1.setFontSize(14);
        run1.addBreak();
        XWPFParagraph header = document.createParagraph();
        header.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun headerRun1 = header.createRun();
        headerRun1.setBold(true);
        headerRun1.setFontSize(14);
        headerRun1.setText("Test Document 2");
        headerRun1.addBreak();
        XWPFParagraph paragraph2 = document.createParagraph();
        paragraph2.setAlignment(ParagraphAlignment.CENTER);
        // Create a run to present the text in the paragraph
        XWPFRun run2 = paragraph2.createRun();
        run2.setFontFamily("Bookman Old Style");
        run2.setBold(false);
        run2.setFontSize(12);
        run2.setText("Test Document 3");
        run2.addBreak();
        XWPFParagraph header1 = document.createParagraph();
        header1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun headRun2 = header1.createRun();
        headRun2.setBold(true);
        headRun2.setFontSize(14);
        headRun2.setText("");
        headRun2.addBreak();
        // Write the document to a ByteArrayOutputStream (in memory)
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            document.write(byteArrayOutputStream); // Write to byte array
            return byteArrayOutputStream.toByteArray(); // Return the byte array
        }
    }

    // Used to create excel document
    @GetMapping("/generateExcelDoc")
    public void generateExcelDoc(HttpServletResponse httpServletResponse) throws IOException {
        reportService.generateExcelFileReportSample(httpServletResponse);
    }
}
