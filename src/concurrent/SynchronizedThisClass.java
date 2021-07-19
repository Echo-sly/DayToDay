package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/19 17:59
 */
public class SynchronizedThisClass {
	public static void main(String[] args) {
		aThread a = new aThread();
		aThread b = new aThread();

		new Thread(new Runnable(){

			@Override
			public void run() {
				a.ok();
			}
		}).start();

		new Thread(new Runnable(){

			@Override
			public void run() {
				b.ok1();
			}
		}).start();

	}

static class aThread {
		private String lockName1 = "A";
		private String lockName2 = "B";

		public aThread() {
		}

		void ok() {
			synchronized (lockName1) {//把lockname1改为 aThread.class 即为锁类 当前为锁对象
				try {
					for (int i = 1; i < 30; i++) {
						System.out.println("OK执行" + i + "次！");
						Thread.sleep(300);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		void ok1() {
			synchronized (lockName2) {//把lockname2改为 aThread.class 即为锁类 当前为锁对象
				try {
					for (int i = 1; i < 30; i++) {
						System.out.println("OK1执行" + i + "次！");
						Thread.sleep(300);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}