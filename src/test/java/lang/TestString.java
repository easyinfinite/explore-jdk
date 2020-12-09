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
        String ss = "test1";
        String ss1 = new String("test1");
        String ss4 = "test1";
        String ss2 = new String("test1");
        String ss3 = new String("2");
        log.info("string =->{}", ss1 == ss4);
        log.info("string =->{}", ss == ss4);
        log.info("string equal->{}", ss1.equals(ss2));
        log.info("string compareTo->{}", "11".compareTo("1111"));
        log.info("string charAt->{}", "123456".charAt(0));
        log.info("string codePointAt(int index)->{}", "anc".codePointAt(1));
        log.info("string codePointAt(int index)->{}", "anc".codePointBefore(2));
        String str1 = "test2";
        log.info("string test2 codePointCount(int begin,int end)->{}", str1.codePointCount(0, str1.length()));
        log.info("string test2 length()->{}", str1.length());
        String str2 = "\uD875\uDD6B\uD875\uDD6B";
        log.info("string \\uD875\\uDD6B format->{}", str2);
        log.info("string \\uD875\\uDD6B codePointCount(int begin,int end)->{}", str2.codePointCount(0, str2.length()));
        log.info("string \\uD875\\uDD6B length()->{}", str2.length());
        log.info("string \\uD875\\uDD6B offsetByCodePoints()->{}", str2.offsetByCodePoints(0, 1));
        log.info("string hash->{}", str2.hashCode());
        log.info("string concat->{}", str2.concat(ss4));
        String str3 = "12345";
        Object str4 = "12345";
        StringBuilder stringBuilder = new StringBuilder("12");
        stringBuilder.append("335");
        log.info("string contains->{}", str3.contains(stringBuilder));
        StringBuffer buff = new StringBuffer("12");
        buff.append("335");
        log.info("string equals->{}", str3.equals(str4));
        CharSequence cs = "12345";
        log.info("string equals->{}", str3.contentEquals(cs));
        String str5 = "1111";
        String str6 = new String("1111");
        char aa = 22943;
        System.out.println(aa);
        log.info("string equalsIgnoreCase->{}", str5.equalsIgnoreCase(str6));
        //测试反序列化参数ObjectStreamField
        testObjectStreamField();
        //测试用字符数组构造String
        char[] a = {'1', '2', '3', '4'};
        log.info("new string char[]->{}", new String(a, 2, 1));
        //测试用int数组构造String(取每一位int值对应的ASCII码输出 参照ASCII码对照表)
        int[] b = {47, 48, 49, 50};
        log.info("new string int[]->{}", new String(b, 0, 4));
        String testHash = "1234";
        log.info("testHash hash[]->{}", testHash.hashCode());
        String testHash1 = new String("4321");
        log.info("testHash hash[]->{}", testHash.hashCode());
        String intern1 = "12345";
        String intern2 = new String("12345");
        String intern3 = new String("12345");
        log.info("testintern intern2[]->{}", intern1 == intern2.intern());
        log.info("testintern intern2[]->{}", intern2.intern() == intern3.intern());
        String trimString = "    baidu baiduuuuuuuu baidubaiduuuuuuuu";
        String trimStringReplaceAll = "    baidu baiduuuuuuuu baidubaiduuuuuuuu";
        log.info("test trim trimString[]->{}", trimString.trim());
        log.info("test replace trimString[]->{} , oldString->{}", trimString.replace("wwww", ""), trimString);
        StringBuilder builder = new StringBuilder();
        builder.append("baidu");
        StringBuilder builder1 = new StringBuilder();
        builder1.append("baiduuuuuuuu");
        log.info("test replace trimString[]->{},oldString->{}", trimStringReplaceAll.replace(builder, builder1), trimStringReplaceAll);
        String searchStr = "wooowoooowooo";
        String indexStr = "woo";
        log.info("test indexOf searchStr[]->{},indexStr->{}", searchStr.indexOf(indexStr), indexStr);
        log.info("test lastIndexOf searchStr[]->{},indexStr->{}", searchStr.lastIndexOf(indexStr, 4), indexStr);
        String joinA="abc";
        String joinB="def";
        String[] joinAB={"abc","def"};
        log.info("test join joinAB->{}", String.join("-", joinAB));
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
