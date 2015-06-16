package java8demo.codecs;

import org.bson.Document;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class DocumentCodecProvider implements CodecProvider {

	private final BsonTypeClassMap classMapper;
	
	
	public DocumentCodecProvider(BsonTypeClassMap classMapper) {
		super();
		this.classMapper = classMapper;
	}


	@SuppressWarnings("unchecked")
	public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
		
		if ( clazz == Document.class){
			return (Codec<T>) new DocumentCodec(registry, classMapper);
		}
		return null;
	}

}
