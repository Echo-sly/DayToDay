package concurrent.netBar;

import java.util.concurrent.DelayQueue;

/**
 * Author:sunlianyu
 * 2021/7/21 22:16
 */

public class NetBar implements Runnable  {

	private boolean flag=true;
	private DelayQueue<Person> delayQueue=new DelayQueue();

	private void up(String name,String id,int money){

		Person s=new Person(name,id, 1000L *money+System.currentTimeMillis());

		delayQueue.add(s);

		System.out.println(name+"进来了"+"上机"+money+"秒；");
	}
	// 下机
	public void down(Person man){
		System.out.println("姓名"+man.getName()+" 身份证"+man.getId()+"时间到下机...");
	}

	@Override
	public void run() {
		while(flag){
			try {
				Person s=delayQueue.take();
				down(s);
				System.out.println(s.getName()+"下线了");
				if(delayQueue.isEmpty()){
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("网吧开始营业！！！");
		NetBar bar=new NetBar();
		Thread t=new Thread(bar);
		bar.up("sunlianyu","1904010612",20);
		bar.up("lihua","1904010000",5);
		bar.up("hanmeimei","190000000",8);
		t.start();
	}
}
