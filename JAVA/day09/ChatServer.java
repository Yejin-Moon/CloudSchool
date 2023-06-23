package day09;

import java.io.*; import java.net.*;

//키보드로 입력받은 데이터를 채팅 상대에게 전송하는 스래드
class DataSender extends Thread {
    private OutputStream out ;
    public DataSender(OutputStream out ){ this.out = out ; }
    public void run() {
        byte[] buf = new byte[1024];
        int count = 0 ;
        try{
            while( (count = System.in.read(buf))!= -1 ) //키보드로 입력
            { out.write(buf,0,count); //채팅 상대에게 전송
                }
            out.close();
        }catch(IOException e){e.printStackTrace(); }
    }
}

// 채팅상대에게 전송받은 데이터를 Console에 출력하는 스래드
class DataReciever extends Thread {
    InputStream in;
    public DataReciever(InputStream in) { this.in = in; }
    public void run() {
        byte[] data = new byte[1024];
        int count = 0;
        try { //채팅 상대에게 데이터받음
            while ((count = in.read(data)) != -1)
            { // Console에출력
                System.out.write(data, 0, count);
                System.out.flush();
            }
            in.close();
        } catch (IOException e) { e.printStackTrace();
        }
    }
}

public class ChatServer {
public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(10000);
    Socket sock = serverSocket.accept();
    OutputStream out = sock.getOutputStream();
    InputStream in = sock.getInputStream();
    new DataSender(out).start();
    new DataReciever(in).start();
    }
}