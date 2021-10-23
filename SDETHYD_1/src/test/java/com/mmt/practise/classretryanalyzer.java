package com.mmt.practise;

import org.testng.annotations.Test;

public class classretryanalyzer {
	@Test(retryAnalyzer = com.vtiger.generic.RetryAnalyzer.class)
	public void sampleTest()
	{
		System.out.println(10/0);
	}
}
