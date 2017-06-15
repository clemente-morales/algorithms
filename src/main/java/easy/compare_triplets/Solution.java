package easy.compare_triplets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
	public static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {

		IntBiFunction comparer = (a, b) -> a > b ? 1 : 0;

		int pointsA = comparer.applyAsInt(a0, b0);
		pointsA += comparer.applyAsInt(a1, b1);
		pointsA += comparer.applyAsInt(a2, b2);

		int pointsB = comparer.applyAsInt(b0, a0);
		pointsB += comparer.applyAsInt(b1, a1);
		pointsB += comparer.applyAsInt(b2, a2);

		return new int[] { pointsA, pointsB };
	}

	@FunctionalInterface
	public interface IntBiFunction {
		public int applyAsInt(int t, int u);
	}

	public static void main(String[] args) {
		String fileName = "/src/main/resources/easy/compare_triplets.txt";
		Path workingDirectory = Paths.get(".").toAbsolutePath();
		File file = new File(workingDirectory.toAbsolutePath() + fileName);

		try (Scanner in = new Scanner(file)) {
			int a0 = in.nextInt();
			int a1 = in.nextInt();
			int a2 = in.nextInt();
			int b0 = in.nextInt();
			int b1 = in.nextInt();
			int b2 = in.nextInt();
			int[] result = solve(a0, a1, a2, b0, b1, b2);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
