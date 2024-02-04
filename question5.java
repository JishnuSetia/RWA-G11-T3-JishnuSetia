import java.util.*;

public class question5 {
    public static String acceptStr(){
        Scanner in = new Scanner(System.in);
        String n;
        boolean flag = false;
        try {
            n = in.nextLine();
        } catch (Exception e) {
            flag=true;
            n="";
        }
        return flag?acceptStr():n;
    }
    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        String word = acceptStr();
        System.out.println("Anagrams of " + word + ":");
        generateAnagrams("", word);
    }
    public static void generateAnagrams(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generateAnagrams(prefix + remaining.charAt(i),
                                remaining.substring(0, i) + remaining.substring(i+1, n));
            }
        }
    }
}
