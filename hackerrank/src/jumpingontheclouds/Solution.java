package jumpingontheclouds;

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
	 * Complete the 'jumpingOnClouds' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY c as parameter.
	 */

	public static int jumpingOnClouds(List<Integer> c) {
		int currentIdx = 0;
		int jumpCnt = 0;
		while (currentIdx < c.size() - 1) {
			if (canJump(currentIdx, c, 2)) {
				currentIdx += 2;
				jumpCnt++;
			} else if (canJump(currentIdx, c, 1)) {
				currentIdx++;
				jumpCnt++;
			}
		}

		return jumpCnt;

	}

	private static boolean canJump(int currentIdx, List<Integer> c, int i) {
		if (currentIdx + i >= c.size()) {
			return false;
		}
		return c.get(currentIdx + i) == 0;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result.jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
