package designPatterns.modelPattern;

/**
 * Demo MyTest
 *
 * @author sunlianyu
 * @date 2021/8/20 16:12
 */
public class MyTest {
	public static void main(String[] args) {
		NetworkCourse n = new JavaCourse();
		n.createCourse();
		System.out.println("------------");
		NetworkCourse b = new BigCourse();
		b.createCourse();
	}
}
