import java.util.Scanner;
public class Question2{

    //Function to simulate a card game where two players pick cards from either end of an array and calculate their scores
    public static int[] CardGame( int[] cards){
        int left=0; // Initialize left pointer to the start of the array
        int right=cards.length-1; // Initialize right pointer to the end of the array
        int player1Score=0; // Initialize score for player 1 to 0
        int player2Score=0;// Initialize score for player 2 to 0
        boolean player1_turn=true; // Boolean variable to keep track of whose turn it is (true for player 1, false for player 2)

        // Loop until all cards have been picked
    while(left <= right){
        int chosenCard; 
        if(cards[left] > cards[right]){
            chosenCard=cards[left]; // If the card at the left pointer is greater than the card at the right pointer, choose the left card
            left++;
        }else{
            chosenCard=cards[right]; // Otherwise, choose the right card
            right--;
        }
        if(player1_turn){
            player1Score +=chosenCard; // If it's player 1's turn, added the chosen card's value to player 1's score
        }else{
            player2Score +=chosenCard; // If it's player 2's turn, added the chosen card's value to player 2's score
        }
        player1_turn=!player1_turn; // Switch turns between player 1 and player 2

    }
    return new int[]{player1Score,player2Score}; // Return the scores of both players as an array
}
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of cards:");
    int n=sc.nextInt();
    int[] cards=new int[n];
    System.out.println("Enter the values of the cards:");
    for(int i=0;i<n;i++){
        cards[i]=sc.nextInt();
    }
    int[] scores=CardGame(cards);
    System.out.println("Scores of player 1 and player 2 are:");
    System.out.println(scores[0]+"  "+scores[1]);
    sc.close();
}
}