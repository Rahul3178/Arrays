package deleted;

import java.util.HashSet;
import java.util.Set;

public class CheckAllUniqueCharacters
{
    public static void main(String[] args) {
        System.out.println("silent has all unique chars : " + hasAllUniqueChars("silent")); // true
        System.out.println("hello has all unique chars : " + allUniqueSrtream("hello")); // false
    }

    private static boolean allUniqueSrtream(String hello) {
        Set<Character> data= new
                HashSet<>();

        for (char c:hello.toCharArray())
        {
            if (!data.add(c)) return false;
        }
        return true;
    }

    private static boolean hasAllUniqueChars(String silent) {
        Set<Character> data= new HashSet<>();

        return silent.chars().mapToObj(c->(char)c).allMatch(s->data.add(s));

    }
}
