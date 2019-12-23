package localtest;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2019-12-16 12:28
 */
public class input {
    static void pong(){
        System.out.println("pong");
    }

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        thread.start();
        thread.run();
        System.out.println("--");


        // 方式1 输入
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        System.out.println(s);
//        input.close();
        // 方式2 输入
//        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
//        String s2 = input2.readLine();
//        System.out.println(s2);
//
//        // 10 -> 2
//        System.out.println(Integer.toBinaryString(255));
//        // 10 -> 16
//        System.out.println(Integer.toHexString(255));
//        // 16 -> 10
//        System.out.println(Integer.valueOf("A2", 16).toString());
//        // 2 -> 10
//        System.out.println(Integer.valueOf("0101", 2).toString());
//
//        String ip = "10.70.44.68";
//        ip.length();
//        ip.split(".");
//        String zer= "00000000";
//        System.out.println(zer.substring(0,1));
//        Map result = new HashMap();
//        if (result.keySet().contains(1)){
//
//        }

//        Scanner scan = new Scanner(System.in);
//        String numStr = scan.nextLine();
//        System.out.println(numStr.length());
//
//
//        SortedSet<Integer> set = new TreeSet();
//
//        StringBuilder builder = new StringBuilder();

//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//
//        Scanner scan = new Scanner(System.in);
//        String numStr = scan.nextLine();
//        SortedSet<Integer> set = new TreeSet();
//        for(int i=numStr.length()-1;i>=0;i--){
//            set.add(Integer.valueOf(String.valueOf(numStr.charAt(i))));
//        }
//        StringBuilder builder = new StringBuilder();
//        Iterator iterator =  set.iterator();
//        while(iterator.hasNext()){
//            builder.append((int)iterator.next());
//        }
//        System.out.println(builder.toString());

//        String text = "uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx";
//        for(int i=0; i< text.length(); i++){
//            int temp = Integer.valueOf(text.charAt(i));
//            if(temp > 0 && temp <=127){
//                System.out.println(String.valueOf(text.charAt(i)));
//            }
//
//        }

    }
}
