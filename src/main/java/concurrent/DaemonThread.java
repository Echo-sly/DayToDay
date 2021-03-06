package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/15 21:59
 */
public class DaemonThread {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + "running");
				Thread.sleep(10000);
				System.out.println(Thread.currentThread().getName() + "done");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		t.setDaemon(true);
		t.start();
		System.out.println("main done");
	}
}