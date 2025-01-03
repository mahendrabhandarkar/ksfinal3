package com.ks.ksfinal3.util;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.io.IOException;
import java.util.Iterator;

public abstract class ExcelFileGenerator {

    protected XSSFWorkbook xssfWorkbook;
    protected XSSFSheet xssfSheet;
    protected CellStyle cellStyle;
    protected CellStyle dateCellStyle;

    public ExcelFileGenerator() {
        xssfWorkbook = new XSSFWorkbook();
        setStyleParam();
    }

    private void setStyleParam() {
        cellStyle = xssfWorkbook.createCellStyle();
        XSSFFont xssfFont = xssfWorkbook.createFont();
        xssfFont.setFontHeight(13);
        cellStyle.setFont(xssfFont);
        dateCellStyle = xssfWorkbook.createCellStyle();
        CreationHelper creationHelper = xssfWorkbook.getCreationHelper();
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("d-m-yy h:mm"));
        dateCellStyle.setFont(xssfFont);
    }

    abstract void writeExcelFileHeader();
    abstract void writeExcelFileBody();

    public void writeExcelFile(HttpServletResponse httpServletResponse) {
        try (XSSFWorkbook xssfWorkbook1 = this.generateExcelFile(httpServletResponse)) {
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            xssfWorkbook1.write(servletOutputStream);
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private XSSFWorkbook generateExcelFile(HttpServletResponse httpServletResponse) {
        writeExcelFileHeader();
        writeExcelFileBody();
        autoSizeColumns(xssfWorkbook);
        return xssfWorkbook;
    }

    private void autoSizeColumns(XSSFWorkbook xssfWorkbook) {
        int numberOfSheets = xssfWorkbook.getNumberOfSheets();
        for(int i=0; i < numberOfSheets; i++) {
            Sheet sheet = xssfWorkbook.getSheetAt(i);
            if(sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }

    void createSheetCell(Row row, int columnCount, Object valueOfCell, CellStyle cellStyle) {
        Cell cell = row.createCell(columnCount);
        if(valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if(valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        }
        cell.setCellStyle(cellStyle);
    }
}
