import java.util.Scanner;
public class startgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variable
		
		int money = 1000;
		int play = 0;
		int userIn;
		int randomNum;
		int moneyChange;
		int win = 0;
		
		int arr[] = {0,2,2,216,72,36,21,14,10,8,8,8,8,10,14,21,36,72,216};
		//object
		Scanner bucky = new Scanner(System.in);
		funcs funcObj = new funcs();
		
		//main
		funcObj.outStatus(money, play);
		System.out.println("Game instruction: Please check https://github.com/maomihz.\nLET'S PLAY.\n*********************\n");
		while(money > 50){
			money -= 50;
			System.out.println("Money-50\nMoney: $" + money);
			do {
				System.out.print("Which number you bet>> ");
				userIn = bucky.nextInt();
				System.out.print("How much you bet>>");
				moneyChange = bucky.nextInt();
				if (userIn <= 0 || userIn > 18 || moneyChange > money)
					System.out.println("input wrong, please retry.");
				if (userIn == 0) {
					System.out.println("Cheat enabled, money+++");
					money += moneyChange;
					System.out.println("Money = " + money);
				}
					
			} while (userIn <= 0 || userIn > 18 || moneyChange > money);
			
			money -= moneyChange;
			randomNum = funcObj.getRandom();
			if ((userIn == 1 && randomNum <= 10) || (userIn == 2 && randomNum > 10) || (userIn >= 3 && userIn <= 18 && userIn == randomNum)){
				money += moneyChange * arr[userIn];
				win += moneyChange * arr[userIn];
				funcObj.outChoice(userIn);
				System.out.println("* You win, the number is " + randomNum + "\nMoney+$" + moneyChange * arr[userIn]);
			} else {
				funcObj.outChoice(userIn);
				System.out.println("* You lose, the number is " + randomNum);
			}

			
			
			play++;
			funcObj.outStatus(money, play);
			System.out.println("\n\n");
			System.out.println("*********************");
		}
		System.out.println("GAME OVER\nYour score is: " + win);
		
	}

}
