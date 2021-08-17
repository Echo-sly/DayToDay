package designPatterns.factoryPattern.simpleFactory.demo01simpleFactory;

/**
 * Demo Factory
 *
 * @author sunlianyu
 * @date 2021/8/16 18:02
 */

public class SimpleFactoryTest {
	public static void main(String[] args) {
		CourseFactory courseFactory = new CourseFactory();
		courseFactory.create("python").record();
		courseFactory.create("java").record();
	}
}
