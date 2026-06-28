package deleted;

import java.util.HashSet;
import java.util.Set;

public class RemoveMatchingWordFromString
{
    public static void main(String[] args) {
        String First  = "computer" ;
        String Second = "cat";

        Set<Character> seen = new HashSet<>();
        for (char ch:Second.toCharArray()) {
            seen.add(ch);

        }

        StringBuilder sb= new StringBuilder();
        for (char ch: First.toCharArray()) {

            if (!seen.contains(ch))
            {
                sb.append(ch);
            }

        }

        System.out.println("After removing matching words\t"+sb.toString());
    }
}
