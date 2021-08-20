package designPatterns.prototypePattern.deep;

import java.io.Serializable;

/**
 * Demo GoldenCudgel
 *
 * @author sunlianyu
 * @date 2021/8/18 18:35
 */
public class GoldenCudgel implements Serializable {
	public float height = 100;
	public float weight = 10;

	public void big() {
		height *= 2;
		weight *= 2;
	}

	public void small() {
		height /= 2;
		weight /= 2;
	}
}
