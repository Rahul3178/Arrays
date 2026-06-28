package deleted;

public class RemoveMatchingCharacters {
    public static void main(String[] args) {

        String input ="banana";
        char target ='a';
        StringBuilder sb = new StringBuilder();

        for (char ch :input.toCharArray())
        {
            if (ch!=target)
            {
                sb.append(ch);
            }
        }

        System.out.println("removed matching characters\t"+sb);
    }
}
