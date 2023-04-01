import java.io.*;
import java.util.*;

public class Permutations {
	static String a;
	static Writer w;
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
		boolean[] used_copy = new boolean[p+1];
		for (int i = 0; i < p + 1; i++) {
			used_copy[i] = used[i];
		}
		String b = String.valueOf(a);
		if (b.length() == p) {
			try {
				w.write(b);
				w.write("\n");
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		for (int i = 1; i < p + 1; i++) {
			for (int j = 0; j < p + 1; j++) {
				used[j] = used_copy[j];
			}
			if (!used[i]) {
				a = String.valueOf(b) + String.valueOf(i);
				used[i] = true;
				gen(p);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("permutations.in"));
			try {
				int l = s.nextInt();
				a = "";
				used = new boolean[l+1];
				for (int i = 0; i < l + 1; i++) {
					used[i] = false;
				}
				w = new FileWriter("permutations.out");
				try {
					w.write(String.valueOf(count(l)));
					w.write("\n");
					gen(l);
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