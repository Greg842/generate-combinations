package by_number;
import java.io.*;
import java.util.*;

public class Vectors {
	static String a;
	static Writer w;
	static int k;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 2;
		}
		return count(l - 1) + count(l - 2);
	}
	
	static void gen(int p, int n) {
		if (a.length() == p) {
			try {
				w.write(a);
				w.write("\n");
			} catch (IOException e) {
				System.out.println("I/O exception: " + e.getMessage());
			}
			return;
		}
		if (k + count(p - a.length() - 1) < n) {
			k += count(p - a.length() - 1);
			a += "1";
			gen(p, n);
		} else {
			a += 0;
			gen(p, n);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("vectors.in"));
			try {
				int l = s.nextInt();
				int n = s.nextInt();
				a = "";
				w = new FileWriter("vectors.out");
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