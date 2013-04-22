
public class Card 
{

	private String suit;
	private String type;
	private int val=0;
	private Card next,previous;
	
	public Card(String suit, String type,int val)
	{
		this.suit=suit;
		this.type=type;
		this.val=val;
	}
	
	public String toString()
	{
		return new String("The card is a(n) "+this.type+" of "+this.suit);
	}
	
	public String getSuit(){return suit;}
	public String getType(){return type;}
	public void setNext(Card c){this.next=c;}
	public void setPrev(Card c){this.previous=c;}
	public Card getNext(){return this.next;}
	public Card getPrev(){return this.previous;}
	public int getVal(){return this.val;}
	
	
	
	
}
