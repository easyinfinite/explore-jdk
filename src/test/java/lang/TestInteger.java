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
        log.info("Integer bitcount -> {}", Integer.bitCount(111));
        //不借助变量实现元素互换
        int aa = 520, bb = 111;
        aa ^= bb ^ (bb = aa);
        log.info("aa ->{},bb ->{}", aa, bb);
        //数字反转
        log.info("reverse ->{}",Integer.reverse(1426063360));
        //无符号比较
        log.info("compareUnsigned ->{}",Integer.compareUnsigned(1,-1));
        log.info("compare ->{}",Integer.compare(1,-1));
        //转为二进制字符串
        log.info("toBinaryString ->{}",Integer.toBinaryString(111));
        String binary="0x80000000";
//        log.info("parseUnsignedInt binary->{}",Integer.parseUnsignedInt(binary,16));
//        log.info("parseInt binary->{}",Integer.parseInt(binary,10));
        log.info("numberOfLeadingZeros 110->{}",Integer.numberOfLeadingZeros(110));
        log.info("highestOneBit 12->{}",Integer.lowestOneBit(112));
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
