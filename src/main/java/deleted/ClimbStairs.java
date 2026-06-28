package deleted;

public class ClimbStairs
{
    public static void main(String[] args) {
        int stairs=5;

        if (stairs<=2)
        {
            System.out.println("need steps:"+stairs);
        }

        int oneStepBefore=2;
        int twoStepsBefore=1;
        int result=0;

        for (int i = 3; i <=stairs ; i++) {
            result=oneStepBefore+twoStepsBefore;
            twoStepsBefore=oneStepBefore;
            oneStepBefore=result;
        }

        System.out.println("need steps :\t"+oneStepBefore);
    }
}
