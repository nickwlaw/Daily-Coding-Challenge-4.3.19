
public class DCPApp {

	public static void main(String[] args) {

		String message = "111";
		int solutions = test(message);
		System.out.println(message);
		System.out.println(solutions);
	}
	
	private static int test(String message) {
		
//		boolean hasZero = false;
		int solutions = calculate(message);
//		if (!hasZero)
//			solutions++;
		
		return solutions;
	}
	
	private static int calculate(String message) {
		int solutions = 0;
		boolean hasZero = false;
		for (int i = 0; i < message.length() - 1; i++) {
			if (Character.getNumericValue(message.charAt(i)) == 0)
				hasZero = true;
			if (Character.getNumericValue(message.charAt(i)) == 1 && i < message.length() - 1) {
				if (Character.getNumericValue(message.charAt(i + 1)) == 0
						|| Character.getNumericValue(message.charAt(i + 1)) == 1
						|| Character.getNumericValue(message.charAt(i + 1)) == 2
						|| Character.getNumericValue(message.charAt(i + 1)) == 3
						|| Character.getNumericValue(message.charAt(i + 1)) == 4
						|| Character.getNumericValue(message.charAt(i + 1)) == 5
						|| Character.getNumericValue(message.charAt(i + 1)) == 6) {
					solutions++;
					if (i + 2 <= message.length() - 1)
						solutions += calculate(message.substring(i + 2, message.length()));
				}
			}
		}
		return solutions;
	}

}

/*
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 * 
 */