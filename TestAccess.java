public class TestAccess {
    public static void main(String args[]) {
        TT tt = new TT();
        tt.m();
    }
}

class T {
    private int i;
    public int j;
    protected int k;
    int m;  // default

}

class TT {
    public void m() {
        T t = new T();
        //System.out.println(t.i);
        System.out.println(t.j);
        System.out.println(t.k);
        System.out.println(t.m);
    }
}
