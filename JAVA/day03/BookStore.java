package day03;

class Book {
    int id;
    String title;
    int price;

    Book(int id, String title, int price){
        this.id=id;
        this.title=title;
        this.price=price;
    }

    void printInfo() {
        System.out.println("책 이름 : "+title);
        System.out.println("가격 : "+price);
    }
}

public class BookStore {
    static Book[] items = new Book[5];

    static void search(String title) {
        for(int i=0; i<5; i++){
            if(items[i].title.equals(title)){
                System.out.println("책 가격은 "+items[i].price);
            }
        }
    }
    public static void main(String[] args) {
        items[0] = new Book(0, "위대하고 위험한 약 이야기", 10000);
	    items[1] = new Book(1, "마을버스, 세계를 가다 ", 20000);
	    items[2] = new Book(2, "어른아이로 산다는 것", 30000);
	    items[3] = new Book(3, "진짜 공신들만 아는 체대 입시 ", 40000);
	    items[4] = new Book(4, "그림자 극장 2", 50000);

	search("그림자 극장 2");
    }
}
