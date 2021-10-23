package com.mmt.practise;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;

@Listeners(com.vtiger.generic.MyListeners.class)

public class listeners1 extends BaseClass{
	@Test
	public void demoTest()
	{
		System.out.println(10/0);
	}
	

}
