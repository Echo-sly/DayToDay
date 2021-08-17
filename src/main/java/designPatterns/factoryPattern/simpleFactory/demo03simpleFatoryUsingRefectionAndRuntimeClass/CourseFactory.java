package designPatterns.factoryPattern.simpleFactory.demo03simpleFatoryUsingRefectionAndRuntimeClass;

/**
 * Demo CourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/17 20:40
 */
public class CourseFactory {
	public Icourse create(Class<? extends Icourse> clazz) {
		if (null != clazz) {
			try {
				return clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
