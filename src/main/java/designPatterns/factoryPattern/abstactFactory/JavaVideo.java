package designPatterns.factoryPattern.abstactFactory;

/**
 * Demo JavaNote
 *
 * @author sunlianyu
 * @date 2021/8/16 18:49
 */
public class JavaVideo implements IVideo {

	@Override
	public void record() {
		System.out.println("录制JAVA课程");
	}
}
