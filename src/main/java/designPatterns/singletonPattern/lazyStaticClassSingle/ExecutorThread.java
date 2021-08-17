package designPatterns.singletonPattern.lazyStaticClassSingle;

/**
 * Demo ExecutorThread
 *
 * @author sunlianyu
 * @date 2021/8/16 19:32
 */
public class ExecutorThread implements Runnable {
	@Override
	public void run() {
		LazyStaticClassSingle s = LazyStaticClassSingle.getInstance();
		System.out.println(Thread.currentThread().getName() + s);

	}
}
