package simulation;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	boolean keepplaying = true;
	private double money = 500;
	private double bet;

	public Player(String n){

		name = n;
	}

	public void drawCards(){

		if(keepplaying == true){

			Random rnd = new Random();
			int randomnumber = rnd.nextInt(Game.deck.size()-1);
			hand.add(Game.deck.get(randomnumber));
			Game.deck.remove(randomnumber);
			getSum();
		}
	}

	public String getName(){

		return name;
	}

	public int getSum(){

		int sum = 0;

		for(int i = 0; i < hand.size(); i++){

			if(hand.get(i).getValue() != 1){

				sum += hand.get(i).getValue();
			}
			else{

				if(sum <= 10){

					sum += 11;
				}
				else{

					sum += 1;
				}
			}
		}

		if(sum >= 21){

			keepplaying = false;
		}	
		return sum;
	}
	
	public double getMoney(){
		
		return money;
	}
	
	public double setBet(int bet){
		
		this.bet = bet;
		return bet;
	}
	
	public double getBet(){
		return bet;
	}
	
	public void setMoneyAfter(int mult){
		
		money += bet*mult;
	}
}