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
    public void NewBook() {
        try{
		if(iBookLength>=MAX_BOOK_LENGTH) {
			System.out.println("Full!");
			return;
		}
		String tName, tAuthor;
		int tPage, tGenre;
		
		System.out.println("책 이름을 입력하세요: ");	
		tName = br.readLine();
		System.out.println("책 페이지수를 입력하세요: ");	
		tPage = Integer.valueOf(br.readLine());
		System.out.println("작가 이름을 입력하세요: ");	
		tAuthor = br.readLine();
		System.out.println("책의 장르를 선택하세요 - 1.소설 2.SF 3. essay");	
		tGenre = Integer.valueOf(br.readLine());
		
		
		for(int i=0; i<iBookLength; i++) {
			if(BookList[i].getName().equals(tName)) {
				System.out.println("이미 존재합니다.");
				return;
			}
		}
		
		Book book;
		switch(tGenre) {
			case 1:
				book = new Novel(tName, tAuthor, tPage);
				break;
			case 2:
				book = new SF(tName, tAuthor, tPage);
				break;
			case 3:
				book = new essay(tName, tAuthor, tPage);
				break;
			default:
				System.out.println("Error!");
				return;
		}
		
		BookList[iBookLength++] = book;
		} catch (IOException e) {
			System.out.println("IOException");
			return;
		}
    }
    public void DeleteBook() {
		if(iBookLength<1) {
			System.out.println("책이 하나도 없습니다.");
			return;
		}
		try {
		System.out.println("삭제하려는 책 제목을 입력하세요 : ");
		String target = br.readLine();
		for(int i=0; i<iBookLength; i++) {
			if(BookList[i].sName.equals(target)) {
				for(int j=i; j<iBookLength-1; j++) {
					BookList[j] = BookList[j+1];
				}
			}
		}
		iBookLength--;
		}catch (IOException e) {
			System.out.println("Error!");
		}
	}
    public void SearchBook() {
		try {
				boolean flag=false;
				System.out.println("찾으려는 책 제목을 입력하세요 : ");
				String target = br.readLine();
				for(int i=0; i<iBookLength; i++) {
					if(target.equals(BookList[i].sName)) {
						System.out.println("책을 찾았습니다. 책 정보입니다.");
						System.out.println("제 목 : "+BookList[i].sName);
						System.out.println("작 가 : "+BookList[i].sAuthor);
						System.out.println("페이지 : "+BookList[i].iPage);
						System.out.println("장 르 : "+BookList[i].sGenre);
						flag=true;
					}
				}
				if(!flag) System.out.println("찾지 못했습니다.");
			}catch (IOException e){
				System.out.println("Error!");
			}
	}
    public void PrintBook() {
		if(iBookLength<1) {
			System.out.println("책이 하나도 없습니다.");
			return;
		}
		for(int i=0; i<iBookLength; i++) {
			System.out.println((i+1)+"번 책 정보");
			System.out.println("제 목 : "+BookList[i].sName);
			System.out.println("작 가 : "+BookList[i].sAuthor);
			System.out.println("페이지 : "+BookList[i].iPage);
			System.out.println("장 르 : " +BookList[i].sGenre);
			System.out.println();
		}	
	}
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

class SF extends Book {

	public SF(String name, String author, int page) {
		super(name, author, page);
	}

	@Override
	void setGenre() {
		sGenre = "SF";
	}	
}

class essay extends Book {

	public essay(String name, String author, int page) {
		super(name, author, page);
	}

	@Override
	void setGenre() {
		sGenre = "essay";
	}	
}