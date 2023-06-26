package day10;

public class OverridingEx {
//overriding은 부모 클래스의 멤버를 자식 클래스에서 재정의하여 사용하는 것.
	public static void main(String[] args) {
		Soccer soccer = new Soccer();
		Tennis tennis = new Tennis();
		
		soccer.setSportsName();
		tennis.setSportsName();
		
		soccer.printSportsName();
		tennis.printSportsName();
	}

}

class Sports {
	protected String SportsName;
	
	public void setSportsName() {
		SportsName = "Sports";
	}
	
	public void printSportsName() {
		System.out.println(SportsName);
	}
}

class Soccer extends Sports {
	public void setSportsName() {
		SportsName = "Soccer";//재정의
	}	
}

class Tennis extends Sports {
	public void setSportsName() {
		SportsName = "Tennis";//재정의
	}
}

