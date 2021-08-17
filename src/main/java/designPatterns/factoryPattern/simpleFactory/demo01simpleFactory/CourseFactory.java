package designPatterns.factoryPattern.simpleFactory.demo01simpleFactory;

import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.Icourse;
import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.JavaCourse;
import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.PythonCourse;

/**
 * Demo CourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/16 18:09
 */
public class CourseFactory {
	public Icourse create(String name) {
		if ("java".equals(name)) {
			return new JavaCourse();
		} else if ("python".equals(name)) {
			return new PythonCourse();
		} else {
			return null;
		}
	}
}
