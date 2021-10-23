package com.priority.practise;


import org.testng.annotations.Test;

public class Dependsonmethods {
	@Test
	public void createorg() {
		//Reporter.log("create org added");
			System.out.println("create org added");
		}
		@Test(dependsOnMethods="create org")
		public void modify() {
			System.out.println("modifications added");
		}
		@Test(dependsOnMethods="create org")
		public void deleteteorg() {
			System.out.println("modifications added");
		}
		}



