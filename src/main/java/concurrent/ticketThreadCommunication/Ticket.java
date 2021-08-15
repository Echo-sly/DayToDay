package concurrent.ticketThreadCommunication;

/**
 * Author:sunlianyu
 * 2021/7/16 15:55
 */
public class Ticket {
	private String name;
	private int quantity;//票的总数
	private boolean flag;//是否有余票

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public synchronized void getTicket() {
		if (flag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			quantity--;
			System.out.println("已经抢到一张票，" + "剩余票：" + quantity);
				flag = false;
			notifyAll();
		} else {
			System.out.println("已经没有票了！该线程进入阻塞状态！");
			try {
				System.out.println("------------------");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public synchronized void refundTicket(){
		if (!flag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			quantity+= 1;
			System.out.println("有人退了"+"1"+"张票，"+ "剩余票：" + quantity);
			flag = true;
			notifyAll();
		} else {
			System.out.println("还有余票，请等待！");
			try {
				System.out.println("------------------");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
