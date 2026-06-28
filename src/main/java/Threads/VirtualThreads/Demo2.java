package Threads.VirtualThreads;


import java.util.List;
import java.util.concurrent.StructuredTaskScope;


public class Demo2
{
    public static String getAirport(String item){
        List<String> iata= List.of("AUS","ATS","TUS","USA");

        String data = iata.stream().filter(s->s.equals(item)).toString();

        if (data== null)
        {
            throw new RuntimeException("Not found");
        }

        return data;
    }
    public static void main(String[] args) {

        List<String> iata= List.of("AUS","ATS","TUS","USA");

//        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//
//        }


    }
}
