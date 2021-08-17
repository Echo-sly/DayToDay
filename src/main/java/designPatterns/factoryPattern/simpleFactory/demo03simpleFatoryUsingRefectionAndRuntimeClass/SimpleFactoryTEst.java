package designPatterns.factoryPattern.simpleFactory.demo03simpleFatoryUsingRefectionAndRuntimeClass;

/**
 * Demo SimpleFactoryTEst
 *
 * @author sunlianyu
 * @date 2021/8/17 20:42
 */
public class SimpleFactoryTEst {
	public static void main(String[] args) {
		CourseFactory courseFactory = new CourseFactory();
		Icourse icourse = courseFactory.create(JavaCourse.class);
		icourse.record();
	}
}
