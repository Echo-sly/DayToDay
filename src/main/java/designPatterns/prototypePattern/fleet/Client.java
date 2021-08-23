package designPatterns.prototypePattern.fleet;

/**
 * Demo Client
 *
 * @author sunlianyu
 * @date 2021/8/18 18:15
 */
public class Client {

	public Prototype startClone(Prototype prototype1) {
		return prototype1.clone();
	}

}
