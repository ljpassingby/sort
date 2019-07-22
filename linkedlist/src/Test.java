import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class Test {

    @org.junit.Test
    public void testClase() {
        TestClase testClase = new TestClase();
    }


    @org.junit.Test
    public void test() {
        int[] arr = {1,2,3};
        int[] ar = {1,2,3};
        System.out.println(arr.equals(ar));
        System.out.println(Arrays.equals(arr, ar));
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

