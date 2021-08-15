package set;

import java.util.*;

/**
 * Author:sunlianyu
 * 2021/7/12 17:37
 * HashMap的打印和排序
 */
public class MapSort {

	public static void main(String[] args) {

		Map<String, Integer> amap = new HashMap<>();

		amap.put("A", 5);
		amap.put("C", 3);
		amap.put("B", 4);
		amap.put("D", 1);
		amap.put("F", 2);
//带中括号的打印
		System.out.println(amap.values());
		System.out.println(amap.keySet());
//lamda表达式的打印
		amap.values().forEach(System.out::print);
		System.out.println("\n-----------------");

		amap.keySet().forEach(s -> System.out.print(s));
		System.out.println("\n-----------------");

		Set<String> a = amap.keySet();
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println("\n-----------------");
//同时打印key和values
		it = a.iterator();
		Iterator<Integer> itt = amap.values().iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
			System.out.println(itt.next());
		}
		System.out.println("\n-----------------");

		List<Map.Entry<String, Integer>> alsit = new ArrayList(amap.entrySet());
		Collections.sort(alsit, new myComparator());

		alsit.forEach(s -> System.out.println(s.getKey() + s.getValue()));

//        Iterator<Map.Entry<String,Integer>> iit= alsit.iterator();
//        while(iit.hasNext()){
//            Object aa= iit.next();
//            System.out.println(iit.next().getKey()+iit.next().getValue());
//        }

	}

	static class myComparator implements Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return o1.getValue() - o2.getValue();
		}
	}
}
