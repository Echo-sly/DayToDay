package designPatterns.singletonPattern.lazyDoubleCheckSingle;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/16 19:29
 */
public class MyTest {
	public static void main(String[] args) {
//		System.out.println(SimpleLazySingleton.getInstance());
//		System.out.println(SimpleLazySingleton.getInstance());
//		System.out.println(SimpleLazySingleton.getInstance());
//		System.out.println(SimpleLazySingleton.getInstance());

		System.out.println("-----------------------");
		Thread t1 = new Thread(new ExecutorThread());
		Thread t2 = new Thread(new ExecutorThread());
		t1.start();
		t2.start();
	}
}
