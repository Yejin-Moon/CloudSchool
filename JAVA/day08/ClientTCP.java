package day08;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        //클라이언트
        Socket sock = new Socket("127.0.0.1",10000);
        OutputStream out = sock.getOutputStream();
        
        byte[] buffer = new byte[1024];
        int count = 0;
        while((count = System.in.read(buffer))!=-1){//ctrl+c 누르면 종료
            out.write(buffer,0,count);
        }
        
        //out.write("안녕하세요".getBytes());//바이트로 바꿔서 보내야함
        out.close();
    }
}
