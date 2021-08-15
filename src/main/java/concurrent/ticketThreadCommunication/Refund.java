package concurrent.ticketThreadCommunication;

/**
 * Author:sunlianyu
 * 2021/7/16 16:11
 */
public class Refund extends Thread{
	Ticket aticket ;

	public Refund(Ticket aticket) {
		this.aticket = aticket;
	}

	@Override
	public void run() {
		aticket.refundTicket();
	}
}
