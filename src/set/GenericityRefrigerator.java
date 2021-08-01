package set;

import java.util.ArrayList;

/**
 * Author:sunlianyu
 * 2021/7/11 19:28
 * <p>
 * 作业：冰箱里的食物分别有：面包、香肠、薯片、牛奶
 * 分四次打开冰箱吃掉每一种食品
 * 分别输出每次打开冰箱后的剩余食品名称
 */
public class GenericityRefrigerator {

	public static void EatFromRefrigerator(ArrayList list, Object o) {

		list.remove(o);
		System.out.println("\n" + o + "刚刚被吃!!");
	}

	public static void main(String[] args) {

		ArrayList<Object> aRefrigerator = new ArrayList<>();//泛型

		aRefrigerator.add("面包");
		aRefrigerator.add("香肠");
		aRefrigerator.add("薯片");//薯片为什么要放冰箱里？？
		aRefrigerator.add("牛奶");

		EatFromRefrigerator(aRefrigerator, "面包");
		System.out.println("冰箱里还剩：");
		ArrayListFourEachFunction.ArrayListFirstEachFunction(aRefrigerator);//正好试试刚刚写的那几个遍历的方法
		EatFromRefrigerator(aRefrigerator, "薯片");
		System.out.println("冰箱里还剩：");
		ArrayListFourEachFunction.ArrayListSecondEachFunction(aRefrigerator);
		EatFromRefrigerator(aRefrigerator, "牛奶");
		System.out.println("冰箱里还剩：");
		ArrayListFourEachFunction.ArrayListThirdEachFunction(aRefrigerator);
		EatFromRefrigerator(aRefrigerator, "香肠");
		System.out.println(aRefrigerator.size() == 0 ? "冰箱空了！！！" : "冰箱里还剩：");
		ArrayListFourEachFunction.ArrayListFourthEachFunction(aRefrigerator);

	}
}
