package learning_3.week_1.dto;

import java.util.ArrayList;
import java.util.List;

public class GenericsDto<T> {

    public static void main(String[] args) {
        GenericsDto<PersonDto> genericsDto = new GenericsDto<>();
        List<PersonDto> personList = new ArrayList<>();
        personList.add(new PersonDto());
        genericsDto.test1(personList, new PersonDto());
    }

    /**
     * 特点：
     * 类型调用时确定
     * 不支持协变
     */
    public <T, E extends T, F extends T> void test(List<E> list, List<F> list2, T t) {
        // list = list2; // 报错，不能做型变，协变&逆变
        System.out.println(list);
    }

    /**
     * 集合：
     * 支持修改，list.add
     */
    public <T> void test1(List<T> list, T t) {
        PersonDto personDto = (PersonDto)list.get(0);
        personDto.setName("aaa");
        list.add(t);
        System.out.println(list);
    }

    /**
     * 单个对象：
     * 支持修改
     */
    public void test2() {
        GenericsDto<PersonDto> genericsDto = new GenericsDto<>();
        genericsDto.setT(new PersonDto());
        genericsDto.getT();
    }

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
