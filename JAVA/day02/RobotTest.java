package day02;

class Battery {
    int bat=0;
    static int width;
    static int height;
    void chargebat(int n) {
        bat+=n;
        System.out.println("배터리가 "+n+"만큼 충전되었습니다.");
    }

    void usebat(int n) {
        bat-=n;
        System.out.println("배터리가 "+n+"만큼 소모되었습니다.");
    }

    static void printbat() {
        System.out.println("width : "+ width +", height : "+height);
    }
}

class Robot2 {
    String botName;
    int botEnergy=0;
    Battery botbat = new Battery();
    
    static int moveEnergy = 2;
    static int runEnergy = 5;

    void move(int n) {
        System.out.println("로봇이 "+n+"만큼 움직입니다.");
        botbat.usebat(n*moveEnergy);
    }

    void run(int n) {
        System.out.println("로봇이 "+n+"만큼 뜁니다.");
        botbat.usebat(n*runEnergy);
    }

    void printbat() {
        System.out.println("배터리가 "+(botEnergy+botbat.bat)+" 남았습니다.");
    }
}

public class RobotTest {
    public static void main(String[] args) {
        Battery bat1 = new Battery();
        bat1.chargebat(200);
        Robot2 bot1 = new Robot2();
        bot1.botEnergy=bat1.bat;
        bot1.run(2);
        bot1.move(5);
        bot1.printbat();
    }
    
}