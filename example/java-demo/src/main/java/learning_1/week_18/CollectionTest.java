package learning_1.week_18;

// import org.apache.commons.lang.StringEscapeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list = Collections.synchronizedList(list);
        System.out.println("make list become thread safe!");

        String aa = "[{\"tags\":[{\"tagName\":\"首发福利\",\"tagStyle\":\"#ff7700\",\"tagStyleType\":1}],\"couponId\":978870734,\"couponName\":\"10\",\"couponAttr\":\"无门槛立减\",\"couponRange\":\"限门票/线路类产品可用\",\"validityPeriod\":\"2021-02-28前可用\",\"couponDesc\":\"携程铂金贵宾及以上可享\"},{\"tags\":[{\"tagName\":\"限量领取\",\"tagStyle\":\"#ff7700\",\"tagStyleType\":1}],\"couponId\":573546680,\"couponName\":\"50\",\"couponAttr\":\"满550元可用\",\"couponRange\":\"限「人气门票」产品可用\",\"validityPeriod\":\"2021-02-28前可用\",\"couponDesc\":\"携程铂金贵宾及以上可享\"}]";
        // System.out.println(StringEscapeUtils.escapeJava(aa));
    }
}
