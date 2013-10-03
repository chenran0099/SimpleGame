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
		boolean status = true;
		int arr[] = {0,2,2,216,72,36,21,14,10,8,8,8,8,10,14,21,36,72,216};
		//object
		Scanner bucky = new Scanner(System.in);
		funcs funcObj = new funcs();
		
		//main
		funcObj.outStatus(money, play);
		System.out.println("Game instruction: Please check https://github.com/maomihz.\nLET'S PLAY.\n*********************\n");
		while(money > 0){
			System.out.printf("Money: $%d\n", money);
			do {
				System.out.print("Which number you bet>>");
				userIn = bucky.nextInt();
				System.out.print("How much you bet>>");
				moneyChange = bucky.nextInt();

				if (userIn <= 0 || userIn > 18 || moneyChange > money){
					System.out.println("input wrong, please retry.");
					continue;
				}
				if (userIn == 0) {
					System.out.println("Cheat enabled, money+++");
					money += moneyChange;
					System.out.printf("Money = %d", money);
				} else {
					money -= moneyChange/10 + 1;
					money -= moneyChange;
					System.out.printf("Money: $%d(-$%d).\n", money, moneyChange + moneyChange / 10 + 1);
					break;
				}
					
			} while (true);
			
			
			randomNum = funcObj.getRandom();
			if ((userIn == 1 && randomNum <= 10) || (userIn == 2 && randomNum > 10) || (userIn >= 3 && userIn <= 18 && userIn == randomNum)){
				moneyChange *= arr[userIn];
				money += moneyChange;
				win += moneyChange;
				funcObj.outChoice(userIn);
				status = true;
				System.out.printf("* You win, the number is %d\n", randomNum);
			} else {
				funcObj.outChoice(userIn);
				status = false;
				System.out.printf("* You lose, the number is %d\n", randomNum);
			}

			
			
			play++;
			funcObj.outStatus(money, play, status, moneyChange);
			System.out.print("\n\n\n*********************\n");
		}
		System.out.printf("GAME OVER\nYour score is: %d\n", win);
		
	}

}
