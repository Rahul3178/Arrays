package deleted;

import java.util.HashMap;

public class ArrayTwoSum
{
    public static void main(String[] args) {
        int [] array ={1,2,3,7,5};
        int target =12;

        HashMap<Integer,Integer> map= new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement=target-array[i];
            if(map.containsKey(complement))
            {
                System.out.println("Index \t"+map.get(complement)+" \t"+i);
                break;
            }
            map.put(array[i],i);
        }
    }
}
