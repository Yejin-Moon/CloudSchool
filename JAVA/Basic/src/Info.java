public class Info {
    // 필드
    String name;
    String email;
    int age;

    // 생성자
    Info(String name, String email, int age) {
        this.name=name;
        this.email=email;
        this.age=age;
    }

    // 메서드
    public void printInfo() {
        System.out.println("name : "+name);
        System.out.println("email : "+email);
        System.out.println("age : "+age);
    }
}
