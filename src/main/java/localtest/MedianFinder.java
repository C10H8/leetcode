package localtest;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 15:33
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // 使用有限队列实现一个大顶堆
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.peek());
        maxHeap.poll();
        // 平衡中
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return maxHeap.peek() + minHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    /**
     * 利用大顶堆和小顶堆实现找中位数
     *
     * @param args
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(3);
        medianFinder.addNum(5);
        medianFinder.addNum(7);
        medianFinder.addNum(9);
        medianFinder.addNum(11);

        System.out.println(medianFinder.findMedian());
    }
}
