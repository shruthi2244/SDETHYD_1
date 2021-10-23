package com.mmt.practise;

import org.testng.annotations.DataProvider;

public class DataDrivenconceptinTestNG {
	@DataProvider
	public Object[][] databank(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="TYSS1";
		obj[0][1]="QSP1";
		obj[1][0]="TYSS2";
		obj[1][1]="QSP2";
		return obj;
	}
	
}
