package localtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 16:23
 */
public class SortList2 {
    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1 instanceof Person) {
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
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

        // 简写方式
//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if (o1 instanceof Person) {
//                    if (o1.getAge() < o2.getAge()) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                }
//                return 0;
//            }
//        });


        //list.sort(new PersonNameComparator());
        list.forEach(item -> System.out.println(item.toString()));


    }

}
