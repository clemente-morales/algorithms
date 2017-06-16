package cracking_the_code_interview.balance_brackets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	private static final int OPEN_PARENTHESES = 40; // (
	private static final int CLOSE_PARENTHESES = 41; // )

	private static final int OPEN_BRACKET = 91; // [
	private static final int CLOSE_BRACKETS = 93; // ]

	private static final int OPEN_CURLY_BRACKET = 123; // {
	private static final int CLOSE_CURLY_BRACKETS = 125; // }

	private static final int MAX_DIF_OPEN_AND_CLOSE_BRACKETS = 2;

	public static boolean isBalanced(String expression) {

		Stack<Integer> characters = new Stack<>();
		List<Integer> openCharacters = Arrays.asList(OPEN_BRACKET, OPEN_CURLY_BRACKET, OPEN_PARENTHESES);

		boolean result = expression.chars().allMatch((int t) -> {
			if (openCharacters.contains(t)) {
				characters.push(t);
				return true;
			}

			if (characters.isEmpty() || Math.abs(t - characters.peek()) > MAX_DIF_OPEN_AND_CLOSE_BRACKETS)
				return false;

			characters.pop();
			return true;
		});
		
		
		return result && characters.isEmpty();

	}

	public static void main(String[] args) {
		String fileName = "/src/main/resources/cracking_the_code_interview/balance_brackets.txt";
		Path workingDirectory = Paths.get(".").toAbsolutePath();
		File file = new File(workingDirectory.toAbsolutePath() + fileName);

		try (Scanner in = new Scanner(file)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				String expression = in.next();
				System.out.println((isBalanced(expression)) ? "YES" : "NO");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
