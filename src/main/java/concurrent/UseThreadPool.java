package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:sunlianyu
 * 2021/7/14 16:39
 *
 * 使用线程池来进行并发开发
 */
public class UseThreadPool {
	public static void main(String[] args) {

		ExecutorService aThreadPool = Executors.newCachedThreadPool();
		athread athread = new athread();
		aThreadPool.submit(athread);
		aThreadPool.submit(athread);
		aThreadPool.submit(athread);

	}

	static class athread extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		}
	}
}
