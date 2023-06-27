package day11;

import java.io.*;

public class BookPjt {
    private final int MAX_BOOK_LENGTH = 10;
	Book [] BookList = new Book[MAX_BOOK_LENGTH];	// 책 리스트가 저장되는 배열입니다.
	int iBookLength = 0;	// 저장된 책의 갯수입니다.
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		System.out.println("=====Library Program Start=====");
		BookPjt libraryProg = new BookPjt();
		libraryProg.Run();
	}
	
	public void Run() {
						
		while(true) {
			
			int input = -1;
			
			System.out.println();
			System.out.println("-----------------------");
			System.out.println("1. new Book");
			System.out.println("2. delete Book");
			System.out.println("3. search Book");
			System.out.println("4. print Book");
			System.out.println("0. Quit");
			System.out.print("Input : ");
			
			try {
				input = Integer.valueOf(br.readLine());
			} catch (Exception e) {
				System.out.println("ERROR!!");
				continue;
			}
			
			switch(input) {
			case 1:
				NewBook();
				break;
			case 2:
				DeleteBook();
				break;
			case 3:
				SearchBook();
				break;
			case 4:
				PrintBook();
				break;
			case 0:
				System.out.println("Bye");
				return;
			default:
				System.out.println("[ERROR] Invalid Input");
			}
		}
    }
    public void NewBook() {}
    public void DeleteBook() {}
    public void SearchBook() {}
    public void PrintBook() {}
}


abstract class Book {
	
	protected String sName;
	protected String sAuthor;
	protected int iPage;
	protected String sGenre;
	
	public Book(String name, String author, int page) {
		sName = name;
		sAuthor = author;
		iPage = page;
		setGenre();
	}
	
	public String getName() {
		return sName;
	}
	
	public String getAuthor() {
		return sAuthor;		
	}
	
	public int getPage() {
		return iPage;
	}	
	
	abstract void setGenre();
	
	public String getGenre() {
		return sGenre;
	}
}

class Novel extends Book {

	public Novel(String name, String author, int page) {
		super(name, author, page);
	}

	@Override
	void setGenre() {
		sGenre = "Novel";
	}	
}