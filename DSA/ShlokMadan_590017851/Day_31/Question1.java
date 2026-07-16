import java.util.Arrays;
import java.util.Stack;

public class Question1 {

    public static int[] finalPrices(int[] prices){

        Stack<Integer> st=new Stack<>();

        for(int i=prices.length-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()>prices[i])
                st.pop();

            if(!st.isEmpty())
                prices[i]-=st.peek();

            st.push(prices[i]+(st.isEmpty()?0:0));
        }

        return prices;
    }

    public static void main(String[] args){

        int[] prices={8,4,6,2,3};

        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}