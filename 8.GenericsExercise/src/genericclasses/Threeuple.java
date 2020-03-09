package genericclasses;

public class Threeuple<T1, T2, T3> extends Tuple<T1, T2> {
    private T3 item3;

    public Threeuple() {}

    public Threeuple(T1 item1, T2 item2, T3 item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    public T3 getItem3() {
        return item3;
    }

    public void setItem3(T3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString(){
        return this.getItem1() + " -> " + this.getItem2() + " -> " + this.getItem3();
    }
}
