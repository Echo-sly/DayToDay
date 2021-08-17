package designPatterns.factoryPattern.abstactFactory;

/**
 * Demo JavaCourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/17 20:36
 */
public class JavaCourseFactory implements CourseFactory{
	@Override
	public INote createINote() {
		return new JavaNote();
	}

	@Override
	public IVideo createIVideo() {
		return new JavaVideo();
	}
}
