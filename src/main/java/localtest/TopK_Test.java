package localtest;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 14:21
 */
public class TopK_Test {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int K = 10;

    public void add(int i) {
        if (queue.size() < K) {
            queue.add(i);
        } else {
            // min heap
            int min = queue.peek();
            if (i > min) {
                queue.poll();
                queue.add(i);
            }
        }
    }

    public void print() {
        while (!queue.isEmpty()) {
            int res = queue.poll();
            System.out.println(res);
        }

    }

    /**
     * 求 Top K 大的元素
     *
     * @param args
     */
    public static void main(String[] args) {
        TopK_Test topKTest = new TopK_Test();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            topKTest.add(r.nextInt(100));
        }
        topKTest.print();


    }
}
