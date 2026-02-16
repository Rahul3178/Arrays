package deleted;

class P{


  public void  getName(){
      System.out.println("P");
    }
}

class Q extends P{

    @Override
    public void getName(){
        System.out.println("Q");
    }

    public void demo()
    {
        System.out.println("demo");
    }
}
public class Demo2
{
    public static void main(String[] args) {
        P p1= new P();
        p1.getName();

        P p2 = new Q();
        p2.getName();
//        p2.demo() ; bcz we are using parent reference

        Q q1= new Q();
        q1.getName();
        q1.demo();

//        Q p3= new P(); class cast exception

    }
}
