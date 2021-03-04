import java.util.List;
import java.util.Map;

public class MethodHashMap implements Runnable {
    private final Map<String, Integer> map;
    private final List<Integer> array;

    public MethodHashMap(Map<String, Integer> map, List<Integer> array) {
        this.map = map;
        this.array = array;
    }

    public void run() {
        long start = System.currentTimeMillis();
        for (Integer val : array) {
            map.put("Value " + val.hashCode(), val);
        }
        for (Map.Entry<String, Integer> val : map.entrySet()) {
            System.out.println(Thread.currentThread().getName() + val.getValue());
        }
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения " + Thread.currentThread().getName() + " " + (finish - start));
    }
}
