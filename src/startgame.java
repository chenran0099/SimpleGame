import java.util.Scanner;
public class startgame {

	public static void main(String[] args) {
		
		Scanner bucky = new Scanner(System.in);  // Scanner used for getting user input
		Function func = new Function();  // Build-in Function class's object
		
		// Get player number
		System.out.print("How many player? ==> ");  
		int playerNumber = bucky.nextInt();
		
		// create player array
		Player[] playerList = new Player[playerNumber];
		
		// set name for each player
		for(int i=0;i<playerList.length;i++){
			System.out.printf("Please enter <Player %d> name ==> ", i+1);
			String name = bucky.nextLine();
			if (i == 0){
				name = bucky.nextLine();
			}
			playerList[i] = new Player(name);
		}
		System.out.println("\n\n********************\n\n");
		
		boolean continuePlay = true;
		while (continuePlay){
			for (Player x:playerList) {
				if(x.getMoney() > 0)
					continuePlay = true;
				else
					continuePlay = false;
			}
			func.play(playerList);
			System.out.println();
			func.judge(playerList);
			System.out.println();
		}
		System.out.println("===Game Over===");
		func.score(playerList);
		
	}

}
