package com.mmt.practise;

import java.io.FileReader;
import java.util.HashMap;

public class JSONDATA {
	public static void main(String[] args) {
		
		FileReader inputfile=new FileReader("./CommonData.json");
		  JSONParser parse=new JSONParser();
		  Object obj=parse.parse(inputfile);
		  HashMap obj=(HashMap) obj;
		  String value=obj.get("username").toString();
		  System.out.println(value);
	}

}
