package codingninjas30daychallenge;

public class VoidOfDiamondPattern {
    public static void main(String[] args) {
        System.out.println("void of diamond pattern");
        int n = 5;
        String[] pattern = printVoidOfDiamond(n);
        for (String line : pattern) {
            System.out.println(line);
        }
    }

    public static String[] printVoidOfDiamond(int N) {
	String[] pattern = new String[N];
    int mid = N / 2;

    for (int i = 0; i < N; i++) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j < N; j++) {
            if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                row.append("*");
            } else if (Math.abs(mid - i) + Math.abs(mid - j) <= mid - 1) {
                row.append(" ");
            } else {
                row.append("*");
            }
        }
        pattern[i] = row.toString();
    }
    return pattern;
		// Write your code here
	}
}
