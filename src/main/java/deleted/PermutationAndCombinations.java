package deleted;

import java.util.ArrayList;
import java.util.List;

public class PermutationAndCombinations
{
    public static void main(String[] args) {
        String input ="AMA";

        List<String> output = new ArrayList<>();

        String path=""; // for traversing and backtracking

        boolean[] used = new boolean[input.length()];  // to check character is used or not

        backtracking(input,path,output,used);
        System.out.println("We are giving input \t"+input+" now getting output \t"+output);

    }
    public static void backtracking(String input, String path, List<String> output , boolean[] used)
    {
        if (path.length() == input.length())
        {
            output.add(path);
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            if (!used[i])
            {
                used[i]=true;
                backtracking(input,path+input.charAt(i),output,used);
                used[i]=false;
            }


        }
    }
}
