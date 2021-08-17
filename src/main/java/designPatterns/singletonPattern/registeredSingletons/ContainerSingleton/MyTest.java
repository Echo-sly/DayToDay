package designPatterns.singletonPattern.registeredSingletons.ContainerSingleton;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/17 21:02
 */
public class MyTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new T());
		Thread t2 = new Thread(new T());

		t1.start();
		t2.start();
	}
}
