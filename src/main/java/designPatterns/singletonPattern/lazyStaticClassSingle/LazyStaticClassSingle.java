package designPatterns.singletonPattern.lazyStaticClassSingle;

/**
 * Demo LazyStaticClassSingle
 *
 * @author sunlianyu
 * @date 2021/8/16 19:51
 */
public class LazyStaticClassSingle {
	private LazyStaticClassSingle() {
	}

	static final LazyStaticClassSingle getInstance() {
		return lazyHolder.LAZY;
	}

	private static class lazyHolder {
		private static final LazyStaticClassSingle LAZY = new LazyStaticClassSingle();
	}
}
