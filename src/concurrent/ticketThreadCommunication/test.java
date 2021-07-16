package concurrent.ticketThreadCommunication;

/**
 * Author:sunlianyu
 * 2021/7/16 16:12
 */
public class test {
	public static void main(String[] args) {
		Ticket aticket = new Ticket();
		for (int i = 0; i < 10; i++) {
			Get aget = new Get(aticket);
			Refund arefund = new Refund(aticket);
			arefund.start();
			aget.start();

		}
	}
}
