package deleted;
/*
*   when string contains all the unique characters said to be isogram
* */
public class CheckStringIsogram {
    public static void main(String[] args) {
        String input="Machine";
        var isIsogram=true;

        int[] freq= new int[256];

        for (char c:input.toCharArray())
        {
            freq[c]++;
        }

        for (char c:input.toCharArray())
        {
            if (freq[c]>1)
            {
                isIsogram=false;
                break;
            }
        }

        System.out.println("Is "+input+ " is isogram string \t"+isIsogram);
    }
}
