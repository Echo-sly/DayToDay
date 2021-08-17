package designPatterns.singletonPattern.threaLocalSingle;

/**
 * Demo ThreadLocalSingleTest
 *
 * @author sunlianyu
 * @date 2021/8/17 21:15
 */
public class ThreadLocalSingleTest {
	public static void main(String[] args) {

		System.out.println("main thread" + ThreadLocalSingle.getInstance());
		System.out.println("main thread" + ThreadLocalSingle.getInstance());
		System.out.println("main thread" + ThreadLocalSingle.getInstance());
		System.out.println("main thread" + ThreadLocalSingle.getInstance());
		System.out.println("main thread" + ThreadLocalSingle.getInstance());

		Thread t1 = new Thread(new E());
		Thread t2 = new Thread(new E());
		Thread t3 = new Thread(new E());
		Thread t4 = new Thread(new E());

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
