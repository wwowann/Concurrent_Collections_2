import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapWork implements Runnable {
    private final ConcurrentHashMap<String, Integer> concurrentHashMap;
    private final List<Integer> array;

    public ConcurrentHashMapWork(ConcurrentHashMap<String, Integer> concurrentHashMap, List<Integer> array) {
        this.concurrentHashMap = concurrentHashMap;
        this.array = array;
    }

    public void run() {
        long start = System.currentTimeMillis();
        for (Integer val : array) {
            concurrentHashMap.put("Value " + val.hashCode(), val);
        }
        for (Map.Entry<String, Integer> val : concurrentHashMap.entrySet()) {
            System.out.println(Thread.currentThread().getName() + val.getValue());
        }
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения ConcurrentHashMap " + (finish - start));
    }
}