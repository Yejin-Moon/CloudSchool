package day03;

class Product {
    int id;
    String title;
    int price;

    Product(int id, String title, int price){
        this.id = id;
        this.title=title;
        this.price=price;
    }
}

class Book extends Product {
    String authorName;

    Book(int id, String title, int price, String authorName){
        super(id,title,price);
        this.authorName=authorName;
    }
}

class DVD extends Product {
    DVD(int id, String title, int price) {
        super(id,title,price);
    }
}

public class ProductStore {
    static Product [] items = new Product[5];

    static void search(String title){
        for(int i=0; i<5; i++){
            if(items[i].title.equals(title)){
                if(items[i] instanceof Book){//찾은 물건이 책이라면 저자 이름도 출력
                    Book obj = (Book)items[i];
                    System.out.println("저자는 : "+obj.authorName);
                }
                System.out.println("가격은 : "+items[i].price);
                break;
            }
            if(i==4) System.out.println("없습니다.");
        }       
    }
    public static void main(String[] args) {
        items[0] = new Book(0, "위대하고 위험한 약 이야기",10000, "송경옥"); 
        items[1] = new Book(1, "마을버스, 세계를 가다",20000, "지민석"); 
        items[2] = new DVD(2, "분노의질주",15000  ); 
        items[3] = new Book(3, "공신",40000, "김범수"); 
        items[4] = new DVD(4, "택시운전사 2",25000);  

        search("마을버스, 세계를 가다");
        search("분노의질주");
    }
}
