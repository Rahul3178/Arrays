package SystemDesign;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class DemoCheckSum
{
    static void main() {

        String data = "Hello World";

        byte[] byt=data.getBytes();


        System.out.println(getCRC32Checksum(byt));

    }

    public static long getCRC32Checksum(byte[] byt)
    {
        Checksum cr32= new CRC32();


        cr32.update(byt,0,byt.length);



        return cr32.getValue();
    }
}
