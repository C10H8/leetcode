package localtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * <p>
 * 方式1： List中的元素自己实现一个Comparable接口实现一个自然排序
 * 方式2： 我们通过传入一个实现了Comparator接口实现一个排序
 * 参考： http://php-note.com/article/205.html
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 16:13
 */
public class SortList1 {

    public static class Person implements Comparable {
        int age;
        String name;

        public Person(int id, String name) {
            this.age = id;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int id) {
            this.age = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            Person person = (Person) o;
            if (this.getAge() < person.getAge()) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(2, "name2"));
        list.add(new Person(3, "name3"));
        list.add(new Person(1, "name1"));
        list.add(new Person(4, "name4"));
        System.out.println("排序前");
        list.forEach(item -> System.out.println(item.toString()));
        System.out.println("排序后");
        list.sort(null);
        list.forEach(item -> System.out.println(item.toString()));


    }
}
