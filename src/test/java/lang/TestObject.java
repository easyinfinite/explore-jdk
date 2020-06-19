package lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:TestObject
 * @Description 测试object
 * @Author: chenyunxuan
 * @Date: 2020/6/19 2:41 下午
 * @version: 1.0.0
 **/
@Slf4j
public class TestObject {

    public static void main(String[] args) {
        //初始化一个object类
        Object a = new Object();
        Object b = new Object();
        log.info("a ->{}", a);
        boolean checkSame = a.equals(b);
        log.info("a compare b ->{}", checkSame);
        int hashA = a.hashCode();
        int hashB = a.hashCode();
        log.info("hashA ->{},hashB ->{}", hashA, hashB);
    }
}
