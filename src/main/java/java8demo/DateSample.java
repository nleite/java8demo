package java8demo;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java8demo.codecs.DocumentCodecProvider;
import java8demo.codecs.InstantCodec;

import org.bson.BsonType;
import org.bson.Document;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;

public class DateSample {

	private MongoClient mc;
	private MongoCollection<Document> collection;

	public DateSample() {
		super();

		InstantCodec instantCodec = new InstantCodec();
		Map<BsonType, Class<?>> replacements = new HashMap<BsonType, Class<?>>();
		replacements.put(BsonType.DATE_TIME, Instant.class);
		BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap(replacements);
		DocumentCodecProvider documentCodecProvider = new DocumentCodecProvider(
				bsonTypeClassMap);
		CodecRegistry cr = CodecRegistries.fromRegistries(
				CodecRegistries.fromCodecs(instantCodec),
				CodecRegistries.fromProviders(documentCodecProvider),
				MongoClient.getDefaultCodecRegistry());
		// add the new code registry has option.
		MongoClientOptions option = MongoClientOptions.builder()
				.codecRegistry(cr).build();

		this.mc = new MongoClient("localhost:27017", option);
		this.collection = mc.getDatabase("dates").getCollection("sample");
	}

	public void run() {

		Document doc = new Document("java8date", Instant.now());

		this.collection.insertOne(doc);

		Document retrieved = this.collection.find(doc).first();

		System.out.println(retrieved.get("java8date").getClass()
				.getCanonicalName());

	}

}
