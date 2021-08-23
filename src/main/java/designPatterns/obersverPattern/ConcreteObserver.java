package designPatterns.obersverPattern;

/**
 * Demo sd
 *
 * @author sunlianyu
 * @date 2021/8/23 15:40
 */
public class ConcreteObserver extends Observer {
	private String name;
	private Subject subject;

	public ConcreteObserver(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
	}

	@Override
	public void update() {
		String msg;
		msg = subject.getMsg();
		System.out.println(name + "知道了" + msg + ",非常痛苦！");
	}

}