package student_classes;

public class Card implements Comparable<Card>{
	
	private Suits suit;
	private Numerals numeral;
	
	public Card(Suits aSuit, Numerals aNumeral){
		this.suit = aSuit;
		this.numeral = aNumeral;
	}
	
	public Card(Card aCard){
		this.suit = aCard.get_suit();
		this.numeral = aCard.get_numeral();
	}
	
	public Suits get_suit(){
		return this.suit;
	}
	
	public Numerals get_numeral(){
		return this.numeral;
	}
	
	public String toString(){
		return numeral + " of " + suit;
	}
	
	public int compareTo(Card otherCard){
		
		return this.get_numeral().compareTo(otherCard.get_numeral());
		
	}
	
	
	public boolean equals(Card other){
		if (other == null){
			return false;
		}
		
		else if (this == other){
			return true;
		}
		
		else if (this.getClass() != other.getClass()){
			return false;
		}
		
		else if (this.numeral == ((Card) other).get_numeral()){
			return true;
		}
		
		else {
			return false;
		}
		
	}

}
