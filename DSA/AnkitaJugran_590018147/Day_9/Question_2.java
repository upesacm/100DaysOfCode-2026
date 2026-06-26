public class Remove_spaces {
     public static void main(String[] args){
        String str = "Rem o v e spac es";
        System.out.println("Original String: " + str);
        
        String str1 = "";
        for ( int i = 0 ; i < str.length() ; i++){
            if ( str.charAt(i) != ' '){
                str1 += str.charAt(i);
            }
        }
        System.out.println("String after removing spaces: " + str1);
     }
}