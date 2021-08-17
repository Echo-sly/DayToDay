package designPatterns.singletonPattern.hungrySingleton;

/**
 * Demo HungrySingle
 *
 * @author sunlianyu
 * @date 2021/8/16 19:03
 */
public class HungrySingle {

	private static final HungrySingle s = new HungrySingle();

	private HungrySingle() {

	}

	public static HungrySingle getInstance() {
		return s;
	}

}
