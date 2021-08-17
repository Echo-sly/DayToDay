package designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection;

/**
 * Demo SimpleFactoryTest
 *
 * @author sunlianyu
 * @date 2021/8/16 18:20
 */
public class SimpleFactoryTest {
	public static void main(String[] args) {
		CourseFactory courseFactory = new CourseFactory();
		Icourse icourse = courseFactory.create("designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.JavaCourse");
		icourse.record();
		Icourse icourse1 = courseFactory.create("designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.PythonCourse");
		icourse1.record();
	}

}
