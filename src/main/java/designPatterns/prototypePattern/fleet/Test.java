package designPatterns.prototypePattern.fleet;

/**
 * Demo Test
 *
 * @author sunlianyu
 * @date 2021/8/18 18:18
 */
public class Test {
	public static void main(String[] args) {
		//create a
		ConcretePrototyoeA concretePrototyoeA = new ConcretePrototyoeA();

		concretePrototyoeA.setHobbies("111111");
		concretePrototyoeA.setAge(1000);
		concretePrototyoeA.setName("bob");
		Client client = new Client();


		ConcretePrototyoeA prototype = (ConcretePrototyoeA) client.startClone(concretePrototyoeA);


		System.out.println(prototype.getHobbies() == concretePrototyoeA.getHobbies());
		System.out.println(prototype.getAge() == concretePrototyoeA.getAge());
		System.out.println(prototype);
		System.out.println(concretePrototyoeA.hashCode());
		System.out.println(prototype.hashCode());

	}
}
