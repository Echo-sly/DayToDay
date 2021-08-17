package designPatterns.factoryPattern.factoryMethodPattern;

import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.Icourse;
import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.PythonCourse;

/**
 * Demo PythonCourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/16 18:37
 */
public class PythonCourseFactory implements ICourseFactory {
	@Override
	public Icourse create() {
		return new PythonCourse();
	}
}
