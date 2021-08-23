package designPatterns.adapterPattern;

/**
 * Demo NewLoginAdapter
 *
 * @author sunlianyu
 * @date 2021/8/23 15:32
 */
public class OldNewLoginAdapter extends OldLogin implements IOldNewAdapter {
	@Override
	public ResultMsg loginForQQ(String id) {
		return factory(id, QQLogin.class);
	}

	@Override
	public ResultMsg loginForWechat(String id) {
		return factory(id, WeChatLogin.class);
	}

	@Override
	public ResultMsg loginForPassword(String username, String password) {
		login(username, password);
		return new ResultMsg(200, "用户名密码登录成功！");
	}

	//简单工厂模式及策略模式
	public ResultMsg factory(String id, Class<? extends INewLogin> clazz) {
		try {
			INewLogin adapter = clazz.newInstance();
			return adapter.login(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}