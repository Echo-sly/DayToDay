package designPatterns.proxyPattern.staticProxy;

/**
 * Demo Father
 *
 * @author sunlianyu
 * @date 2021/8/18 19:04
 */

public class Father implements IPerson {
	Son son = new Son();

	public Father() {
	}

	@Override
	public void findlove() {
		System.out.println("父亲物色对象");

		System.out.println("-----------");

	}
}
