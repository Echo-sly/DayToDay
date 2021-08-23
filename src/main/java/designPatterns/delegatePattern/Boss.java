package designPatterns.delegatePattern;

/**
 * Demo Boss
 *
 * @author sunlianyu
 * @date 2021/8/20 18:21
 */
public class Boss {
	public void command(String conmmand, Leader leader) {
		leader.doing(conmmand);
	}


}
