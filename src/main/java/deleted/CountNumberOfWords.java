package deleted;

import java.util.Arrays;

public class CountNumberOfWords
{
    public static void main(String[] args) {
        String str = "This is coding   lyf";
        int length=str.length();

        int spaces=0;
        for (int i=0;i<length;i++)
        {
            if (str.charAt(i)==' ')
            {
                spaces++;
            }
        }

        System.out.println("Total number of words \t"+(spaces+1));


        String[] strAr=str.split("\\s+");
        System.out.println("use stream api to count \t"+Arrays.stream(strAr).count());
    }
}
