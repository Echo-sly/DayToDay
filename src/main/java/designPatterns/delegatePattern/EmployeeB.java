package designPatterns.delegatePattern;

/**
 * Demo EmployeeA
 *
 * @author sunlianyu
 * @date 2021/8/20 18:13
 */
public class EmployeeB implements IEmployee {
	@Override
	public void doing(String command) {

		System.out.println("我是员工B，我现在正在干" + command);
	}
}
