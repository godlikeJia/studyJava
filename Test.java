import com.jiawh.*;

public class Test implements Listener {
    public static void main(String[] args) {
        Test t = new Test();
        t.show();
        t.testNew(new New());
    }

    @Override
    public void show() {
        System.out.println("Hello Everyone!!!");
    }

    @Override
    public void print() {
        System.out.println("Hello print()!!!");
    }

    public void testNew(New n) {
        n.hello();
    }
}

class New {
    public void hello() {
        System.out.println("New Hello!!!");
    }
}

