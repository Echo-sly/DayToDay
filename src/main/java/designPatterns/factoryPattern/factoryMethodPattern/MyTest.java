package designPatterns.factoryPattern.factoryMethodPattern;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/16 18:38
 */
public class MyTest {
	public static void main(String[] args) {

		ICourseFactory factory1 = new PythonCourseFactory();
		factory1.create().record();
		ICourseFactory factory2 = new JavaCourseFactory();
		factory2.create().record();
	}
}
