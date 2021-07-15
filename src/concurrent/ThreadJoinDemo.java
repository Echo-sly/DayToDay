package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/15 21:25
 * t.join()方法只会使主线程(或者说调用t.join()的线程)进入等待池并等待t线程执行完毕后才会被唤醒。
 * 并不影响同一时刻处在运行状态的其他线程。
 */
public class ThreadJoinDemo extends Thread {
	public static void main(String[] args) {
		ThreadJoinDemo aThread = new ThreadJoinDemo();
		aThread.start();
		for (int i = 0; i < 100 ; i++ ){
			if (i == 10){
				try {
					aThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
				System.out.println(Thread.currentThread().getName() + "   :   " + i);
		}
	}
}
