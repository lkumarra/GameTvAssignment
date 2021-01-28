package com.game.tv.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.game.tv.constants.Constants;
import com.game.tv.mapper.GameTvMapper;

public class ExcelUtility {
	static Workbook workbook = new XSSFWorkbook();

	public void enterTextToExcel(List<GameTvMapper> gameTvMapper, String[] headings) {
		Sheet sheet = workbook.createSheet("GamesList");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLUE_GREY.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headings.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headings[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;
		for (GameTvMapper gameTvMapper1 : gameTvMapper) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(gameTvMapper1.getGameName());
			row.createCell(1).setCellValue(gameTvMapper1.getPageUrl());
			row.createCell(2).setCellValue(gameTvMapper1.getPageStatus());
			row.createCell(3).setCellValue(gameTvMapper1.getTournamentCount());
		}
		for (int i = 0; i < headings.length; i++) {
			sheet.autoSizeColumn(i);
		}
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(Constants.excelSheet);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileOut.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
