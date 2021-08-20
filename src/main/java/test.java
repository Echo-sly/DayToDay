import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Author:sunlianyu
 * 2021/8/4 22:10
 *
 * @author S
 */
public class test {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			boolean flag = false;
			String a = scanner.next();
			StringBuilder str = new StringBuilder();
			boolean flag1 = false;
			for (int i = 0; i < a.length(); i++) {

				if (a.charAt(i) == ' ' && !flag) {
					continue;
				}
				if (a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) >= '0' && a.charAt(i) <= '9') {
					flag = true;
					str.append(a.charAt(i));
				}
				if ((a.charAt(i) <= '0' || a.charAt(i) >= '9') && flag) {
					break;
				}
				if ((a.charAt(i) <= '0' || a.charAt(i) >= '9') && (a.charAt(i + 1) <= '0' || a.charAt(i + 1) >= '9')) {
					flag1 = true;
					break;
				}
			}
//			System.out.println(str);
			Long res = Long.parseLong(String.valueOf(str));


			if (flag1) {
				System.out.println("0");
				return;
			}
			if (res < Integer.MIN_VALUE) {
				res = (long) Integer.MIN_VALUE;
			}
			if (res > Integer.MAX_VALUE) {
				res = (long) Integer.MAX_VALUE;
			}
			System.out.println(res);

		}
	}

	@Test
	public void myTest() {
		String str1 = new StringBuilder("ja").append("va").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str2.intern() == str2);
	}
}