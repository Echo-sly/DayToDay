package designPatterns.factoryPattern.abstactFactory;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/17 20:37
 */
public class MyTest {
	public static void main(String[] args) {
		JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
		PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
		javaCourseFactory.createIVideo().record();
		pythonCourseFactory.createINote().edit();
	}
}
