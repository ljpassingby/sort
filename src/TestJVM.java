import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJVM {
    public static void main(String[] args) {
        Date object = new Date();
        List<Date> list = new ArrayList<>();
        while (true) {
            list.add(object);
        }
    }
}
