package practice;

import java.util.Arrays;

public class MoveAllZeroAtStart
{
    public static void main(String[] args) {
        int[] array={0,2,3,0,0,1,4,0,0};
        int[] newArray=new int[array.length];
        int right=array.length-1;
        int zeroCounter=0;

        for (int num:array)
        {
            if (num==0)
            {
                zeroCounter++;
            }else
            {
                newArray[right--]=num;

            }


        }
        while(zeroCounter>0)
        {
            newArray[right--]=0;
            zeroCounter--;
        }
        System.err.println("All zero at start\t"+ Arrays.toString(newArray));

    }
}
