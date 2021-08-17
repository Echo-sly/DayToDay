package designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection;

/**
 * Demo PythonCourse
 *
 * @author sunlianyu
 * @date 2021/8/16 18:08
 */
public class PythonCourse implements Icourse {
	@Override
	public void record() {
		System.out.println("python正在记录");
	}
}
