package java8demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java8demo.batch.io.CSVReader;

import com.mongodb.MongoClient;

public class LambdaSample {
		
	private MongoClient mc;
	
	public void run() throws IOException{
		
		this.mc = new MongoClient("localhost:27017");
		
		
		FileReader fileReader = new FileReader("/Users/norberto/java_demos/java8demo/src/main/resources/files/Active_Corporations___Beginning_1800.csv");
		CSVReader csv = new CSVReader(fileReader);
		List<String> headers = new ArrayList<String>();   //csv.readHeader();
		headers.add("jjjj");
		headers.add("iiii");
		csv.readRecords(headers);
		
	}
	
	
}
