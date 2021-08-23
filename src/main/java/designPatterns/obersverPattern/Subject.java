package designPatterns.obersverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo Subject
 *
 * @author sunlianyu
 * @date 2021/8/23 15:43
 */
public abstract class Subject {
	private String msg;
	private List<Observer> list = new ArrayList();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void attach(Observer observer) {
		list.add(observer);
	}

	public void detach(Observer observer) {
		list.remove(observer);
	}

	public void Notify() {
		for (Observer o : list) {
			o.update();
		}
	}

}