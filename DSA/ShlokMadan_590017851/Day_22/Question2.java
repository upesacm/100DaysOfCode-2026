public class Question2 {
    public static void main(String[] args)
    {
        int[] cards={4,1,2,10};
        int left=0;
        int right=cards.length-1;
        int player1=0;
        int player2=0;
        boolean turn=true;
        while(left<=right)
            {
            int pick;
            if(cards[left]>cards[right])
                {
                pick=cards[left];
                left++;
            }
            else
                {
                pick=cards[right];
                right--;
            }
            if(turn)
                player1+=pick;
            else
                player2+=pick;

            turn=!turn;
        }
        System.out.println(player1+" "+player2);
    }
}