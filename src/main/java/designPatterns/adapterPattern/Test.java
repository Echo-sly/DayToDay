package designPatterns.adapterPattern;

/**
 * Demo Test
 *
 * @author sunlianyu
 * @date 2021/8/23 15:36
 */
public class Test {
	public static void main(String[] args) {
		IOldNewAdapter oldNewAdapter = new OldNewLoginAdapter();
		System.out.println(oldNewAdapter.loginForPassword("sunlianyu", "999999"));

		System.out.println(oldNewAdapter.loginForQQ("123456"));
		System.out.println(oldNewAdapter.loginForWechat("456789"));

	}
}
