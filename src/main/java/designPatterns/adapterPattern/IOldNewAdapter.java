package designPatterns.adapterPattern;

public interface IOldNewAdapter {
	ResultMsg loginForQQ(String id);

	//微信
	ResultMsg loginForWechat(String id);

	//
	ResultMsg loginForPassword(String username, String password);
}
