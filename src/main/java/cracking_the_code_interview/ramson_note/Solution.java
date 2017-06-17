package cracking_the_code_interview.ramson_note;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public Solution(String[] magazine, String[] ransom) {
		Stream<String> magazineStream = Arrays.stream(magazine);
		Stream<String> noteStream = Arrays.stream(ransom);
		magazineMap = magazineStream.collect(Collectors.groupingBy(Function.identity(), counting()));
		noteMap = noteStream.collect(Collectors.groupingBy(Function.identity(), counting()));

	}

	public boolean solve() {
		return noteMap.entrySet().stream().allMatch((entry) -> {
			return magazineMap.containsKey(entry.getKey()) && magazineMap.get(entry.getKey()) >= entry.getValue();
		});
	}
	
	public static <T> Collector<T, ?, Integer>
    counting() {
        return Collectors.reducing(0, e -> 1, Integer::sum);
    }

	public static void main(String[] args) {
		String fileName = "/src/main/resources/cracking_the_code_interview/ramson_note.txt";
		Path workingDirectory = Paths.get(".").toAbsolutePath();
		File file = new File(workingDirectory.toAbsolutePath() + fileName);

		try (Scanner in = new Scanner(file)) {
			int m = in.nextInt();
			int n = in.nextInt();
			String magazine[] = new String[m];
			for (int magazine_i = 0; magazine_i < m; magazine_i++) {
				magazine[magazine_i] = in.next();
			}
			String ransom[] = new String[n];
			for (int ransom_i = 0; ransom_i < n; ransom_i++) {
				ransom[ransom_i] = in.next();
			}

			Solution s = new Solution(magazine, ransom);
			boolean answer = s.solve();
			if (answer)
				System.out.println("Yes");
			else
				System.out.println("No");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}