package learning_4.aaa;

public class GenericClass<T, V, K, E> {
    private T t;
    private V v;
    private K k;
    private E e;

    public GenericClass(T t, V v, K k, E e) {
        this.t = t;
        this.v = v;
        this.k = k;
        this.e = e;
    }

    public <T, E> T test(T t, E e) {
        System.out.println(t);
        return t;
    }

    public void test() {

    }
}
