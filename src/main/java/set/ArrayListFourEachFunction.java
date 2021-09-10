package set;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Author:sunlianyu
 * 2021/7/11 19:07
 */
public class ArrayListFourEachFunction {
    //第一种for循环遍历方法
    public static void arrayListFirstEachFunction(ArrayList List) {
        for (int i = 0; i < List.size(); i++) {
            System.out.print(List.get(i) + " ");
        }
    }

    //第二种迭代器遍历方法
    public static void ArrayListSecondEachFunction(ArrayList List) {
        Iterator it = List.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    //第三种 foreach
    public static void ArrayListThirdEachFunction(ArrayList List) {
        for (Object o : List) {
            System.out.print(o + " ");
        }
    }

    //第四种 lamda表达式
    public static void arrayListFourthEachFunction(ArrayList List) {
//        List.forEach(System.out::println);//lamda 表达式写法
        List.forEach(a -> System.out.print(a + " "));  //等同于上一行
    }

    //第五种转成数组再遍历 略
    public static void main(String[] args) {
        ArrayList<Integer> alist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            alist.add(i);
        }
        arrayListFirstEachFunction(alist);
        ArrayListSecondEachFunction(alist);
        ArrayListThirdEachFunction(alist);

    }
}
