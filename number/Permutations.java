package number;
import java.io.*;
import java.util.*;

public class Permutations {
	static List<Integer> a;
	static Writer w;
	static int k;
	static int l;
	static boolean[] used;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 1;
		}
		return count(l - 1) * l;
	}
	
	static void gen(int p) {
		if (l == p) {
			try {
				w.write(String.valueOf(k));
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i<p+1; i++) {
			if (used[i]) {
				continue;
			}
			if (a.get(l) == i) {
				l += 1;
				used[i] = true;
				gen(p);
				break;
			}
			k += count(p - l - 1);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("permutations.in"));
			try {
				a = new ArrayList<>();
				l = 0;
				while (true) {
					try {
						a.add(s.nextInt());
					} catch (NoSuchElementException e) {
						break;
					}
					//a.add(s.nextInt());
				}
				used = new boolean[a.size() + 1];
				for (int i = 0; i<a.size()+1; i++) {
					used[i] = false;
				}
				w = new FileWriter("permutations.out");
				k = 1;
				try {
					gen(a.size());
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