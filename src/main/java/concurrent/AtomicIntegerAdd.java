package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:sunlianyu
 * 2021/7/21 22:15
 */
public class AtomicIntegerAdd implements Runnable {

	private static AtomicInteger count=new AtomicInteger(0);//原子

	public static void main(String[] args) {
		AtomicIntegerAdd a = new AtomicIntegerAdd();
		AtomicIntegerAdd a1 = new AtomicIntegerAdd();
		Thread t = new Thread(a);
		t.setName("A:");
		t.start();
		Thread t1 = new Thread(a1);
		t1.setName("B:");
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("最终值：" + count);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + count.incrementAndGet());
		}
	}
}