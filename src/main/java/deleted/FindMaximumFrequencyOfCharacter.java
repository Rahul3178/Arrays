package deleted;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMaximumFrequencyOfCharacter
{
    public static void main(String[] args) {
        String input = "apple";

      var output=  input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Maximum repeated character :\t"+output);

        /*
        *   Another way of doing that using normal approach
        * */

        char result='\0';

        int max=0;
        int[] freq= new int[256]; // character ascaii value

        for (char x:input.toCharArray())
        {
            freq[x]++;
        }


        for (char x:input.toCharArray())
        {
            if(freq[x]>max)
            {
                max=freq[x];
                result=x;
            }
        }

        System.out.println("max frequency of \t"+result+" is\t"+max);
    }
}

