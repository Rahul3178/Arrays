package deleted;

public class RemoveDuplicateFromAnArray
{
    public static void main(String[] args) {
        int[] array={1,1,2,2,3,4,4};

        int uniqueIndex=0;
        int length=0;

        for (int i = 1; i < array.length; i++) {

            if (array[i]!=array[uniqueIndex])
            {
                uniqueIndex++;
                array[uniqueIndex]=array[i];
            }
        }

        length=uniqueIndex+1;

        for (int k = 0; k <length ; k++) {
            System.out.println(array[k]);
        }
    }
}
