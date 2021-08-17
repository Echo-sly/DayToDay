package designPatterns.singletonPattern.hungrySingleton;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/16 19:03
 */
public class MyTest {
	public static void main(String[] args) {
		System.out.println(HungrySingle.getInstance());
		System.out.println(HungrySingle.getInstance());
		System.out.println(HungrySingle.getInstance());
		System.out.println(HungrySingle.getInstance());
		System.out.println(HungrySingle.getInstance());
		System.out.println(HungrySingle.getInstance());
		System.out.println("-------------------------------");
		System.out.println(HungryStaticSingle.getInstance());
		System.out.println(HungryStaticSingle.getInstance());
		System.out.println(HungryStaticSingle.getInstance());
		System.out.println(HungryStaticSingle.getInstance());
	}

}
