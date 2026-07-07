public class CardGame {

    public static void main(String[] args){

        int[] cards = {4, 1, 2, 10};
        int left = 0;
        int right = cards.length - 1;

        int player1_score = 0;
        int player2_score = 0;

        boolean player1_turn = true;

        while(left <= right){

            int picked_card = 0;

            if( cards[left] > cards[right] ){
                picked_card = cards[left];
                left++;
            }
            else{
                picked_card = cards[right];
                right--;
            }

            if(player1_turn){
                player1_score += picked_card;
            }
            else{
                player2_score += picked_card;
            }

            player1_turn = !player1_turn;


        }
        System.out.println("Player 1 Score: " + player1_score);
        System.out.println("Player 2 Score: " + player2_score);
    }
    
}
