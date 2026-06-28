package deleted;

public class SwitchPatternMatchingInstance
{
    public static void main(String[] args) {
        Object obj="Hello world";

        if (obj instanceof String)
        {
            String st =(String) obj;

            System.out.println("Before java 16 \t"+st);
        }

        if (obj instanceof  String s)
        {
            System.out.println("After java 17 \t"+s);
        }

        obj =123;
        formater(obj);
        formater(null);
        formater(23.0f);



    }
    public  static  void formater(Object obj)
    {
        switch (obj)
        {
            case String s-> System.out.println("Instance of String");
            case Integer i-> System.out.println("Instance of Integer");
            case null -> System.out.println("Instance of  null");
            default-> System.out.println("No matching instance");

        }
    }
}
