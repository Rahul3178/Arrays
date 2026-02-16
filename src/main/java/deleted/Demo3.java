package deleted;
class Test{

    public void getNumber(Integer a, Integer b){
        System.out.println("Integer"+a+"\t"+b);
    }
    public void getNumber(Long a, Long b){
        System.out.println("Long"+a+"\t"+b);
    }

    public void getNumber(long a, long b){
        System.out.println("long"+a+"\t"+b);
    }

    // var args must be the last other wise it will gove compile time error
//    public void getNumber(int...a, int b){
//        System.out.println(a+""+b);
//    }

    public void getNumber(byte a, byte b){
        System.out.println("byte"+a+"\t"+b);
    }
}
public class Demo3
{
    public static void main(String[] args) {
        Test t = new Test();
        t.getNumber(3,5);
    }
}
