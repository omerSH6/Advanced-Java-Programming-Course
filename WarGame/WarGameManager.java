import javax.swing.JOptionPane;
/*
 * WarGameManager class contains static functions
 *  that manage the activity of the war game.
 */
public class WarGameManager {
	
	// the entry point to the game.
	public static void startGame()
	{
		String message = new String();
		DeckOfCards fullDeck = new DeckOfCards(false);
		
		//the two components deck's
		DeckOfCards deckA = new DeckOfCards(true);
		DeckOfCards deckB = new DeckOfCards(true);
		
		DealCards(fullDeck, deckA, deckB);
		
		//the game will end only if one of the components decks is empty.
		while(!deckA.isEmpty() && !deckB.isEmpty()){
			GameRound(deckA, deckB,  new DeckOfCards(true));
		}
		
		
		//the winner of the game message
		message += deckA.isEmpty()? "Player B":"Player A";
		message += "Had Won the Game!!";
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	private static void GameRound(DeckOfCards deckA, DeckOfCards deckB, DeckOfCards roundDeck) {
		String message = new String();
		
		// an end case scenario, in case on of the decks got empty while recursive call in war.
		if(deckA.isEmpty() || deckB.isEmpty()) {
			return;
		}
		
		Card cardA = deckA.dealCard();
		Card cardB = deckB.dealCard();
		
		 message += "Player A Card is: " + cardA + " current deck size is: " + deckA.SizeOfDeck()+"\n";
		 message += "Player B Card is: " + cardB + " current deck size is: " + deckB.SizeOfDeck()+"\n";
		
		roundDeck.AddCard(cardA);
		roundDeck.AddCard(cardB);
		
		// comparing the components cards
		switch(cardA.compareTo(cardB)) {
		case 0:
			message+="Cards are equal! War Started!\n";
			roundDeck.AddCard(deckA.dealCard());
			roundDeck.AddCard(deckB.dealCard());
			roundDeck.AddCard(deckA.dealCard());
			roundDeck.AddCard(deckB.dealCard());
			message+=roundDeck.SizeOfDeck()+" cards on board\n";
			JOptionPane.showMessageDialog(null, message);
			//recursive call to GameRound
			GameRound(deckA, deckB, roundDeck);
		break;
		
		case 1:
			deckA.addDeck(roundDeck);
			message+= "\nPlayer A has Won the round!\n";
			 JOptionPane.showMessageDialog(null, message);
		break;
		
		case -1:
			deckB.addDeck(roundDeck);
			message+= "\nPlayer B has Won the round!\n";
			 JOptionPane.showMessageDialog(null, message);
		break;
	}
}
	
	// Divide mainDeck cards equally between deckA and deckB
		private static void DealCards(DeckOfCards mainDeck, DeckOfCards deckA ,DeckOfCards deckB ) {
			int evenFlag = 0;
			
			while(!mainDeck.isEmpty()) {
				if(evenFlag % 2 == 0) {
					deckA.AddCard(mainDeck.dealCard());
				}else {
					deckB.AddCard(mainDeck.dealCard());
				}
				
				evenFlag++;
			}
		}
}
