package designPatterns.strategyPattern;

/**
 * Demo Test
 *
 * @author sunlianyu
 * @date 2021/8/20 18:52
 */
public class Test {
	public static void main(String[] args) {
		Order order = new Order("1", "00001", 100.0);
		System.out.println(order.pay());

	}
}
