import java.util.*;

public class Struct {
    public static void main(String[] args) {

        String[] strArray = new String[3];
        List<String> strList = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        //PriorityQueue 优先队列 java用其实现大小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> (o2-o1) //升序排列
        );

    }
}
