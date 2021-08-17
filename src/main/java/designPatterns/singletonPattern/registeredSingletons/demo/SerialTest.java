package designPatterns.singletonPattern.registeredSingletons.demo;

import java.io.*;

/**
 * Demo SerialTest
 *
 * @author sunlianyu
 * @date 2021/8/16 20:05
 */
public class SerialTest {
	public static void main(String[] args) {

		try {
			SerialSingleton serialSingleton = null;
			SerialSingleton serialSingleton2 = SerialSingleton.getInstance();
			FileOutputStream fileOutputStream = new FileOutputStream("s.obj");
			ObjectOutputStream objectOutputStream = null;

			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(serialSingleton2);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();

			FileInputStream fileInputStream = new FileInputStream("s.obj");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			serialSingleton = (SerialSingleton) objectInputStream.readObject();

			System.out.println(serialSingleton);
			System.out.println(serialSingleton2);
			System.out.println(serialSingleton.equals(serialSingleton2));
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
