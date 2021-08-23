package designPatterns.adapterPattern;

/**
 * Demo ResultMsg
 *
 * @author sunlianyu
 * @date 2021/8/20 19:20
 */
public class ResultMsg {
	private int code;
	private String msg;

	public ResultMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResultMsg{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				'}';
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
