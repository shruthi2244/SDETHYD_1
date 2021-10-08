package com.mmt.practise;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class exceldata {

	public static void main(String[] args) throws Throwable  {
		FileInputStream fis=new FileInputStream("");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
		System.out.println(data);
	}

}
