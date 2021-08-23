package designPatterns.modelPattern;

/**
 * Demo sdad
 *
 * @author sunlianyu
 * @date 2021/8/20 16:11
 */
public class BigCourse extends NetworkCourse {
	@Override
	public boolean needHomework() {
		return true;
	}

	@Override
	void checkHomework() {
		System.out.println("检查大数据作业");
	}
}