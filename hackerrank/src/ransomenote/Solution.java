package ransomenote;

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
	 * Complete the 'checkMagazine' function below.
	 *
	 * The function accepts following parameters: 1. STRING_ARRAY magazine 2.
	 * STRING_ARRAY note
	 */

	public static void checkMagazine(List<String> magazine, List<String> note) {
		HashMap<String, Integer> dics = new HashMap<String, Integer>();
		for (String string : magazine) {
			if (dics.get(string) == null) {
				dics.put(string, 1);
				continue;
			}
			dics.put(string, dics.get(string) + 1);
		}

		HashMap<String, Integer> notes = new HashMap<String, Integer>();
		for (String string : note) {
			if (notes.get(string) == null) {
				notes.put(string, 1);
				continue;
			}
			notes.put(string, notes.get(string) + 1);
		}

		Iterator<String> iter = notes.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			Integer noteCnt = notes.get(key);
			if(dics.get(key) == null){
				System.out.println("No");
				return;
			}
			int dicCnt = dics.get(key);
			if(noteCnt > dicCnt){
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(firstMultipleInput[0]);

		int n = Integer.parseInt(firstMultipleInput[1]);

		List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.collect(toList());

		List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());

		Result.checkMagazine(magazine, note);

		bufferedReader.close();
	}
}
