package designPatterns.factoryPattern.simpleFactory.demo02simpleFactoryUsingRefection;

/**
 * Demo CourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/16 18:18
 */
public class CourseFactory {
	public Icourse create(String name) {

		if (name != null && !name.equals("")) {
			try {
				return (Icourse) Class.forName(name).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
