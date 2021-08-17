package designPatterns.singletonPattern.lazySingleton;

/**
 * Demo SimpleLazySingleton
 *
 * @author sunlianyu
 * @date 2021/8/16 19:27
 */
public class SimpleLazySingleton {
	private static SimpleLazySingleton lazy = null;

	private SimpleLazySingleton() {
	}

	public static SimpleLazySingleton getInstance() {
		if (lazy == null) {
			lazy = new SimpleLazySingleton();
		}
		return lazy;
	}
}
