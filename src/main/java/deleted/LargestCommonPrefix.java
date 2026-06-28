package deleted;

import java.util.Arrays;

public class LargestCommonPrefix
{
    public static void main(String[] args) {
        String[] input ={"flower","flow","flight"};

        String prefix=input[0];

        for (int i=1;i<input.length;i++)
        {
            while (input[i].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }

        System.out.println("longest common prefix is\t"+prefix);


    String pf=    Arrays.stream(input).reduce((s1,s2)->{
            while(!s2.startsWith(s1)){
                s1=s1.substring(0,s1.length()-1);
            }
            return s1;
        }).orElse("No prefix is found");

        System.out.println("Stream api,longest common prefix is\t"+pf);
    }
}
