
import java.util.ArrayList;
import java.util.Scanner;

public class Text02_1 {
    /* 求该两个数最大公约数和最小公倍数 */
    public static ArrayList<Integer> factor(int n, ArrayList<Integer> arr) {
	for (int i = 1; i <= n; i++) {
	    if (n % i == 0) {
		int j = n / i;
		if (i >= j) {
		    break;
		}
		arr.add(i);
		arr.add(j);
	    }
	}
	return arr;
    }

    public static int maxFactor(ArrayList<Integer> arr_1, ArrayList<Integer> arr_2) {
	int maxfactor = 0;
	outer: for (int i = arr_1.size() - 1; i >= 0; i--) {
	    for (int j = arr_2.size() - 1; j >= 0; j--) {
		if (arr_1.get(i) == arr_2.get(j)) {
		    maxfactor = arr_1.get(i);
		    break outer;
		}
	    }
	}
	return maxfactor;
    }

    public static int minMultiple(int a, int b) {
	int min = 0;
	for (int i = 1; i < a * b; i++) {
	    if ((a * i) % b == 0) {
		min = a * i;
		break;
	    }
	}
	return min;
    }

    public static ArrayList<Integer> rankArr(ArrayList<Integer> arr) {
	for (int i = 0; i <= arr.size() - 1; i++) {
	    for (int j = 0; j <= arr.size() - 2; j++) {
		if (arr.get(j) > arr.get(j + 1)) {
		    int t = arr.get(j + 1);
		    arr.set(j + 1, arr.get(j));
		    arr.set(j, t);
		}
	    }
	}
	return arr;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> arr_1 = new ArrayList<Integer>();
	ArrayList<Integer> arr_2 = new ArrayList<Integer>();
	System.out.print("输入第一个数：");
	int a = sc.nextInt();
	System.out.print("输入第二个数：");
	int b = sc.nextInt();
	int maxfactor = 0;
	int minmultiple = 0;
	sc.close();

	System.out.println();
	factor(a, arr_1);
	System.out.println("原集合：" + arr_1);
	rankArr(arr_1);

	factor(b, arr_2);
	System.out.println("原集合：" + arr_2);
	rankArr(arr_2);

	maxfactor = maxFactor(arr_1, arr_2);
	minmultiple = minMultiple(a, b);

	System.out.println();
	System.out.println("新集合：" + arr_1); // 已排序
	System.out.println("新集合：" + arr_2); // 已排序

	System.out.println();
	System.out.println("最大公约数是=" + maxfactor);
	System.out.println("最小公倍数是=" + minmultiple);
    }
}
