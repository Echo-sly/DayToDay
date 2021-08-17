package designPatterns.factoryPattern.factoryMethodPattern;

import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.Icourse;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/16 18:38
 */
public class MyTest {
	public static void main(String[] args) {

		ICourseFactory factory1 = new PythonCourseFactory();
		Icourse icourse1 = factory1.create();
		icourse1.record();
		ICourseFactory factory2 = new JavaCourseFactory();
		Icourse icourse2 = factory2.create();
		icourse2.record();

	}
}
