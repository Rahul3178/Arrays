package deleted;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAString
{
    public static void main(String[] args) {
        String name="Rahul";
        String reversed="";
        for (int i = name.length()-1; i >=0 ; i--) {
            reversed+=name.charAt(i);
        }

        System.out.println(reversed);


      String out=
              IntStream.range(0,name.length()).mapToObj(i->name.charAt(name.length()-1-i)).map(String::valueOf).collect(Collectors.joining());

        System.out.println("Stream api reversed string \t"+out);
    }
}
