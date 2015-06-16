package java8demo.batch.io;

public interface In<T> {

	/**
	 * Reads based on an Argument I 
	 * @param t
	 */
	void read(T t);
}
