package deleted;

 abstract class A{
   int A()
    {
        System.out.println("A");
        return 5;
    }
}

class B extends A{
  int  B(){
        System.out.println("B");
        return 4;
    }
}

public class Demo
{
    public static void main(String[] args) {
//        A a= new A();     // compiled error
        A a2= new B();
        B b2= new B();
//        B b= new A(); // compiled error we have b reference so we need to cast that will give class cast exception


    }
}
