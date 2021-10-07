package com.federo.GenericLib;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib {
	/**
	 * 
	 * @param path
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readExcelData(String path,String SheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String excelvalue=wb.getSheet(SheetName).getRow(row).getCell(cell).toString();
		return excelvalue;
	}
	/**
	 * 
	 * @param path
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void WriteExcelData(String path, String SheetName, int row, int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	/**
	 * 
	 * @param path
	 * @param Sheet
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String path, String Sheet) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(Sheet).getLastRowNum();
		return rowcount;
	}
	/**
	 * 
	 * @param propPath
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readPropertyData(String propPath, String key) throws Throwable {
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propvalue=prop.getProperty(key, "Incorrect key");
		return propvalue;
	}
}
