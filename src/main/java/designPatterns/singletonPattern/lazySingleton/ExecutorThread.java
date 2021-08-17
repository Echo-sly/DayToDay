package designPatterns.singletonPattern.lazySingleton;

/**
 * Demo ExecutorThread
 *
 * @author sunlianyu
 * @date 2021/8/16 19:32
 */
public class ExecutorThread implements Runnable {
	@Override
	public void run() {
		SimpleLazySingleton s = SimpleLazySingleton.getInstance();
		System.out.println(Thread.currentThread().getName() + s);

	}
}
