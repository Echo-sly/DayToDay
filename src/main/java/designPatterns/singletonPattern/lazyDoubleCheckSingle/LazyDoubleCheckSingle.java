package designPatterns.singletonPattern.lazyDoubleCheckSingle;

/**
 * Demo LazyDoubleCheckSingle
 *
 * @author sunlianyu
 * @date 2021/8/16 19:42
 */
public class LazyDoubleCheckSingle {
	private volatile static LazyDoubleCheckSingle l = null;

	private LazyDoubleCheckSingle() {
	}

	public static LazyDoubleCheckSingle getInstance() {
		if (l == null) {
			synchronized (LazyDoubleCheckSingle.class) {
				if (l == null) {
					l = new LazyDoubleCheckSingle();
				}
			}
		}
		return l;
	}
}
