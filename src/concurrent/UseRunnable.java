package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/14 16:33
 *
 * 使用 Runnable 接口来实现多线程开发
 */
public class UseRunnable implements Runnable {
	public static void main(String[] args) {

		UseThread aThread = new UseThread();
		UseThread bThread = new UseThread();

		aThread.start();
		bThread.start();

	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
