package next;
import java.io.*;
import java.util.*;

public class Permutations {
	static Writer w;
	static List<Integer> a;
	
	static void gen(List<Integer> p) {
		for (int i = p.size() - 1; i >= 0; i--) {
			int r = -1;
			for (int j = p.get(i) + 1; j < p.size(); j++) {
				if (!find(p, 0, i, j)) {
					r = j;
					break;
				}
			}
			if (r != -1) {
				for (int j = 0; j < i; j++) {
					a.add(p.get(j));
				}
				a.add(r);
				int n = 1;
				for (int j = i + 1; j < p.size(); j++) {
					while (find(a, 0, i+1, n)) {
						n++;
					}
					a.add(n);
					n++;
				}
				break;
			}
		}
		try {
			for (Integer i: a) {
				w.write(String.valueOf(i));
				w.write(" ");
			}
		} catch (IOException e) {
			System.out.println("I/O exception: " + e.getMessage());
		}
	}

	static boolean find(List<Integer> p, int a, int b, int n) {
		for (int i = a; i < b; i++) {
			if (p.get(i) == n) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("permutations.in"));
			try {
				List<Integer> p = new ArrayList<>();
				while (true) {
					try {
						p.add(s.nextInt());
					} catch (NoSuchElementException e) {
						break;
					}
					//a.add(s.nextInt());
				}
				a = new ArrayList<>();
				w = new FileWriter("permutations.out");
				try {
					gen(p);
				} finally {
					w.close();
				}
			} finally {
				s.close();
			}
		} catch  (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O exception: " + e.getMessage());
		}
	}
}