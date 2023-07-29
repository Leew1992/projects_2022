package learning_3.week_1;

import learning_3.week_1.dto.PersonDto;
import learning_3.week_1.dto.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class WirdCardDto<T> {

    public static void main(String[] args) {
        WirdCardDto<PersonDto> wirdCardDto = new WirdCardDto<>();
        List<PersonDto> list = new ArrayList<>();
        list.add(new PersonDto());
        wirdCardDto.test1(list, new PersonDto());
    }

    /**
     * 数组：
     * 支持协变
     * 但存在多类型问题
     */
    public void test() {
        Integer[] intArr = new Integer[5];
        // 数组默认就支持型变，因此下面代码是正确的
        Number[] numArr = intArr;
        // numArr只要求集合元素是Number，因此下面代码也可通过编译
        numArr[0] = 3.4;  // ①
    }

    /**
     * 特点：
     * 类型不确定
     * 支持协变
     */
    public void test(List<? extends T> list, List<? extends T> list2) {
        list = list2;
        System.out.println(list);
    }

    /**
     * 集合：
     * 不支持修改：list.add
     */
    public void test1(List<? extends T> list, T t) {
        // list.add(t);
        System.out.println(list);
    }

    /**
     * 单个对象：
     * 不支持修改，extends
     * 支持修改，super
     */
    public void test2() {
        // extends
        WirdCardDto<? extends TeacherDto> wirdCardDto = new WirdCardDto<>();
        wirdCardDto.getT();
        // wirdCardDto.setT(new TeacherDto());
        System.out.println(wirdCardDto.getT());

        // super
        WirdCardDto<? super TeacherDto> wirdCardDto2 = new WirdCardDto<>();
        wirdCardDto2.getT();
        wirdCardDto2.setT(new TeacherDto());
        System.out.println(wirdCardDto2.getT());
    }

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
