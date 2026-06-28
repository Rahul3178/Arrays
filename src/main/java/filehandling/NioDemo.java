package filehandling;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NioDemo
{
    public static void main(String[] args) throws IOException {

        Path path = Path.of("nioTest.txt");
        System.out.println(path);

        FileChannel writeChannel = FileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

            String text= """
                    Hello , How are you
                    Rahul Kumar
                    """;

        ByteBuffer  writeBuf = ByteBuffer.allocate(text.length());
        writeBuf.put(text.getBytes());
        writeBuf.flip(); // flip to read mode for channel
        writeChannel.write(writeBuf);



    }
}
