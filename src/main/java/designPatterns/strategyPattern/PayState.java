package designPatterns.strategyPattern;

/**
 * Demo PayState
 *
 * @author sunlianyu
 * @date 2021/8/20 18:36
 */
public class PayState {
	private int code;
	private Object data;
	private String msg;

	public PayState(int code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "PayState{" +
				"code=" + code +
				", data=" + data +
				", msg='" + msg + '\'' +
				'}';
	}

}
