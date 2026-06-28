package deleted;

public class RemoveDuplicateCharacters
{
    public static void main(String[] args) {
        String str="swisssi";

        boolean[] seen = new boolean[256];   // ascai values of characters

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!seen[ch])
            {
                seen[ch]=true;
                sb.append(ch);
            }
        }

        System.out.println("all unique is "+sb);

    }
}
