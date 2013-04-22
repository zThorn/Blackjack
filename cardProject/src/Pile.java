import java.util.Random;


public class Pile 
{
	private Card[] pile;
	private Card topCard;
	private Card bottomCard;
	protected int numberOfCards;
	
	
	
	
	
	public Pile(int p)
	{
		this.numberOfCards=p;
		pile = new Card[numberOfCards];
	}
	
	public void shuffleDeck()
	{
		Random rand = new Random();
		int s,t,val=0;
		String suit="",type="";
		for(int i=0;i<numberOfCards;i++)
		{
			s=rand.nextInt(4);
			t=rand.nextInt(13);
			
			switch(s)
			{
				case 0:
					suit="Spades";
				break;
				
				case 1:
					suit="Hearts";
				break;
				
				case 2:
					suit="Diamonds";
				break;
				
				case 3:
					suit="Clubs";
				break;
				
			}
			
			switch(t)
			{
				case 0:
					type="Ace";
					val=11;
					break;
				case 1:
					type="Two";
					val=2;
					break;
				case 2:
					type="Three";
					val=3;
					break;
				case 3:
					type="Four";
					val=4;
					break;
				case 4:
					type="Five";
					val=5;
					break;
				case 5:
					type="Six";
					val=6;
					break;
				case 6:
					type = "Seven";
					val=7;
					break;
				case 7:
					type = "Eight";
					val=8;
					break;
				case 8:
					type = "Nine";
					val=9;
					break;
				case 9:
					type = "Ten";
					val=10;
					break;
				case 10:
					type = "Jack";
					val=10;
					break;
				case 11:
					type = "Queen";
					val=10;
					break;
				case 12:
					type = "King";
					val=10;
					break;
			}
			
				pile[i]=new Card(suit,type,val);
				
		}
		
		for(int i=0;i<numberOfCards;i++)
		{
			if(i==0)
			{
				pile[i].setNext(pile[i+1]);
				pile[i].setPrev(null);
			}
			else if(i==numberOfCards-1)
			{
				pile[i].setPrev(pile[i-1]);
				pile[i].setNext(null);
			}
			else
			{
				pile[i].setPrev(pile[i-1]);
				pile[i].setNext(pile[i+1]);
			}
		}
			
	}

	public boolean findCard(String t,String s)
	{
		for(int i=0;i<numberOfCards;i++)
			if(pile[i].getType().toLowerCase()==t.toLowerCase() && pile[i].getSuit().toLowerCase()==s.toLowerCase())
				return true;
		return false;
		
	}
	

	
	public Card removeFromTop()
	{
		numberOfCards--;
		Card c;
		c=pile[numberOfCards-1];
		c.getPrev().setNext(null);
		pile[numberOfCards-1]=null;
		return c;
	}
	
	public Card removeFromBottom()
	{
		numberOfCards--;
		Card c;
		c=pile[0];
		pile[1].setPrev(null);
		pile[0]=null;
		return c;
	}
	
	public void addToTop(Card c)
	{
			numberOfCards++;
			Card[] tempPile = new Card[numberOfCards];
			System.arraycopy(pile, 0, tempPile, 0, pile.length);
			tempPile[numberOfCards-1]=c;
			c.setPrev(pile[numberOfCards-2]);
			System.out.println(pile.length);
			tempPile[numberOfCards-1].setNext(c);
			c.setNext(null);
			pile=tempPile;
	}
	
	public void addToBottom(Card c)
	{
			numberOfCards++;
			Card[] tempPile = new Card[numberOfCards];
			tempPile[0]=c;
			System.arraycopy(pile, 0, tempPile, 1, numberOfCards);
			c.setPrev(null);
			c.setNext(tempPile[1]);
			pile[1].setPrev(c);
			pile=tempPile;
	}
	
	public Card[] getPile(){return pile;}
	
}
