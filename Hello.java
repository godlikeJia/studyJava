import java.util.*;
import java.text.SimpleDateFormat;

class Base {
    public void show() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("time");
        }
        for (String tmp:list) {
            System.out.println(tmp);
        }
        System.out.println("Base::show()");
    }

    public String getDate() {
        String temp_str="";  
        Date dt = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");  
        temp_str=sdf.format(dt);  
        return temp_str;   
    }
}

public class Hello {
    public static void main(String [] args) {
        System.out.println("Hello, World");
        Base b = new Base();
        b.show();
        System.out.println(b.getDate());


        Test t = new Test();
        t.setBytes();
        byte[] bytes = t.bytes;

        String str = new String(bytes);
        System.out.println(str);
    }

}

class Test {
    public byte[] bytes;
    public void setBytes() {
        String str = "Hello";
        bytes = str.getBytes();
        bytes[1] = 'z';
        System.out.println(str);
    }
}
