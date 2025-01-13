package codingninjas;
//This year Santa Claus got a magic bag for bringing gifts for children. So magical thing about this magic bag is that, whenever the number of gifts inside the bag becomes strictly less than 'K' gifts, it automatically refills back to its full capacity(say its capacity is of 'N' gifts). Now a child can ask for 'M' (some positive integer less than 'N') gifts from Santa. This reduces the number of gifts in the bag by 'M'.
//
//On the occasion of Christmas, when Santa Claus arrived, children of your locality made a queue for taking gifts from Santa Claus. But some greedy kids can ask for more gifts than the current number of gifts in the bag which is regarded as invalid demand and that kid doesn't get any gift.
//
//You are watching this distribution of gifts, and become curious about knowing the number of gifts remaining in Santa's bag after giving gifts to a kid. You get the ordered list of demands of kids as 'DEMANDS', can you tell which are invalid demands and how many gifts left in the bag if the demand is valid?
//
//Note:
//
//        1. You can assume Magic Bag is completely filled initially.
//
//2. If the demand by a kid is invalid print -1 which will denote this invalid demand.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//        1 <= K <= N <= 10 ^ 9
//        1 <= Q <= 10 ^ 6
//        1 <= DEMANDS[i] <= 2 ^ 31
//
//Time Limit: 1 sec.
//Sample Input 1:
//        10 4 3
//        4
//        2
//        2
//Sample Output 1:
//        6
//        4
//        10
//Explanation for sample input 1:
//After the 1st demand, Bag contains 10 - 4 = 6 gifts.
//After the 2nd demand, Bag contains 6 - 2 = 4 gifts.
//After the 3rd operation, Bag contains 4 - 2 = 2 gifts, but now the number of gifts in the bag is less than K, hence magic happens and bag refills back to N gifts.
//Sample Input 2:
//        7 6 2
//        3
//        8
//Sample Output 2:
//        7
//        -1
//Explanation for sample input 2:
//After the 1st operation, Bag contains 7 - 3 = 4 gifts which is less than K(which is 6), hence Bag refills and contains 7 gifts.
//After the 2nd operation, Bag contains 7 gifts, but demand is of 8 gifts from the kid, which is impossible to be fulfilled, hence this demand is invalid.
public class SanthaClaus {
    public static int[] giftsLeft(int n, int k, int q, int[] demands) {
        int[] result=new int[q];
        int gifts=n;
        for(int i=0;i<q;i++){
            int wish=demands[i];
            if(wish>gifts)
                result[i]=-1;
            else{
                gifts-=wish;
                if(gifts<k)
                    gifts=n;
                result[i]=gifts;
            }

        }
        return result;
        // Write your code here.
    }
    public static void main(String[] args) {
        int n=10;
        int k=3;
        int q=5;
        int[] demands={2, 3, 4, 5, 6};
        int[] result = giftsLeft(n, k, q, demands);
        for(int i=0;i<q;i++)
            System.out.print(result[i]+" ");
    }
}
