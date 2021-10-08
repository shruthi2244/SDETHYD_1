package com.mmt.practise;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONDATA {
	public static void main(String[] args) throws Throwable, Throwable {
		
		FileReader inputfile=new FileReader("./CommonData.json");
		  JSONParser parse=new JSONParser();
		  Object obj=parse.parse(inputfile);
		 HashMap obj1=(HashMap) obj;
		  String value=obj1.get("username").toString();
		  System.out.println(value);
	}

}
