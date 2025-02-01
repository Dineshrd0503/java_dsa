package strings;

//Problem statement
//You are given a 2D board('N' rows and 'M' columns) of characters and a string 'word'.
//
//
//
//Your task is to return true if the given word exists in the grid, else return false. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
//
//
//
//Note:
//The same letter cell should not be used more than once.
//For Example:
//For a given word “design” and the given 2D board
//[[q’, ‘v’, ‘m’, ‘h’],
//        [‘d’, ‘e’, ‘s’, ‘i’],
//        [‘d’, ‘g’, ‘f’, ‘g’],
//        [‘e’, ‘c’, ‘p’, ‘n’]]
//
//The word design can be formed by sequentially adjacent cells as shown by the highlighted color in the 2nd row and last column.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//coding
//4 4
//c z k l
//o d i a
//r g n m
//m r s d
//Sample Output 1:
//        true
//Explanation For Sample Input 1:
//For the given word, and grid we can construct from letters of sequentially adjacent cells as shown below:
//
//Sample Input 2:
//ninjas
//4 4
//c d k s
//o d s i
//d g n j
//e r i n
//Sample Output 2:
//        false
//Constraints:
//        1 <= N <= 6
//        1 <= M <= 6
//        1 <= |word| <=20
//
//Time Limit: 1 sec



public class WordSearchInAWord {
    public static boolean present(char [][]mat, String word, int n, int m) {
        // Write your code here.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[n][m];
                    if(check(mat,i,j,0,word,visited,n,m))
                        return true;
                }
            }

        }
        return false;

    }
    private static boolean check(char[][] mat,int i,int j,int index,String word,boolean[][] visit,int n,int m){
        if(index==word.length())
            return  true;
        if(i<0||j<0||i>=n||j>=m||
                visit[i][j]||mat[i][j]!=word.charAt(index))
            return false;
        visit[i][j]=true;
        if(check(mat,i,j-1,index+1,word,visit,n,m)||
                check(mat,i,j+1,index+1,word,visit,n,m)||
                check(mat,i+1,j,index+1,word,visit,n,m)||
                check(mat,i-1,j,index+1,word,visit,n,m))
            return true;
        visit[i][j]=false;
        return false;

    }
    public static void main(String[] args) {
        System.out.println("word search in a matrix");
        char[][] mat={{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(present(mat,"ABCE",3,4));
    }
}
