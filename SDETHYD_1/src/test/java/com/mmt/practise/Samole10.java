package com.mmt.practise;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Samole10 {
	@BeforeMethod
	public void test1() {
		System.out.println("tyss1");
	}
	@AfterMethod
	public void test4() {
		System.out.println("qsp1");
	
	}
	@Test
	public void test2() {
		System.out.println("tyss3");
		
		}
	
	@Test
	public void test3() {
		System.out.println("qsp3");
		Assert.assertEquals(true, false);
		}

}
