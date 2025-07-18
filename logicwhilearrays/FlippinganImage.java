package logicwhilearrays;

public class FlippinganImage {
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        flipAndInvertImage(image);

        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    public static void flipAndInvertImage(int[][] image) {

            for (int[] row : image) {
                int left = 0, right = row.length - 1;
                while (left <= right) {
                    if (left == right) {
                        row[left] ^= 1; // Invert the middle element
                    } else {
                        int temp = row[left] ^ 1;
                        row[left] = row[right] ^ 1;
                        row[right] = temp;
                    }
                    left++;
                    right--;
                }
            }
        }
    }
