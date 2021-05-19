package two_strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'twoStrings' function below.
	 *
	 * The function is expected to return a STRING. The function accepts
	 * following parameters: 1. STRING s1 2. STRING s2
	 */

	public static String twoStrings(String s1, String s2) {
		HashSet<Character> s1Set = new HashSet<Character>();
		for (int i = 0; i < s1.length(); i++) {
			s1Set.add(s1.charAt(i));
		}

		HashSet<Character> s2Set = new HashSet<Character>();
		for (int i = 0; i < s2.length(); i++) {
			s2Set.add(s2.charAt(i));
		}

		for (Iterator iterator = s2Set.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			if (s1Set.contains(character)) {
				System.out.println("YES");
				return "YES";
			}

		}
		System.out.println("NO");
		return "NO";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s1 = bufferedReader.readLine();

				String s2 = bufferedReader.readLine();

				String result = Result.twoStrings(s1, s2);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
