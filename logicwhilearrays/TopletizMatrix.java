package logicwhilearrays;

public class TopletizMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3,4}, {5,1, 2,3}, {9, 5, 1,2}};
        System.out.println(isTopletizMatrix(a));
    }

    private static boolean isTopletizMatrix(int[][] a) {
        int curr=a[0][0];
        for(int i=1;i<a.length;i++){
            if(a[i][i]!=curr)
                return false;
        }
        return true;
    }

}
