package deleted;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str="swiss";

      Character nonRepeating=  str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),
                                     Collectors.counting()))
           .entrySet().stream().filter(e->e.getValue()==1).sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).map(Map.Entry::getKey).findFirst().get();

        System.out.println("Non repeating character via stream api \t"+nonRepeating);

        /* via normal java program*/

        LinkedHashMap<Character,Integer> data= new LinkedHashMap<>();
        for (char ch: str.toCharArray())
        {
            data.put(ch,data.getOrDefault(ch,0)+1);
        }

        for (Map.Entry entry:data.entrySet())
        {
            if (entry.getValue().equals(1))
            {
                System.out.println("using java normal program\t"+entry.getKey());
                break;
            }
        }
    }
}
