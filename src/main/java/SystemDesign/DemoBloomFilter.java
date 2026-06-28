package SystemDesign;

import java.util.BitSet;
import java.util.function.Function;

class BloomFilter
{
    private final int size;
    private final BitSet bitArray;
    private final Function<String,Integer>[] hashFunctions;


    public BloomFilter(int size, Function<String, Integer>... hashFunctions) {
        this.size = size;
        this.bitArray = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }


    // method to add an element
    public void add(String item){
        for (Function<String,Integer> hashFunction:hashFunctions)
        {
            int index=Math.abs(hashFunction.apply(item) %size);
            bitArray.set(index);
        }
    }


    // method to check if an element is already present or not
    public boolean mightContain(String item)
    {
        for (Function<String,Integer> hashFunction:hashFunctions)
        {
            int index=Math.abs(hashFunction.apply(item) %size);
            if (!bitArray.get(index))
            {
                return false;
            }
        }
        return true;
    }
}

public  class DemoBloomFilter{
    public static void main(String[] args) {

        BloomFilter bloomFilter= new BloomFilter(100, String::hashCode, s-> s.length() * 31,
                s->(s.hashCode() *17));

        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("grape");

        System.out.println("apple? " + bloomFilter.mightContain("apple"));   // true
        System.out.println("banana? " + bloomFilter.mightContain("banana")); // true
        System.out.println("grape? " + bloomFilter.mightContain("grape"));   // maybe false
    }

    }
