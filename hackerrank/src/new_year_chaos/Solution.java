package new_year_chaos;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'minimumBribes' function below.
	 *
	 * The function accepts INTEGER_ARRAY q as parameter.
	 */

	public static void minimumBribes(List<Integer> q) {
		int limit = 2;
		ArrayList<Integer> originals = new ArrayList<>();
		for (int i = 0; i < q.size(); i++) {
			originals.add(i + 1);
		}

		int swapCnt = 0;
		while(true){
			int targetVal = originals.get(originals.size()-1);
			if (isExceedBribeLimit(originals.get(getValueIdx(targetVal, originals)), q, limit)) {
				System.out.println("Too chaotic");
				return;
			}

			swapCnt += swap(getValueIdx(targetVal, originals), getValueIdx(targetVal, q), originals);
			if(originals.equals(q)){
				System.out.println(swapCnt);
				return ;
			}
		}
	}

	private static int swap(Integer valueIdx, int i, ArrayList<Integer> originals) {
		int end = valueIdx > i ? valueIdx : i;
		int start = valueIdx > i ? i : valueIdx;

		for (int idx = end; idx > start; idx--) {
			int temp = originals.get(idx - 1);
			originals.set(idx - 1, originals.get(idx));
			originals.set(idx, temp);
		}

		return end - start;
	}

	private static Integer getValueIdx(int val, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (val == list.get(i)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean isExceedBribeLimit(int val, List<Integer> q, int limit) {
		for (int i = 0; i < q.size(); i++) {
			if (val == q.get(i)) {
				if (Math.abs(val - 1 - i) > limit) {
					return true;
				}
				break;
			}
		}
		return false;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				Result.minimumBribes(q);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
