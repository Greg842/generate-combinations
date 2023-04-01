import java.io.*;
import java.util.*;

public class Brackets {
	static String a;
	static Writer w;
	
	static int count(int l) {
		if (l == 0) {
			return 1;
		} else if (l == 1) {
			return 1;
		}
		int c = 0;
		for (int i = 0; i < l; i++) {
			c += count(i) * count (l - i - 1);
		}
		return c;
	}
	
	static int balance (String b) {
		int open_count = 0;
		int close_count = 0;
		for (int i = 0; i< b.length(); i++) {
			if (b.charAt(i) == '(') {
				open_count += 1;
			} else {
				close_count += 1;
			}
		}
		return open_count - close_count;
	}
	
	static void gen(int p) {
		String b = String.valueOf(a);
		if (b.length() == 2 * p) {
			if (balance(b) == 0) {
				try {
					w.write(b);
					w.write("\n");
				} catch (IOException e) {
					System.out.println("I/O exception: " + e.getMessage());
				}
			}
			return;
		}
		a = String.valueOf(b) + "(";
		gen(p);
		if (balance(b) > 0) {
			a = String.valueOf(b) + ")";
			gen(p);
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("brackets.in"));
			try {
				int l = s.nextInt();
				a = "";
				w = new FileWriter("brackets.out");
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