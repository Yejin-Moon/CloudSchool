package day08;
/*
 TCP/IP : 연결지향. 
          신뢰성. 보냈는데 답장 안오면 다시 보냄. 
          흐름제어(응답 속도 빠르면 빨리 보내고 늦으면 트래픽 많아서 지연되나보다 해서 속도 늦춤)
 (연결지향과 연결의 차이 
 연결지향 : 실제 연결된 건 아닌데 연결된 것처럼. 
            라우터 경유할 때 특정 길이 다른 것들과 공유될 수 있음. 
            연결된 게 아님. 네트워크 자원 공유해서 사용. 
            네트워크 자원에 대한 효율성 증가. 하지만 네트워크 트래픽 많을 땐 성능 저하
 연결 : 독점해서 네트워크 자원 사용. 자원에 대한 효율성은 떨어지지만, 품질은 좋음. 
        전화기같은 경우 데이터 통신은 통화품질 떨어지는데 전화기는 품질 좋음)
 
 UDP/IP : 비연결지향
          신뢰성이 없음. 답장 안와도 다시 안 보냄
          빠르다. 멀티미디어 데이터 보낼때 좋음
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        //서버
        ServerSocket s = new ServerSocket(10000);
        Socket sock = s.accept();
        InputStream in = sock.getInputStream();

        int data=0;
        while((data = in.read())!=-1){
            System.out.write(data);
        }
        System.out.flush();//버퍼에 있는 거 다 보내
    }
}
