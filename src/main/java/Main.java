import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Integer> mapValue = new ArrayList<Integer>();// массив с целыми числами
        Map<String, Integer> arrayHashMap = new HashMap<String, Integer>();// мапа для synchronizedMap
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(arrayHashMap);
        ConcurrentHashMap<String, Integer> concurrentHashMap =
                new ConcurrentHashMap<String, Integer>();//мапа для ConcurrentHashMap
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            mapValue.add(random.nextInt(100));
        }
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService1.submit(new MethodHashMap(concurrentHashMap, mapValue));
        executorService1.shutdown();
        executorService2.submit(new MethodHashMap(synchronizedMap, mapValue));
        executorService2.shutdown();

    }

}
