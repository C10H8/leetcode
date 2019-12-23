package localtest;


import java.util.*;
import java.util.Map.Entry;


/**
 * Created by IntelliJ IDEA.
 * 参考：https://juejin.im/post/5a45d6ec6fb9a045076ffccb
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-23 11:38
 */
public class SetMapListTest {
    // 静态内部类
    public static class Users {
        int age;
        String name;


        public Users(int age, String name) {
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
            return "Users{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 对map集合排序
     *
     * @param hashMap
     * @return
     */
    private static HashMap<Integer, Users> sortedHashMap(HashMap<Integer, Users> hashMap) {
        // 首先拿到 map 的键值对集合
        Set<Entry<Integer, Users>> entrySet = hashMap.entrySet();
        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
        ArrayList<Entry<Integer, Users>> list = new ArrayList<Entry<Integer, Users>>(entrySet);
        Collections.sort(list, new Comparator<Entry<Integer, Users>>() {
            @Override
            public int compare(Entry<Integer, Users> o1, Entry<Integer, Users> o2) {
                ///按照要求根据 User 的 age 的倒序进行排
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        // 定义排序好的对象
        LinkedHashMap<Integer, Users> linkedHashMap = new LinkedHashMap<Integer, Users>();

        //将 List 中的数据存储在 LinkedHashMap 中
        for (Entry<Integer, Users> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static void main(String[] args) {
        // List list = Collections.synchronizedList(new ArrayList(...));
        // List list = Collections.synchronizedList(new LinkedList(...));
        // 1、List
        List<String> mList = new ArrayList<String>();
        mList.add("hello");
        mList.add("张三");
        mList.add("李四");
        mList.add("王五");
        // 方法一
        for (int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }
        // 方法二
        for (String string : mList) {
            System.out.println(string);
        }
        // 方法三
        Iterator<String> it = mList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // 把字符串内容挨个输出
        String str = "ABCDEFG";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        // 2、Set
        // HashSet, 不保证集合的迭代顺序, 元素乱序
        // TreeSet, 保证元素的自然顺序
        // LinkedHashset: 保证元素添加的自然顺序

        // 3、map
        // Hashtable , 同步的，not-null
        // HashMap , 非同步的，allow-null
        HashMap<Integer, Users> hashMap = new HashMap<Integer, Users>();
        hashMap.put(1, new Users(22, "小娟"));
        hashMap.put(3, new Users(21, "秀秀"));
        hashMap.put(2, new Users(28, "小列"));

        System.out.println("排序前");
        System.out.println(hashMap.toString());

        HashMap<Integer, Users> sortedHashMap = sortedHashMap(hashMap);
        System.out.println("排序后:");
        System.out.println(sortedHashMap.toString());
        // HashMap 的遍历输出

        // 方式1， key迭代器
        Iterator<Integer> mapIt = sortedHashMap.keySet().iterator();
        while (mapIt.hasNext()) {
            int key = mapIt.next();
            System.out.println(sortedHashMap.get(key));

        }

        // 方式2，Entry 迭代器(推荐)
        Iterator<Entry<Integer, Users>> entryIt = sortedHashMap.entrySet().iterator();
        while (entryIt.hasNext()) {
            Entry<Integer, Users> entry = entryIt.next();
            int key = entry.getKey();
            Users value = entry.getValue();
            System.out.println("key-->" + key + "\tvalues-->" + value);
        }


    }
}
