import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLRU extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public TestLRU(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    //复写这个函数的作用是当存满了，而且又要新加元素时，则自动去掉最后一个元素
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        TestLRU lru = new TestLRU(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru.get(1));
    }
}
