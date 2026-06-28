package deleted;

import java.util.Arrays;

public class ArraysPositiveNegatives {
    public static void main(String[] args) {
        int[] array={3,-2,4,-1,0,-3,-5,7};


        int[] ordered = new int[array.length];

        int positive=0;
        int negative=1;

        for (int x:array)
        {
            if (x>=0)
            {
                if (positive<array.length)
                {
                    ordered[positive]=x;
                    positive+=2;
                }
            }else {
                if (negative<array.length)
                {
                    ordered[negative]=x;
                    negative+=2;
                }
            }
        }

        System.out.println(Arrays.toString(ordered));
    }
}
