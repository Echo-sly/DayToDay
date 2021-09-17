package designPatterns.delegatePattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo Leader
 *
 * @author sunlianyu
 * @date 2021/8/20 18:15
 */
public class Leader implements IEmployee {

	private Map<String, IEmployee> tar = new HashMap<>();

	public Leader() {
		tar.put("加密", new EmployeeA());
		tar.put("数据库", new EmployeeB());
	}

	@Override
	public void doing(String command) {
		tar.get(command).doing(command);

	}
}
