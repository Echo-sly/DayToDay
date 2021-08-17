package designPatterns.factoryPattern.abstactFactory;

/**
 * Demo JavaCourseFactory
 *
 * @author sunlianyu
 * @date 2021/8/17 20:36
 */
public class PythonCourseFactory implements CourseFactory {
	@Override
	public INote createINote() {
		return new PythonNote();
	}

	@Override
	public IVideo createIVideo() {
		return new PythonVideo();
	}
}
