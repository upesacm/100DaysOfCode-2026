import java.util.Scanner;
class d9q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.nextLine();

        int count = 0;

        for(int i=0; i<s.length(); i++){
            count++;
        }

        if(count % 2 == 0){
            System.out.println("CHAT WITH HER");
        }
        else if(count % 2 != 0){
            System.out.println("IGNORE HIM");
        }
        else{
            System.out.println("Invalid output.");
        }

        sc.close();
    }
}
