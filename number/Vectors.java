package number;
import java.io.*;
import java.util.*;

public class Vectors {
	static String a;
	static Writer w;
	static int k;
	static int l;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 2;
		}
		return count(l - 1) + count(l - 2);
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
		if (a.charAt(l) == '1') {
			k += count(p - l - 1);
			l += 1;
			gen(p);
		} else {
			l += 1;
			gen(p);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("vectors.in"));
			try {
				a = s.next();
				w = new FileWriter("vectors.out");
				k = 1;
				l = 0;
				try {
					gen(a.length());
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