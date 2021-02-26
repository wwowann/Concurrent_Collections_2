import java.util.List;
import java.util.Map;

public class SynchronizedMapWork implements Runnable {
    final private Map<String, Integer> synchronizedMap;
    final private List<Integer> array;

    public SynchronizedMapWork(Map<String, Integer> synchronizedMap, List<Integer> array) {
        this.synchronizedMap = synchronizedMap;
        this.array = array;
    }

    public void run() {
        long start = System.currentTimeMillis();
        for (Integer val : array) {
            synchronizedMap.put("Value " + val.hashCode(), val);
        }
        for (Map.Entry<String, Integer> val : synchronizedMap.entrySet()) {
            System.out.println(Thread.currentThread().getName() + val.getValue());
        }
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения Collections.synchronizedMap " + (finish - start));
    }
}
