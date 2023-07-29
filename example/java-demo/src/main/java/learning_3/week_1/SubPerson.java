package learning_3.week_1;

import learning_3.week_1.dto.PersonDto;

/**
 * 子类继承了泛型父类，
 * 编辑器会默认加一个桥接方法
 */
public class SubPerson extends PersonDto<Integer> {
    @Override
    public Integer getName() {
        return super.getName();
    }

    @Override
    public void setName(Integer name) {
        super.setName(name);
    }

    // 桥接方法
    /*public void setName(Object name) {
        super.setName((Integer) name);
    }*/
}
