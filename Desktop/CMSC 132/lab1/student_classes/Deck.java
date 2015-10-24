package student_classes;

import java.util.*;

public class Deck implements Iterable<Card>, Comparator<Card>{
	
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	
	public Deck(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 13; j++){
				Card card = new Card(Suits.values()[i], Numerals.values()[j]);
				this.deckOfCards.add(card);
			}
		}
	}
	
	public Deck(Deck otherDeck){
		
		for ( Card i : otherDeck){
			deckOfCards.add(new Card(i));
		}
	}

	@Override
	public Iterator<Card> iterator() {
		Iterator<Card> iterator = deckOfCards.iterator();
		return iterator;
	}

	@Override
	public int compare(Card card1, Card card2) {
		if (card1.get_suit().compareTo(card2.get_suit()) < 0){
			return -1;
		}
		else if (card1.get_suit().compareTo(card2.get_suit()) > 0){
			return 1;
		}
		else {
			return card1.compareTo(card2);
		}
	}
	
	public int size(){
		return deckOfCards.size();
	}
	
	public void shuffle(){
		Collections.shuffle(deckOfCards);
	}

	public void sort(){
		Comparator<Card> c = this;
		Collections.sort(deckOfCards, c);
	}

	public String toString(){
		return deckOfCards.toString();
	}

	public boolean equals(Deck otherDeck){
		
		boolean equal = true;
		
		if (otherDeck == null){
			equal = false;
		}
		else if (otherDeck.getClass() != this.getClass()){
			equal = false;
		}
		
		else if (this == otherDeck){
			return true;
		}
		
		else{
		Iterator<Card> iter = this.iterator();
		Iterator<Card> otherIter = otherDeck.iterator();

			while (iter.hasNext() && otherIter.hasNext()){
				Card card1 = iter.next();
				Card card2 = otherIter.next();
				if (!(card1.compareTo(card2) == 0) || !(card1.get_suit().equals(card2.get_suit()))){
					equal = false;
				}
		
			}
		}
		return equal;
	}

}
