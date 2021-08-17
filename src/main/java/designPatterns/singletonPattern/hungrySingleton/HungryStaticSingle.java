package designPatterns.singletonPattern.hungrySingleton;

/**
 * Demo HungryStaticSingle
 *
 * @author sunlianyu
 * @date 2021/8/16 19:09
 */
public class HungryStaticSingle {
	private static final HungryStaticSingle h;

	static {
		h = new HungryStaticSingle();
	}

	static HungryStaticSingle getInstance() {
		return h;
	}
}
