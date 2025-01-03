package com.ks.ksfinal3.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class Sample1Excel extends ExcelFileGenerator {

    String strText;

    public Sample1Excel(String str) {
        this.strText = str;
    }

    @Override
    void writeExcelFileHeader() {
        xssfSheet = xssfWorkbook.createSheet("My Sheet 1");
        Row row = xssfSheet.createRow(0);
        xssfSheet.createFreezePane(4,1);
        CellStyle cellStyle1 = xssfWorkbook.createCellStyle();
        XSSFFont xssfFont = xssfWorkbook.createFont();
        xssfFont.setBold(true);
        xssfFont.setFontHeight(15);
        cellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.index);
        cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle1.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle1.setBorderTop(BorderStyle.MEDIUM);
        cellStyle1.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle1.setBorderRight(BorderStyle.MEDIUM);
        cellStyle1.setFont(xssfFont);
        createSheetCell(row, 0, "Sr No 1", cellStyle1);
        createSheetCell(row, 1, "Sr No 2", cellStyle1);
        createSheetCell(row, 2, "Sr No 3", cellStyle1);
        createSheetCell(row, 3, "Sr No 4", cellStyle1);
        createSheetCell(row, 4, "Sr No 5", cellStyle1);
        createSheetCell(row, 5, "Sr No 6", cellStyle1);
    }

    @Override
    void writeExcelFileBody() {
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setAlignment(HorizontalAlignment.LEFT);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);

        CreationHelper creationHelper = xssfWorkbook.getCreationHelper();
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("d-m-yy"));

        // date inserton
        int rowNum = 1;
        int columnNum = 0;
        Row row = xssfSheet.createRow(rowNum);
        createSheetCell(row, columnNum++, rowNum - 1, cellStyle);
    }
}
