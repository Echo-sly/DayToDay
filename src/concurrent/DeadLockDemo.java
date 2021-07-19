package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/19 17:36
 * This is a DeadLock demo!!
 */
public class DeadLockDemo {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		aThread a = new aThread(o1, o2);
		bThread b = new bThread(o1, o2);
		b.start();
		a.start();
	}

	static class aThread extends Thread {
		Object o1;
		Object o2;

		public aThread(Object o1, Object o2) {
			this.o1 = o1;
			this.o2 = o2;
		}

		@Override
		public void run() {
			synchronized (o1) {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("o2");
				}
			}

		}
	}

	static class bThread extends Thread {
		Object o1;
		Object o2;

		public bThread(Object o1, Object o2) {
			this.o1 = o1;
			this.o2 = o2;
		}

		@Override
		public void run() {
			synchronized (o2) {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("o1");
				}
			}

		}
	}
}
