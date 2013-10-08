/**
 * This class is designed for a single player's property.
 * 
 * @author MaomiHz
 * 
 */
public class Player {
	//variable
	private int money;
	private String name;
	private int choice;
	private int betMoney;
	private int score;
	private boolean exist = true;
	
	//constructor
	Player(String name) {
		money = 1000;  //Initialize money($1000)
		this.name = name;
	}
	
	//function related to money
	public void addMoney(int x){
		money += x;
		score += x;
	}
	public void reduceMoney(int x){
		money -= x;
	}
	
	//Setters
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public void setBetMoney(int money){
		this.betMoney = money;
	}
	public void out() {
		exist = false;
	}
	
	//Getters
	public int getChoice(){
		return choice;
	}
	public boolean exists() {
		return exist;
	}
	
	public int getBetMoney() {
		return betMoney;
	}
	public int getMoney() {
		return money;
	}
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	
}
