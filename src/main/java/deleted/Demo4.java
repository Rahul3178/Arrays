package deleted;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo4
{
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Rahul",10);
        map.put("Kumar",5);
        map.put("Jangra",6);
        map.put("Goli",20);
        map.put("take",31);

     Map<String,Integer> result=
             map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e,v)->e, LinkedHashMap::new));

            for (Map.Entry<String,Integer>num:result.entrySet())
            {
                System.out.println(num.getKey()+"\t"+num.getValue());
            }
    }
}
