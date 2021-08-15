package concurrent.netBar;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * Author:sunlianyu
 * 2021/7/21 22:17
 */


public class Person implements Delayed {

	private String name;
	private String id;
	private long endTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public Person(String name, String id, long endTime) {
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}

	private TimeUnit unit=TimeUnit.MILLISECONDS;

	@Override
	public long getDelay(TimeUnit unit) {
		return endTime-System.currentTimeMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		Person s=(Person)o;
		return (int)(this.getDelay(this.unit)-s.getDelay(this.unit));
	}
}