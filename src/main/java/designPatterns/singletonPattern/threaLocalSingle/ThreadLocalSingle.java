package designPatterns.singletonPattern.threaLocalSingle;

/**
 * Demo ThreadLocalSingle
 *
 * @author sunlianyu
 * @date 2021/8/17 21:09
 */
public class ThreadLocalSingle {
	private static final ThreadLocal<ThreadLocalSingle> THREAD_LOCAL = new ThreadLocal<ThreadLocalSingle>() {
		@Override
		protected ThreadLocalSingle initialValue() {
			return new ThreadLocalSingle();
		}
	};

	private ThreadLocalSingle() {
	}

	public static ThreadLocalSingle getInstance() {
		return THREAD_LOCAL.get();
	}
}

class E implements Runnable {

	@Override
	public void run() {
		ThreadLocalSingle threadLocalSingle = ThreadLocalSingle.getInstance();
		System.out.println(Thread.currentThread().getName() + ":" + threadLocalSingle);
	}
}
