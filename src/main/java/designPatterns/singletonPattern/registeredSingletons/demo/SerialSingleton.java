package designPatterns.singletonPattern.registeredSingletons.demo;

import java.io.Serializable;

/**
 * Demo RegisteredSingleton
 *
 * @author sunlianyu
 * @date 2021/8/16 20:02
 */
public class SerialSingleton implements Serializable {

	private final static SerialSingleton INSTANCE = new SerialSingleton();

	private SerialSingleton() {

	}

	static SerialSingleton getInstance() {
		return INSTANCE;
	}
}
