package next;
import java.io.*;
import java.util.*;

public class Vectors {
	static Writer w;
	static String a;
	
	static void gen(String p) {
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) == '0' && (i == 0 || p.charAt(i - 1) == '0')) {
				for (int j = 0; j < i; j++) {
					a += p.charAt(j);
				}
				a += '1';
				for (int j = i + 1; j < p.length(); j++) {
					a += '0';
				}
				break;
			}
		}
		try {
			w.write(a);
		} catch (IOException e) {
			System.out.println("I/O exception: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("vectors.in"));
			try {
				String v = s.next();
				a = "";
				w = new FileWriter("vectors.out");
				try {
					gen(v);
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