package lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:TestInteger
 * @Description //测试Integer类
 * @Author: chenyunxuan
 * @Date: 2020/6/29 10:23 上午
 * @version: 1.0.0
 **/
@Slf4j
public class TestInteger {

    public static void main(String[] args) {
        log.info("max_value ->{}", Integer.MAX_VALUE);
        log.info("min_value ->{}", Integer.MIN_VALUE);
        log.info("Integer type ->{}", Integer.TYPE);
        log.info("Integer size ->{}", stringSize(99998));

        //引出经典面试题,所以integer比较时用equals比较稳妥
        Integer a = 127, b = 127, c = 129, d = 129;
        log.info("use integer cache ->{}", a == b);
        log.info("not use integer cache ->{}", c == d);

        Integer newString = -2147483648;
        newString.toString();
        log.error("integer nullInt=new Integer(\"ssssss\")");
        log.info("Integer decode sixteen Integer.decode(\"0xff\")->{} Integer.decode(\"#ff\")->{}", Integer.decode("0xff"), Integer.decode("#ff"));
        log.info("Integer decode eight Integer.decode(\"-071\")->{}", Integer.decode("-071"));
    }

    //方便取出int型数字对应字符串的长度
    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    // 快速定位integer长度
    static int stringSize(int x) {
        for (int i = 0; ; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }
}
