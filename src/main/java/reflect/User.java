package reflect;

import lombok.Data;

/**
 * Demo User
 *
 * @author sunlianyu
 * @date 2021/8/15 20:01
 */
@Data
public class User {
	private int id;
	private int age;
	private String name;

	public User(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public User() {
	}
}
