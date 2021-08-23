package designPatterns.adapterPattern;

/**
 * Demo OldLogin
 *
 * @author sunlianyu
 * @date 2021/8/23 15:31
 */
public class OldLogin {
	public ResultMsg login(String username, String msg) {
		return new ResultMsg(200, "登录成功！");
	}

}
