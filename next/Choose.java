package next;
import java.io.*;
import java.util.*;

public class Choose {
	static Writer w;
	static List<Integer> a;
	
	static void gen(int n, List<Integer> p) {
		for (int i = p.size() - 1; i >= 0; i--) {
			if (p.get(i) != n && n - p.get(i) - 1 >= p.size() - i - 1) {
				for (int j = 0; j < i; j++) {
					a.add(p.get(j));
				}
				a.add(p.get(i)+1);
				for (int j = i + 1; j < p.size(); j++) {
					a.add(p.get(i)+j-i+1);
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

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("choose.in"));
			try {
				int n = s.nextInt();
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
				w = new FileWriter("choose.out");
				try {
					gen(n, p);
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