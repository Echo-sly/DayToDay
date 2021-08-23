package designPatterns.delegatePattern;

/**
 * Demo test
 *
 * @author sunlianyu
 * @date 2021/8/20 18:22
 */
public class test {
	public static void main(String[] args) {
		new Boss().command("数据库", new Leader());
		new Boss().command("加密", new Leader());
	}
}
