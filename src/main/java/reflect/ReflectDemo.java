package reflect;

import java.lang.annotation.ElementType;

/**
 * Demo ReflectDemo
 *
 * @author sunlianyu
 * @date 2021/8/15 19:59
 */
public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class<?> aClass = Class.forName("reflect.User");
			System.out.println(aClass);
			Class<?> bClass = Class.forName("reflect.User");
			System.out.println(aClass.hashCode());
			System.out.println(bClass.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("----------------------");
		User auser = new User();

		Class c1 = auser.getClass();
//通过对象来获得
		Class c2 = Class.forName("reflect.User");
//通过字符串来获得（包名+类名）
		Class c3 = User.class;
//通过类的静态成员class获得
		Class c4 = Integer.TYPE;
//只针对内置的基本数据与类型
		Class c5 = c2.getSuperclass();
		//获得父类的类型
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);


		System.out.println("******************************");

		Class b1 = Object.class;
		Class b2 = Comparable.class;
		Class b3 = String[].class;
		Class b4 = int[][].class;
		Class b5 = ElementType.class;
		Class b6 = Override.class;
		Class b7 = Integer.class;
		Class b8 = void.class;
		Class b9 = Class.class;
		int[] a = new int[10];
		int[] b = new int[100];
		Class b10 = a.getClass();
		Class b11 = b.getClass();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b7);
		System.out.println(b8);
		System.out.println(b9);
		System.out.println(b10);
		System.out.println(b11);
		//只要元素类型与维度一样,就是同一个Class System.out.println(c11==c10);
	}
}
