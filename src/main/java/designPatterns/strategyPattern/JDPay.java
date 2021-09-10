package designPatterns.strategyPattern;

/**
 * Demo AliPay
 *
 * @author sunlianyu
 * @date 2021/8/20 18:43
 */
public class JDPay extends Payment {
	@Override
	public String getName() {
		return "京东白条";
	}

	@Override
	public double queryBalance(String uid) {
		return 400;
	}
}
