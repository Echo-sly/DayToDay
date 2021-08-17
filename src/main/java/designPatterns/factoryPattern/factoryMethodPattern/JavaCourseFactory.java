package designPatterns.factoryPattern.factoryMethodPattern;

import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.Icourse;
import designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection.JavaCourse;

/**
 * Demo JavaCourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/16 18:36
 */
public class JavaCourseFactory implements ICourseFactory {
	@Override
	public Icourse create() {
		return new JavaCourse();
	}
}
