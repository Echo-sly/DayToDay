package concurrent.ticketThreadCommunication;

/**
 * Author:sunlianyu
 * 2021/7/16 16:08
 */
public class Get extends Thread{
	Ticket aticket ;

	public Get(Ticket aticket){
		this.aticket = aticket;
	}

	@Override
	public void run() {
		aticket.getTicket();
	}
}
