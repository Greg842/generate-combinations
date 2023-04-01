import java.io.*;
import java.util.*;

public class Vectors {
	static String a;
	static Writer w;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 2;
		}
		return count(l - 1) + count(l - 2);
	}
	
	static void gen(int p) {
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
		a = String.valueOf(b) + "0";
		gen(p);
		if (b.length() == 0 || b.charAt(b.length() - 1) == '0') {
			a = String.valueOf(b) + "1";
			gen(p);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("vectors.in"));
			try {
				int l = s.nextInt();
				a = "";
				w = new FileWriter("vectors.out");
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