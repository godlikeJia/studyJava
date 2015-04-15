public class Something {
    public static void main(String[] args) {
        Other o = new Other();
        System.out.println(o.i);
        new Something().addOne(o);
        System.out.println(o.i);
    }

    public void addOne(final Other o) {
        o.i ++;
    }
}

class Other {
    public int i;
    public Other() {
        i = 0;
    }
}
