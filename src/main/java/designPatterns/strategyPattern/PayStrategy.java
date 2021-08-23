package designPatterns.strategyPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo PayStrategy
 *
 * @author sunlianyu
 * @date 2021/8/20 18:44
 */
public class PayStrategy {
	public static final String ALI_PAY = "AliPay";
	public static final String JD_PAY = "JDPay";
	public static final String DEFAULT_PAY = "Ali_Pay";

	private static Map<String, Payment> map = new HashMap();

	static {
		map.put(ALI_PAY, new AliPay());
		map.put(JD_PAY, new JDPay());
		map.put(DEFAULT_PAY, new AliPay());
	}

	public static Payment get(String payKey) {
		if (!map.containsKey(payKey)) {
			return map.get(DEFAULT_PAY);
		}
		return map.get(payKey);
	}
}
