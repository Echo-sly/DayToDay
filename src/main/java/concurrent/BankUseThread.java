package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/19 21:36
 */
public class BankUseThread {
	public static void main(String[] args) {
		Account account = new Account("15494",1000);
		Thread a = new Thread(){
			@Override
			public void run() {
				account.saveMoney(100);
			}

		};
		Thread b = new Thread(){
			@Override
			public void run() {
				account.getMoney(100);
			}
		};
		for (int i = 0; i < 100; i++) {
			b.run();
		}
	}

}
