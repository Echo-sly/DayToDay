package designPatterns.prototypePattern.fleet;

/**
 * Demo ConcretePrototyoeA
 *
 * @author sunlianyu
 * @date 2021/8/18 18:13
 */
public class ConcretePrototyoeA implements Prototype {

	Integer age;
	String name;
	String hobbies;

	@Override
	public String toString() {
		return "ConcretePrototyoeA{" +
				"age=" + age +
				", name='" + name + '\'' +
				", hobbies='" + hobbies + '\'' +
				'}';
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public Prototype clone() {
		ConcretePrototyoeA concretePrototyoeA = new ConcretePrototyoeA();
		concretePrototyoeA.setAge(this.age);
		concretePrototyoeA.setName(this.name);
		concretePrototyoeA.setHobbies(this.hobbies);
		return concretePrototyoeA;
	}
}
