import java.util.Random;
import java.util.Scanner;
/**
 * This class is for some specific functions
 * @author MaomiHz
 *
 */
public class Function {
	private Random ran = new Random();  //random number generator
	private Scanner bucky = new Scanner(System.in);  // There is a story behind the name "bucky"...
	
	// dice (private method)
	private int dice(int x) { 
		int total = 0;	
		for (int i=0;i<x;i++){
			total += (ran.nextInt(6) + 1);	//Generate 1~6 random number
		}
		return total;
	}
	// error (private method)
	private void errorMsg() {
		System.out.println("Something wrong, please retry.");  // error message
	}
	
	// play
	public void play(Player[] l) {
		for (int i=0;i<l.length;i++){
			if (l[i].exists()){	//if you are out...
				do {
					// get user input
					System.out.printf("<%s> which number? ==> ", l[i].getName());
					int choice = bucky.nextInt(); 
					if (choice < 0 || choice > 18){
						errorMsg(); 
						continue;  
					} else {
						System.out.printf("<%s> how much? ==> ", l[i].getName());
						int bet = bucky.nextInt();
						
						// cheat code
						if (choice == 0){  
							l[i].addMoney(choice);
							System.out.printf("Cheat enabled, money +$%d\n", bet);
							continue; 
							
						// money not enough
						} else if (bet > l[i].getMoney()) {
							errorMsg(); 
							continue;  
						} else {
							l[i].setChoice(choice);
							l[i].setBetMoney(bet);
							l[i].reduceMoney(bet + bet / 10 + 1);
							System.out.printf("<%s> money: $%d(-$%d)\n", l[i].getName(), l[i].getMoney(), bet + bet / 10 + 1);
							break; // end while loop
						}
					}
				
				} while (true);
			} else {
				System.out.printf("<%s> you are out.\n", l[i].getName());
			}
		}
		
	}
	
	// judge
	public void judge(Player[] l) {
		int diceNum = dice(3);
		int[] reward = {0,2,2,216,72,36,21,14,10,9,8,8,9,10,14,21,36,72,216};
		for (int i=0;i<l.length;i++){
			if (l[i].exists()){  // if you are out...
				int choice = l[i].getChoice();
				int bet = l[i].getBetMoney();
				if ((choice == 1 && diceNum >= 3 && diceNum <= 10) || (choice == 2 && diceNum >= 11 && diceNum <= 18) || (choice == diceNum)){
					l[i].addMoney(bet * reward[choice]);
					System.out.printf("<%s> Win. The number is %d (%s) \n", l[i].getName(), diceNum, choice==1?"3~10":choice==2?"11~18":String.format("%s", choice));
					System.out.printf("<%s> Present money: $%d(+$%d).\n", l[i].getName(), l[i].getMoney(), bet * reward[choice]);
				} else {
					System.out.printf("<%s> Lose. The number is %d (%s) \n", l[i].getName(), diceNum, choice==1?"3~10":choice==2?"11~18":String.format("%s", choice));
					System.out.printf("<%s> Present money: $%d\n",  l[i].getName(), l[i].getMoney());
					if (l[i].getMoney() < 0){
						l[i].out();
					}
				}
			} else {
				System.out.printf("<%s> is out.\n", l[i].getName());
			}
		}
	}
	
	// total score of a player
	public void score(Player[] l) {
		for (int i=0;i<l.length;i++){
			System.out.printf("<%s> Score: %d\n", l[i].getName(), l[i].getScore());
		}
	}
	
}
