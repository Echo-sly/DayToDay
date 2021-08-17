package designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection;

/**
 * Demo JavaCourse
 *
 * @author sunlianyu
 * @date 2021/8/16 18:08
 */
public class JavaCourse implements Icourse {
	@Override
	public void record() {
		System.out.println("java正在记录");
	}
}
