package java8demo.codecs;

import java.time.Instant;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class InstantCodec implements Codec<Instant> {

	public void encode(BsonWriter writer, Instant value,
			EncoderContext encoderContext) {
		//will store Instant has Epoch Milliseconds 
		writer.writeDateTime(value.toEpochMilli());
	}

	public Class<Instant> getEncoderClass() {
		return Instant.class;
	}
	
	public Instant decode(BsonReader reader, DecoderContext decoderContext) {
		return Instant.ofEpochMilli(reader.readDateTime());
	}

}
