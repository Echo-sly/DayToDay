package designPatterns.singletonPattern.lazyDoubleCheckSingle;

import designPatterns.singletonPattern.lazySingleton.SimpleLazySingleton;

/**
 * Demo ExecutorThread
 *
 * @author sunlianyu
 * @date 2021/8/16 19:32
 */
public class ExecutorThread implements Runnable {
	@Override
	public void run() {
		LazyDoubleCheckSingle s = LazyDoubleCheckSingle.getInstance();
		System.out.println(Thread.currentThread().getName() + s);

	}
}
