package designPatterns.singletonPattern.registeredSingletons.ContainerSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Demo ContainerSingleton
 *
 * @author sunlianyu
 * @date 2021/8/17 20:56
 */
public class ContainerSingleton {

	private static final Map<String, Object> singleMap = new ConcurrentHashMap<>();

	private ContainerSingleton() {
	}

	public static void putInstance(String key, Object instance) {
		if (!"".equals(key) && instance != null) {
			if (!singleMap.containsKey(key)) {
				singleMap.put(key, instance);
			}
		}
	}

	public static Object getInstance(String key) {
		return singleMap.get(key);
	}
}

class T implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			ContainerSingleton.putInstance("object", new Object());
			Object instance = ContainerSingleton.getInstance("object");
			System.out.println(Thread.currentThread().getName() + ":" + instance);

		}
	}
}
