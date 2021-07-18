package concurrent;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Author:sunlianyu
 * 2021/7/16 18:47
 */
public class alg {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
//		final int N = (int) 3e5+5;
		int[] arr = new int[i];
		for (int j = 0; j < i; j++) {
			arr[j] = in.nextInt();
		}
		long res = 0;
		for (int j = 0; j < arr.length; j++) {
			if (map.containsKey(arr[j])) {
				map.put(arr[j], map.get(arr[j]) + 1);
			} else {
				map.put(arr[j], 1);
			}
			res += j + 1 - map.get(arr[j]);
		}

		System.out.println(res);
	}

}
