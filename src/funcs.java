
public class funcs {


	public static int getRandom() {
		int result = 0;
		for(int i = 0; i<3;i++){
			result += (int)Math.floor(Math.random() * 6 + 1);
		}
		return result;
	}
	
	public static void outStatus(int money, int play){
		System.out.printf("Present Money: $%d.\n", money);
		System.out.printf("Total play: %d\n", play);
	}
	// true for plus and false for minus;
	public static void outStatus(int money, int play, boolean b, int moneyChange){
		if (b)
			System.out.printf("Present Money: $%d(+$%d).\n", money, moneyChange);
		else 
			System.out.printf("Present Money: $%d\n", money);
			System.out.printf("Total play: %d\n", play);
	}
	
	
	public static void outChoice(int choice){
		if (choice == 1)
			System.out.println("* Your choice is 3~10.");
		if (choice == 2)
			System.out.println("* Your choice is 11~18.");
		if (choice >= 3 && choice <= 18)
			System.out.printf("* Your choice is %d. \n", choice);
	}
	
	
}
