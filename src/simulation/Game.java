package simulation;

import java.util.ArrayList;

public class Game {

	static final int anzDecks = 6;
	static final int anzCards = 52;
	static final int anzColors = 4;
	static final int anzPlayers = 6; //Croupie wird nicht mitgezählt

	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Card> deck = new ArrayList<Card>();

	public static void main(String[] args) {

		fillDeck();
		addPlayers();
		gameCalc();
		showResult();
	}

	public static void fillDeck(){

		for(int i = 1; i <= (anzDecks * anzColors); i++){

			for(int j = 1; j <= (anzCards / anzColors); j++){

				deck.add(new Card(j));
			}
		}
	}

	public static void addPlayers(){

		for(int i = 0; i < anzPlayers; i++){

			players.add(new Player("Spieler "+ (i+1)));		
		}

		players.add(new Croupie("Croupie"));
	}

	public static void gameCalc(){

		for(int i = 0; i < anzPlayers; i++){

			players.get(i).drawCards();
			players.get(i).drawCards();
		}
		players.get(anzPlayers).drawCards();

		for(int i = 0; i < anzPlayers; i++){

			players.get(i).setBet(500);

			while(players.get(i).getSum() < 18){

				players.get(i).drawCards();
			}
		}

		while(players.get(anzPlayers).getSum() < 17){

			players.get(anzPlayers).drawCards();
		}
	}

	public static void showResult(){

		System.out.println("==================================================================");
		for(int i = 0; i < anzPlayers; i++){

			if(players.get(anzPlayers).getSum() <= 21){

				if((players.get(i).getSum() > players.get(anzPlayers).getSum() && players.get(i).getSum() <= 21)){

					System.out.println(players.get(i).getName() + " hat mit einer Summe von "+ players.get(i).getSum() + " gewonnen!");
					players.get(i).setMoneyAfter(1);
					System.out.println("Der Spieler hat nun eine Kontostand von: "+ players.get(i).getMoney());
				}

				if((players.get(i).getSum() == players.get(anzPlayers).getSum() && players.get(i).getSum() <= 21)){

					System.out.println(players.get(i).getName() + " hat mit einer Summe von " + players.get(i).getSum() +" ein unentschieden erreicht");
					players.get(i).setMoneyAfter(0);
					System.out.println("Der Spieler hat nun eine Kontostand von: "+ players.get(i).getMoney());
				}

				if((players.get(i).getSum() < players.get(anzPlayers).getSum() || players.get(i).getSum() > 21)){

					System.out.println(players.get(i).getName() + " hat mit einer Summe von " + players.get(i).getSum() + " leider verloren!");
					players.get(i).setMoneyAfter(-1);
					System.out.println("Der Spieler hat nun eine Kontostand von: "+ players.get(i).getMoney());
				}
			}

			else{

				if(players.get(i).getSum() <= 21){

					System.out.println(players.get(i).getName() + " hat mit einer Summe von "+ players.get(i).getSum() + " gewonnen!");
					players.get(i).setMoneyAfter(1);
					System.out.println("Der Spieler hat nun eine Kontostand von: "+ players.get(i).getMoney());
				}


				if((players.get(i).getSum() > 21)){

					System.out.println(players.get(i).getName() + " hat mit einer Summe von " + players.get(i).getSum() + " leider verloren!");
					players.get(i).setMoneyAfter(-1);
					System.out.println("Der Spieler hat nun eine Kontostand von: "+ players.get(i).getMoney());
				}
			}
		}
		System.out.println("Der Croupie hat eine Summe von " + players.get(anzPlayers).getSum() + " erreicht");
		System.out.println("==================================================================");	
	}
}
