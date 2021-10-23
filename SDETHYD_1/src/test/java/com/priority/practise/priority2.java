package com.priority.practise;

import org.testng.annotations.Test;

public class priority2 {
	@Test(priority=0)
	public void createorg() {
			System.out.println("create org added");
		}
		@Test(priority=-1)
		public void modify() {
			System.out.println("modifications added");
		}
		@Test(priority=-2)
		public void deleteteorg() {
			System.out.println("org deleted");
		}
		}



