package java8demo.batch.io;

import java.util.stream.Stream;

public interface Out<T> {

	/**
	 * Will write t elements of T
	 * @param t
	 */
	void write(T t);
	
	void writeBunch(Stream<T> ts);
}
