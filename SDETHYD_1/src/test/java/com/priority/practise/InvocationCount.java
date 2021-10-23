package com.priority.practise;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount=5)
	public void createorg() {
		System.out.println("run scripts as 5 times");
	}
	}


