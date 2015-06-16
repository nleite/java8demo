package java8demo.batch.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
	
	private static final String SEPARATOR = ";";
	
	private final Reader source;

	public CSVReader(Reader source) {
		super();
		this.source = source;
	}

	
	
	public List<String> readHeader(){
		try( BufferedReader reader = new BufferedReader(source)){
			return reader.lines()
					.findFirst()
					.map(line -> Arrays.asList(line.split(SEPARATOR)))
					.get();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	
	public List<String> readRecords(List<String> headers){
		try( BufferedReader reader = new BufferedReader(source)){
			
			
			
			reader.lines()
					.map(line -> Arrays.asList(line.split(SEPARATOR)))
					.flatMap(l -> l.stream())
					.forEach(i ->
						{System.out.println("Content: " + i);}
						//headers.parallelStream().forEach(j -> {System.out.println("Content: " + j + i);});
					 );
			return null;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	
}
