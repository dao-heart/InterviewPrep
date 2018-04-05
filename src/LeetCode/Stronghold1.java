package LeetCode;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Stronghold1 {


    public static void main(String[] args)throws Exception{
        String host = "jsonmock.hackerrank.com";
        Socket socket = new Socket(host, 80);

        String input = "spiderman";
        String request = "GET /api/movies/search/?Title="+input+" HTTP/1.0\r\n\r\n";
        OutputStream os = socket.getOutputStream();
        os.write(request.getBytes());
        os.flush();

        InputStream is = socket.getInputStream();
        int ch;
        while( (ch=is.read())!= -1)
            System.out.print((char)ch);
        socket.close();
    }
}
