package com.mmt.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class exceldata {

	public static void main(String[] args) throws Throwable  {
		FileInputStream fis=new FileInputStream("");
		workbook wb= new WorkbookFactory.create(fis);
	}

}
