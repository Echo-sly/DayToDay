package concurrent;

/**
 * Author:sunlianyu
 * 2021/7/19 21:32
 */
public class Account {
	private String cardNo;
	private long blance;

	public Account(String cardNo, long blance) {
		this.cardNo = cardNo;
		this.blance = blance;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public long getBlance() {
		return blance;
	}

	public void setBlance(long blance) {
		this.blance = blance;
	}

	synchronized void getMoney(int money){
		if(getBlance()>money) {
			blance -= money;
			System.out.println("取到了" + money + "还剩余" + getBlance());
		}else {
			System.out.println("余额不足");
		}
	}
	synchronized void saveMoney(int money){
		blance+=money;
		System.out.println("存进了"+money+"还剩余"+getBlance());

	}
}
