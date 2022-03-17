import java.security.SecureRandom;
import java.util.ArrayList;

/*
 * DeckOfCards call represent a deck of valid cards, and functions
 * that user can operate on the deck.
 */
public class DeckOfCards {
	private ArrayList<Card> _deck;
    private static final int NUMBER_OF_CARDS = 52;
    private static final int UNIQE_FACES = 13;
    private static final SecureRandom _randomNumbers = new SecureRandom();
    
    // clearDeck if an empty deck is needed.
    public DeckOfCards(boolean clearDeck) {
    	_deck = new ArrayList<Card>();
    	
    	if(!clearDeck)
    	{
    		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six","Seven",
           		 "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
            String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

            // populate deck with Card objects
            for (int count = 0; count < NUMBER_OF_CARDS; count++)
                _deck.add( new Card(faces[count % UNIQE_FACES], suits[count / UNIQE_FACES]));
    	}
    }
    
    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // for each Card, pick another random Card (0-51) and swap them
        for(int first = 0; first < _deck.size(); first++) {
            // select a random number between 0 and 51
            int second = _randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
            Card temp = _deck.get(first);
            _deck.set(first,_deck.get(second));
            _deck.set(second,temp);
        }
    }
    
    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (!_deck.isEmpty())
            return _deck.remove(0); // return the top card in array
        return null; // return null to indicate that all Cards were dealt
    }
    
    // return deck size
    public int SizeOfDeck () {
        return _deck.size();
    }
    
    // add single card to deck
    public void AddCard(Card card) {
    	_deck.add(card);
    }
    
    // add deck to this deck
    public void addDeck(DeckOfCards deck) {
        while (!deck.isEmpty())
            _deck.add(deck.dealCard());
    }
    
    // return if deck is empty
    public boolean isEmpty () {
        return _deck.isEmpty();
    }
}
