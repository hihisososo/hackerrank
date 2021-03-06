package count_triplets;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		Collections.sort(arr);
		HashSet<Long> sets = new HashSet<>();
		HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			long number = arr.get(i);
			if (map.get(number) == null) {
				map.put(number, new ArrayList<Integer>());
			}
			ArrayList<Integer> idxs = map.get(number);
			idxs.add(i);
			sets.add(number);
		}

		long cnt = 0;
		for (Long number : sets) {
			
			if(r == 1){
				ArrayList<Integer> idxs1 = map.get(number);
				if(idxs1.size() >= 3){
					cnt += (((long)idxs1.size() * ((long)idxs1.size() - 1) * ((long)idxs1.size() - 2)) / 6);
				}
			}else{
			ArrayList<Integer> idxs1 = map.get(number);
			ArrayList<Integer> idxs2 = map.get(number * r);
			ArrayList<Integer> idxs3 = map.get(number * r * r);
			if(idxs1 != null && idxs2 != null && idxs3 != null)
				cnt += (long)idxs1.size() * (long)idxs2.size() * (long)idxs3.size();
			}
		}
		System.out.println(cnt);
		return cnt;

	}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
