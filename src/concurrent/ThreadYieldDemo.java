package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/15 21:41
 *
 * Thread.yield()方法的作用是：暂停当前正在执行的线程对象（即放弃当前拥有的cuo资源），并执行其他线程
 * yield()做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * 使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 */
public class ThreadYieldDemo extends Thread {
	public static void main(String[] args) {
		ThreadYieldDemo aThread = new ThreadYieldDemo();
		UseThread bThread = new UseThread();
		bThread.setPriority(10);
		bThread.start();
		aThread.start();

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
			if (i == 20) {
				Thread.yield();
			}
		}
	}

}
