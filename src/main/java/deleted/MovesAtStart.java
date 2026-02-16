package deleted;

import java.util.Arrays;

public class MovesAtStart
{
    public static void main(String[] args) {
        int [] array= {0,2,3,0,0,1,4,0,0};

        int pos=array.length-1;

        for (int num=array.length-1;num>=0;num--)
        {
            if(array[num]!=0) {
                array[pos--] = array[num];
            }
        }

        while (pos>=0)
        {
            array[pos--]=0;
        }


        System.out.println(Arrays.toString(array));
    }


}
