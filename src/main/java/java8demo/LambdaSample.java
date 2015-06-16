package java8demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java8demo.batch.io.CSVReader;

import com.mongodb.MongoClient;

public class LambdaSample {
		
	private MongoClient mc;
	
	public void run() throws IOException{
		
		this.mc = new MongoClient("localhost:27017");
		ClassLoader loader = getClass().getClassLoader();
		File file = new File( loader.getResource("files/Active_Corporations___Beginning_1800.csv").getFile()); 
		FileReader fileReader = new FileReader(file);
		CSVReader csv = new CSVReader(fileReader);
		List<String> headers = new ArrayList<String>();   //csv.readHeader();
		headers.add("jjjj");
		headers.add("iiii");
		csv.readRecords(headers);
		
	}
	
	
}
