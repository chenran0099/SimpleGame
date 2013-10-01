
public class funcs {

	
	public static int getRandom() {
		int result = 0;
		for(int i = 0; i<3;i++){
			result += (int)Math.floor(Math.random() * 6 + 1);
		}
		return result;
	}
	
	public static void outStatus(int money, int play){
		System.out.println("Money: " + money);
		System.out.println("Total play: " + play);
	}
	
	
	public static void outChoice(int choice){
		if (choice == 1)
			System.out.println("* Your choice is small.");
		if (choice == 2)
			System.out.println("* Your choice is large.");
	}
}
