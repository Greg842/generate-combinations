package by_number;
import java.io.*;
import java.util.*;

public class Permutations {
	static String a;
	static Writer w;
	static int k;
	static boolean[] used;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 1;
		}
		return count(l - 1) * l;
	}
	
	static void gen(int p, int n) {
		if (a.length() == p) {
			try {
				w.write(a);
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i<p+1; i++) {
			if (used[i]) {
				continue;
			}
			if (k + count(p - a.length() - 1) < n) {
				k += count(p - a.length() - 1);
				continue;
			}
			a += String.valueOf(i);
			used[i] = true;
			gen(p, n);
			break;
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("permutations.in"));
			try {
				int l = s.nextInt();
				int n = s.nextInt();
				used = new boolean[l+1];
				for (int i = 0; i<l+1; i++) {
					used[i] = false;
				}
				a = "";
				w = new FileWriter("permutations.out");
				k = 0;
				try {
					gen(l, n);
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