/*
 * Card class represent a single card.
 */
public class Card {
	private String _face;
	private String _suit;
	
	public Card(String face, String suit){
		_face = face;
		_suit = suit;
	}
	
	
	public String toString() {
		return _face + " of " + _suit;  
	}
	
	// compare this card with another card
	public int compareTo(Card card) {
		if(this.getCardValue() == card.getCardValue()) {
			return 0;
		}
		return this.getCardValue() > card.getCardValue()? 1 : -1;
	}
	
	// return card value by card face
    private int getCardValue() {

        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
     
        for(int i=0;i<faces.length;i++) {
            if(_face.equals(faces[i]))
                return i+1;
        }
        return 0;
    }
}
