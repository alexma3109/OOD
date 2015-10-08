public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	private Suit(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
	public static String getSuit(int value){
		switch(value){
			case 0: return "Club";
			case 1: return "Diamond";
			case 2: return "Heart";
			case 3: return "Spade";
		}
	}
}

public abstract class Card {
	protected Suit suit;
	protected int faceValue;
	
	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	public Suit cardSuit(){
		return suit;
	}
	public int value(){
		return faceValue;
	};
}

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtCard = 0;
	
	public void shuffle(){};
	public int remainingCard(){
		return cards.size() - dealtCard;
	}
	public void setDealtCard(int num){
		dealtCard = num;
	}
}

public class hand<T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score(){
		int score = 0;
		for(T card : cards){
			score += card.value();
		}
		return score;
	}
	public void addCard(T card){
		cards.add(card);
	}
}

public class blackJackCard extends Card {
	public blackJackCard (int c, Suit s) {
		super(c, s);
	}
	public int value(){
		if(faceValue >= 11 && faceValue <= 13){
			return 10;
		}
		if(isAce()){
			return 11;
		}
		else{
			return faceValue;
		}
	}
	public int minValue(){
		if(faceValue == 1){
			return 1;
		}
		else{
			return faceValue;
		}
	}
	public int maxValue(){
		if(faceValue == 1){
			return 11;
		}
		else{
			return faceValue;
		}
	}
	public boolean isAce(){
		return faceValue == 1;
	}
}

public class blackJackCardHand extends Hand<blackJackCard>{
	public int score(){
		ArrayList<Integer> scores = getScores();
		int minOver = Integer.MAX_VALUE;
		int maxUnder = Integer.MIN_VALUE;
		for(int score : scores){
			if(score > 21 && score < minOver){
				minOver = score;
			}
			if(score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder != Integer.MIN_VALUE ? maxUnder : minOver;
	}
	private ArrayList<Integer> getScores(ArrayList<blackJackCard> cards){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int countAce = 0;
		int sum = 0;
		for(blackJackCard card : cards){
			if(card.isAce()){
				countAce++;
			}
			sum += blackJackCard.value();
		}
		res.add(sum);
		while(countAce > 0){
			sum = sum - 10;
			res.add(sum);
		}
		return res;
	}
	public boolean isBust(){
		returns score > 21;
	}
}