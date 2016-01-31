package simulation;

public class Card {
	
	private int value;
	
	public Card(int w){
		
		if(w < 11){
			
			value = w;
		}
		else{
			
			value = 10;
		}
	}
	
	public int getValue(){
		
		return value;
	}
}