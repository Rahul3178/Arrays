package deleted;

import java.util.Arrays;

public class MovesAllZerosAtEnd {
    public static void main(String[] args) {
//
    int[] array = {0, 2, 3, 0, 0, 1, 4, 0, 0};
    int[] res = allZerosMoved(array);


        System.out.println(Arrays.toString(res));
}
    private static int[] allZerosMoved(int[] array) {

        int pos=0;

        for (int num:array)
        {
            if (num !=0)
            {
                array[pos++]=num;
            }
        }

        while (pos<array.length)
        {
            array[pos++]=0;
        }
        return array;
    }

}
