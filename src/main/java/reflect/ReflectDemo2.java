package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Demo ReflectDemo2
 *
 * @author sunlianyu
 * @date 2021/8/15 20:15
 */
public class ReflectDemo2 {
	@Test
	public void reflectCon() {
		try {
			// class [User] --->Class--->c[你-对象]
			Class<?> c = Class.forName("reflect.User");
			//1加载类到内存中
			Constructor con = c.getConstructor();
			//默认构造器
			User p = (User) con.newInstance();
			//User p=new User();
			p.setName("NICE");
			System.out.println(p.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void reflectArray() {
		try {

			Object o = Array.newInstance(String.class, 5);

			Array.set(o, 0, "1");
			Array.set(o, 1, "2");
			Array.set(o, 2, "3");
			System.out.println(Array.get(o, 2));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void reflectField() {
		try {
			Class<?> c = Class.forName("org.weikun.a.User");

			Constructor<?> con = c.getConstructor();
			User p = (User) con.newInstance();

			Field f = c.getDeclaredField("name");
			f.setAccessible(true);
			f.set(p, "MARY");
			//p.name="MARY"
			System.out.println(f.get(p));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void reflectMethod() {
		try {
			Class<?> c = Class.forName("reflect.User");

			Constructor<?> con = c.getConstructor();
			User p = (User) con.newInstance();

			Method m = c.getMethod("setName", String.class);
			m.invoke(p, "ALICE");
			//p.setName
			Method m1 = c.getMethod("getName");

			System.out.println(m1.invoke(p));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void reflectNonCon() {
		try {

			Class<?> c = Class.forName("reflect.User");

			Constructor<?> con = c.getConstructor(int.class, int.class, String.class);

			User p = (User) con.newInstance(100, 1, "sunlianyu");

			System.out.println(p);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
