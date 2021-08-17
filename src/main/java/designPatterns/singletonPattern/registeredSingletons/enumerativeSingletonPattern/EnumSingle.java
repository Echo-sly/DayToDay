package designPatterns.singletonPattern.registeredSingletons.enumerativeSingletonPattern;

/**
 * @author S
 */

@SuppressWarnings("all")
public enum EnumSingle {
	INSTANCE;
	
	private Object data;

	EnumSingle() {
		this.data = data;
	}

	public static EnumSingle getInstance() {
		return INSTANCE;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
