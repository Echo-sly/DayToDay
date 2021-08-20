package designPatterns.prototypePattern.deep;

/**
 * Demo Test
 *
 * @author sunlianyu
 * @date 2021/8/18 18:45
 */
public class Test {
	public static void main(String[] args) {
		SuperMonkey qitiandasheng = new SuperMonkey();

		SuperMonkey newMonkey;
		try {
			newMonkey = (SuperMonkey) qitiandasheng.clone();
			System.out.println(qitiandasheng == newMonkey);
			System.out.println(qitiandasheng.birthday);
			System.out.println(newMonkey.height);
			System.out.println(qitiandasheng.height);
			System.out.println(qitiandasheng.goldenCudgel.height);
			System.out.println(newMonkey.goldenCudgel.height);
			System.out.println(newMonkey.weight);
			System.out.println(newMonkey.birthday);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


	}
}
