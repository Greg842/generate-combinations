package by_number;
import java.io.*;
import java.util.*;

public class Choose {
	static List<Integer> a;
	static Writer w;
	static int l;
	static boolean[] used;
	
	static int fact(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 1;
		}
		return fact(l - 1) * l;
	}
	
	static int count(int n, int k) {
		return fact(n) / (fact(n-k) * fact(k));
	}
	
	static void gen(int p, int k, int m) {
		if (a.size() == k) {
			try {
				for (Integer i: a) {
					w.write(String.valueOf(i));
					w.write(" ");
				}
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i<p+1; i++) {
			if (a.size() > 0 && a.get(a.size() - 1) >= i) {
				continue;
			}
			if (l + count(p - i, k - a.size() - 1) < m) {
				l += count(p - i, k - a.size() - 1);
				continue;
			}
			a.add(i);
			used[i] = true;
			gen(p, k, m);
			break;
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("choose.in"));
			try {
				int n = s.nextInt();
				int k = s.nextInt();
				int m = s.nextInt();
				a = new ArrayList<>();
				used = new boolean[n+1];
				for (int i = 0; i<n+1; i++) {
					used[i] = false;
				}
				w = new FileWriter("choose.out");
				l = 0;
				try {
					gen(n, k, m);
				} finally {
					w.close();
				}
			} finally {
				s.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O exception: " + e.getMessage());
		}
	}
}