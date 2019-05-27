import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String [] args) throws Exception {
        fillHeap(1000);
        System.gc();
    }


    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    @org.junit.Test
    public void testClase() {
        TestClase testClase = new TestClase();
    }

    @org.junit.Test
    public void test() {
        TreeSet ts = new TreeSet();
        ts.add(3);
        ts.add(2);
        ts.add(7);
        ts.add(6);
        ts.add(5);
        ts.add(8);
        System.out.println(ts.pollLast());
    }

}
class TestClase {
    int i = 1;
    {
        System.out.println(++i);
        print("构造块");
    }

    TestClase() {
        print("构造函数");
    }

    public void print(String str) {
        System.out.println(str + (++i));
    }
}

