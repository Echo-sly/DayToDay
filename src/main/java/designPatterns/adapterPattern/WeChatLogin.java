package designPatterns.adapterPattern;

/**
 * Demo WeChatLogin
 *
 * @author sunlianyu
 * @date 2021/8/23 15:33
 */
public class WeChatLogin implements INewLogin {
	@Override
	public ResultMsg login(String id) {
		return new ResultMsg(200, "微信号码" + id + "登录成功！");
	}
}