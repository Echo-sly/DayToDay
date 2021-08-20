package designPatterns.modelPattern;

/**
 * Demo NetworkCourse
 *
 * @author sunlianyu
 * @date 2021/8/20 16:10
 */
public abstract class NetworkCourse {
	public final void createCourse() {
		this.postPreResource();
		this.createPPT();
		this.liveVideo();
		this.postNote();
		this.postCose();
		if (needHomework()) {
			checkHomework();
		}
	}

	public boolean needHomework() {
		return false;
	}

	abstract void checkHomework();

	public final void postCose() {
		System.out.println("提交源代码");
	}

	public final void postNote() {
		System.out.println("提交笔记码");
	}

	public final void liveVideo() {
		System.out.println("面授课");
	}

	public final void createPPT() {
		System.out.println("创建PPT");
	}

	public final void postPreResource() {
		System.out.println("发布预习材料");
	}
}