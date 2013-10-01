import java.util.Scanner;
public class startgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variable
		
		int money = 1000;
		int play = 0;
		int userIn;
		int randomNum;
		int moneyChange = 100;
		int win = 0;
		int lose = 0;
		//object
		Scanner bucky = new Scanner(System.in);
		funcs funcObj = new funcs();
		
		//main
		funcObj.outStatus(money, play);
		System.out.println("Game instruction: \nPlease enter number 0 or 1, 0 for small and 1 for large.\nLET'S PLAY.\n*********************\n");
		while(money > 0){
			money -= 50;
			System.out.println("Money-50\nMoney: " + money);
			do {
				System.out.print(">> ");
				userIn = bucky.nextInt();
				if (userIn != 1 && userIn != 2 && userIn != 0)
					System.out.println("input wrong, please retry.");
				if (userIn == 0) {
					System.out.println("Cheat enabled, money+200,,,");
					money += 200;
					System.out.println("Money = " + money);
				}
					
			} while (userIn != 1 && userIn != 2);
			
			
			randomNum = funcObj.getRandom();
			if ((userIn == 1 && randomNum <= 10) || (userIn == 2 && randomNum > 10)){
				money += moneyChange;
				funcObj.outChoice(userIn);
				System.out.println("You win, the number is " + randomNum + "\nMoney+" + moneyChange);
				win++;
			} else {
				funcObj.outChoice(userIn);
				money -= moneyChange;
				System.out.println("You lose, the number is " + randomNum + "\nMoney-" + moneyChange);
				lose++;
			}
			System.out.println("*********************");
			
			
			play++;
			funcObj.outStatus(money, play);
			System.out.println("\n\n");
		}
		System.out.println("GAME OVER\nYour score is: " + play + "\nLose times: " + lose + "\nWin times: " + win);
		
	}

}
