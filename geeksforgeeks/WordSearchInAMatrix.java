package geeksforgeeks;

//Difficulty: MediumAccuracy: 32.69%Submissions: 62K+Points: 4
//You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.
//
//        Examples :
//
//Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
//Output: true
//Explanation:
//
//The letter cells which are used to construct the "GEEK" are colored.
//Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
//Output: false
//Explanation:
//
//It is impossible to construct the string word from the mat using each cell only once.
//Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
//Output: true
//Explanation:
//
//There are multiple ways to construct the word "AB".
//Constraints:
//        1 ≤ n, m ≤ 6
//        1 ≤ L ≤ 15
//mat and word consists of only lowercase and uppercase English letters.

public class WordSearchInAMatrix {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[mat.length][mat[0].length];
                    if(check(mat,i,j,0,word,visited))
                        return true;
                }
            }

        }
        return false;

    }
    private static boolean check(char[][] mat,int i,int j,int index,String word,boolean[][] visit){
        if(index==word.length())
            return  true;
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||
                visit[i][j]||mat[i][j]!=word.charAt(index))
            return false;
        visit[i][j]=true;
        if(check(mat,i,j-1,index+1,word,visit)||
                check(mat,i,j+1,index+1,word,visit)||
                check(mat,i+1,j,index+1,word,visit)||
                check(mat,i-1,j,index+1,word,visit))
            return true;
        visit[i][j]=false;
        return false;

    }
    public static void main(String[] args) {
        System.out.println("word search in a matrix");
        char[][] mat={{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(isWordExist(mat,word));
    }
}
