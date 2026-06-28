package deleted;

public class FindFirstRepetableCharacter
{
    public static void main(String[] args) {
        String input="abcaaaC";
        int[] freq= new int[26];

        for (char c:input.toCharArray())
        {
            if (freq[c-'a']>0)
            {
                System.out.println("found the repeated character \t"+c);
                break;
            }
            freq[c-'a']++;
        }
    }
}
