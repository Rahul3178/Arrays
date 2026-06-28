package deleted;

import java.util.Arrays;
import java.util.Comparator;

public class FindTheLargestWordString {
    public static void main(String[] args) {
        String str = "Java makes coding enjoyable and challenging";

      var out=  Arrays.stream(str.split("\s+")).max(Comparator.comparingInt(String::length)).get();
        System.out.println("highest length of a word is \t"+out.length());


        String[] st= str.split("\s+");

        String longestWord="";
        for (int i = 0; i < st.length; i++) {
            if(longestWord.length()<st[i].length())
            {
                longestWord=st[i];
            }
        }
        System.out.println("Longest word is \t"+longestWord);
    }
}
