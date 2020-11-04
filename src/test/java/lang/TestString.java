package lang;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @ClassName:TestString
 * @Description //测试String类
 * @Author: chenyunxuan
 * @Date: 2020/6/29 10:23 上午
 * @version: 1.0.0
 **/
@Slf4j
public class TestString {

    public static void main(String[] args) {
        //测试各种比较方法
        String ss = "111123";
        String ss1 = new String("111123");
        String ss4 = "111123";
        String ss2 = new String("111123");
        String ss3 = new String("2");
        log.info("string =->{}", ss1 == ss4);
        log.info("string =->{}", ss == ss4);
        log.info("string equal->{}", ss1.equals(ss2));
        log.info("string compareTo->{}", "11".compareTo("1111"));
        log.info("string charAt->{}", "123456".charAt(0));
        log.info("string codePointAt(int index)->{}", "anc".codePointAt(1));
        log.info("string codePointAt(int index)->{}", "anc".codePointBefore(2));
        //测试反序列化参数ObjectStreamField
        testObjectStreamField();
        //测试用字符数组构造String
        char[] a = {'1', '2', '3', '4'};
        log.info("new string char[]->{}", new String(a, 2, 1));
        //测试用int数组构造String(取每一位int值对应的ASCII码输出 参照ASCII码对照表)
        int[] b = {47, 48, 49, 50};
        log.info("new string int[]->{}", new String(b, 0, 4));

    }

    /**
     * @description: 关于ObjectStreamField的测试
     * @author: chenyunxuan
     * @updateTime: 2020/11/2 9:56 上午
     */
    static void testObjectStreamField() {
        File file = new File("user.txt");
        User user = new User("小美", 18, "222");
        //将对象保存在文件中
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //对象序列化的方法
            out.writeObject(user);
            //关闭
            out.close();
            fileOut.close();
            log.info("对象已被序列化");
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInput);
            //对象反序列化的方法
            User userRead = (User) in.readObject();
            //关闭
            fileInput.close();
            in.close();
            log.info("对象已被反序列化" + " " + userRead.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class User implements Serializable {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = 4760229593345099240L;
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
        /**
         * 住址
         */
        private transient String address;

        private static final ObjectStreamField[] serialPersistentFields = null;

        public User(String name, Integer age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
