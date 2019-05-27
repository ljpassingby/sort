public class TestJVM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {

        testTenuringThreshold();
    }

    public static void testTenuringThreshold() {
        /*测试长期存活的对象进入老年代
        参数
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails
        -XX:SurvivorRatio=8
        -XX:MaxTenuringThreshold=1
        -XX:+PrintTenuringDistribution
        -XX:+UseSerialGC
        */
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 5];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void testPretenureSizeThreshold() {
        /*大对象直接生成在老年代
        参数
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails
        -XX:SurvivorRatio=8
        -XX:+UseSerialGC
        -XX:PretenureSizeThreshold=3146728
        */

        byte[] allocation;
        allocation = new byte[4 * _1MB];    //直接分配在老年代
    }

    public static void testAllocation() {
        /*对象优先诞生于新生代
        参数
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails
        -XX:SurvivorRatio=8
        */
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];   //这句会触发GC
    }
}
