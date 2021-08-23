package designPatterns.strategyPattern;

/**
 * Demo Order
 *
 * @author sunlianyu
 * @date 2021/8/20 18:48
 */
public class Order {
	private String uid;
	private String orderId;
	private Double amount;

	public Order(String uid, String orderId, Double amount) {
		this.uid = uid;
		this.orderId = orderId;
		this.amount = amount;
	}

	public PayState pay() {
		return pay(PayStrategy.DEFAULT_PAY);
	}

	public PayState pay(String payKey) {
		Payment payment = PayStrategy.get(payKey);
		System.out.println("欢迎使用" + payment.getName());
		System.out.println("");
		return payment.pay(uid, amount);
	}


}
