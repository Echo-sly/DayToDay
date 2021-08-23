package designPatterns.obersverPattern;

/**
 * Demo Test
 *
 * @author sunlianyu
 * @date 2021/8/23 15:44
 */
public class Test {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		subject.attach(new ConcreteObserver("MIKE", subject));
		subject.attach(new ConcreteObserver("JACK", subject));
		subject.attach(new ConcreteObserver("TOM", subject));
		ConcreteObserver c = new ConcreteObserver("NIKE", subject);
		subject.attach(c);
		subject.detach(c);
		subject.setMsg("阿富汗被灭了！");
		subject.Notify();
	}
}