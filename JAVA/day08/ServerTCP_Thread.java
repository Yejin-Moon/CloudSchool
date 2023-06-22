package day08;
//여러 서버 받으려면
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerThread extends Thread{
    //넘어온 소켓 받기
    Socket sock;
    OutputStream out;
    InputStream in;
    TCPServerThread(Socket sock){
        this.sock = sock;
    }
    public void run(){
        try {
            this.out = sock.getOutputStream();
            this.in = sock.getInputStream();
            int data=0;
            while((data = in.read())!=-1){
                System.out.write(data);
            }
            System.out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
            this.out.close();
            this.in.close();
            }catch (IOException e) { }
        }
    }
}

public class ServerTCP_Thread {
    public static void main(String[] args) throws IOException {
        //서버
        ServerSocket s = new ServerSocket(10000);
        while(true){
            Socket sock = s.accept();
            TCPServerThread t = new TCPServerThread(sock);
            t.start();
        }
    }
}
