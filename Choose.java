import java.io.*;
import java.util.*;

public class Choose {
	static List<Integer> a;
	static Writer w;
	
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
	
	static void gen(int n, int k) {
		List<Integer> b = new ArrayList<>();
		for (Integer i: a) {
			b.add(i);
		}
		if (b.size() == k) {
			String out = "";
			for (Integer i: b) {
				out += String.valueOf(i) + " ";
			}
			try {
				w.write(out);
				w.write("\n");
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i < n + 1; i++) {
			if (b.size() > 0 && b.get(b.size() - 1) >= i) {
				continue;
			}
			if (n - i < k - b.size() - 1) {
				break;
			}
			a.removeAll(a);
			for (Integer j: b) {
				a.add(j);
			}
			a.add(i);
			gen(n, k);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("choose.in"));
			try {
				int n = s.nextInt();
				int k = s.nextInt();
				a = new ArrayList<>();
				w = new FileWriter("choose.out");
				try {
					w.write(String.valueOf(count(n, k)));
					w.write("\n");
					gen(n, k);
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