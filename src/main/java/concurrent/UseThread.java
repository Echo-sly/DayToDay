package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/14 16:25
 *
 * 使用 Thread 来进行开发
 */
public class UseThread extends Thread {
	public static void main(String[] args) {

		UseThread aThread = new UseThread();
		aThread.start();

		UseThread bThread = new UseThread();
		bThread.start();


	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}