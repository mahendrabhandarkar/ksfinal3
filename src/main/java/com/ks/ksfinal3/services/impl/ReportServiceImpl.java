package com.ks.ksfinal3.services.impl;

import com.ks.ksfinal3.services.ReportService;
import com.ks.ksfinal3.util.ExcelFileGenerator;
import com.ks.ksfinal3.util.Sample1Excel;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    public void generateExcelFileReportSample(HttpServletResponse httpServletResponse) {
        String strText = " I am doing great";
        ExcelFileGenerator excelGenerator = new Sample1Excel(strText);
        excelGenerator.writeExcelFile(httpServletResponse);
    }
}
