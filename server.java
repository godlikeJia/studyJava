import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;

public class server {
    private static final int port = 8090;

    public static void main(String args[]) {
        try {
            String str = "Hello, World!";
            System.out.println(str.getBytes());
            ServerSocket sock = new ServerSocket(port);
            Socket s = sock.accept();
            OutputStream out = s.getOutputStream();
            out.write(str.getBytes());
        } catch (IOException e) {
        }
    }
}
