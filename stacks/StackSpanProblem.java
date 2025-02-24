package stacks;
import java.util.ArrayList;
import java.util.Stack;

//The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
//
//Examples:
//
//Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
//Output: [1, 1, 1, 2, 1, 4, 6]
//Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more elements behind it so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 60 is greater than equal to 60 and smaller than 80 so the span is 1, 70 is greater than equal to 60,70 and smaller than 80 so the span is 2 and so on.  Hence the output will be 1 1 1 2 1 4 6.
//Input: arr[] = [10, 4, 5, 90, 120, 80]
//Output: [1, 1, 2, 4, 5, 1]
//Explanation: Traversing the given input span 10 is greater than equal to 10 and there are no more elements behind it so the span is 1, 4 is greater than equal to 4 and smaller than 10 so the span is 1, 5 is greater than equal to 4,5 and smaller than 10 so the span is 2,  and so on. Hence the output will be 1 1 2 4 5 1.
//Constraints:
//        1 ≤ arr.size()≤ 105
//        1 ≤ arr[i] ≤ 105

public class StackSpanProblem {

    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i])
                stack.pop();
            result.add(stack.isEmpty()?i+1:i-stack.peek());
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Stack Span Problem");
        int[] arr={100, 80, 60, 70, 60, 75, 85};
        StackSpanProblem obj=new StackSpanProblem();
        System.out.println(obj.calculateSpan(arr));
    }

}
