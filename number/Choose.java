package number;
import java.io.*;
import java.util.*;

public class Choose {
	static List<Integer> a;
	static Writer w;
	static int l;
	static int m;
	
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
	
	static void gen(int p, int k) {
		if (m == k) {
			try {
				w.write(String.valueOf(l));
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i<p+1; i++) {
			if (m > 0 && a.get(m - 1) >= i) {
				continue;
			}
			if (a.get(m) == i) {
				m += 1;
				gen(p, k);
				break;
			}
			l += count(p - i, k - m - 1);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("choose.in"));
			try {
				int n = s.nextInt();
				m = 0;
				a = new ArrayList<>();
				while (true) {
					try {
						a.add(s.nextInt());
					} catch (NoSuchElementException e) {
						break;
					}
					//a.add(s.nextInt());
				}
				l = 1;
				w = new FileWriter("choose.out");
				try {
					gen(n, a.size());
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