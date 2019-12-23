package localtest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * <p>
 * 基于优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 14:00
 */
public class PriorityQueueTest {

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return id + "-" + name;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        queue1.add(2);
        queue1.add(1);
        queue1.add(3);
        while (!queue1.isEmpty()) {
            Integer result = queue1.poll();
            System.out.println(result);
        }

        // 有限队列实现的比较器
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        };

        Queue<Student> queue2 = new PriorityQueue<>(comparator);
        queue2.add(new Student(2, "B"));
        queue2.add(new Student(1, "A"));
        queue2.add(new Student(3, "C"));

        while (!queue2.isEmpty()) {
            Student student = queue2.poll();
            System.out.println(student.toString());

        }

    }
}
