package designPatterns.strategyPattern;

/**
 * Demo AliPay
 *
 * @author sunlianyu
 * @date 2021/8/20 18:43
 */
public class AliPay extends Payment {
	@Override
	public String getName() {
		return "支付宝";
	}

	@Override
	public double queryBalance(String uid) {
		return 200;
	}
}
