package java8demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java8demo.batch.io.CSVReader;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

public class LambdaSample {
		
	private MongoClient mc;
	
	
	public void run() throws IOException{
		
		this.mc = new MongoClient("localhost:27017");
		ClassLoader loader = getClass().getClassLoader();
		File file = new File( loader.getResource("Active_Corp.csv").getFile()); 
		CSVReader csv = new CSVReader(file);
		List<String> headers = csv.readHeader();
		
		MongoCollection<Document> collection = this.mc.getDatabase("data").getCollection("companies");
		
		collection.insertMany( csv.readRecords(headers) );
		
		System.out.println( collection.count() );
//		collection.drop();
	}
	
	
}
