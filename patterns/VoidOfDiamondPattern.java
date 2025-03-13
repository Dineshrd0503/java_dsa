package patterns;
public class VoidOfDiamondPattern {
    public static void main(String[] args) {
        System.out.println("void of diamond pattern");
        int n = 5;
        String[] pattern = generateDiamondPattern(n);
        for (String line : pattern) {
            System.out.println(line);
        }
    }

    public static String[] generateDiamondPattern(int n) {
        String[] pattern = new String[2 * n - 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= n - i; j++)
                row.append(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                row.append("*");
            pattern[index++] = row.toString();
        }
        for (int i = n - 1; i >= 1; i--) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= n - i; j++)
                row.append(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                row.append("*");
            pattern[index++] = row.toString();
        }
        return pattern;
    }
}