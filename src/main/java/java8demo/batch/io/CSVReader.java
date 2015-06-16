package java8demo.batch.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.bson.Document;

public class CSVReader {

	private static final String SEPARATOR = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

	private final File source;

	public CSVReader(File source) {
		super();
		this.source = source;
	}

	public List<String> readHeader() {

		try (FileReader fr = new FileReader(this.source);
				BufferedReader reader = new BufferedReader(fr)) {
			return reader.lines().findFirst()
					.map(line -> Arrays.asList(line.split(SEPARATOR))).get();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public List<Document> readRecords(List<String> headers) {

		try (FileReader fr = new FileReader(this.source);
				BufferedReader reader = new BufferedReader(fr)) {

			return reader
					.lines()
					.skip(1)
					.map(line -> {
						Document document = new Document();
						List<String> values = Arrays.asList(line
								.split(SEPARATOR));
						IntStream.range(0,
								Math.min(values.size(), headers.size()))
								.forEach(
										i -> document.put(headers.get(i),
												values.get(i)));
						return document;
					}).collect(Collectors.toList());

		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
