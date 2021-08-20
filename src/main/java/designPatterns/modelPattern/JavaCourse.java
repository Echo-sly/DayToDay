package designPatterns.modelPattern;

/**
 * Demo JavaCourse
 *
 * @author sunlianyu
 * @date 2021/8/20 16:11
 */
public class JavaCourse extends NetworkCourse {
	@Override
	void checkHomework() {
		System.out.println("检查Java的作业");
	}
}