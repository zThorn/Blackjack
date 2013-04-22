import java.util.ArrayList;


public class Hand extends Pile {
	public Hand(int p) {
		super(p);
		
	}
	
	public void displayHand()
	{		
		for(int i=0;i<this.getHand().size();i++)
			System.out.println(" "+this.getHand().get(i).getType()+" of "+this.getHand().get(i).getSuit());
	}

	public void displayOpponentHand()
	{
		for(int i=1;i<this.getHand().size();i++)
			System.out.println(" "+this.getHand().get(i).getType()+" of "+this.getHand().get(i).getSuit());

	}
	
	public int findCard(String t)
	{
		int total=0;
		for(int i=0;i<numberOfCards;i++)
			if(getHand().get(i).getType().toLowerCase()==t.toLowerCase())
				total++;
		return total;
	}
	
	public ArrayList<Card> getHand(){return hand;}
	private  ArrayList<Card> hand = new ArrayList<Card>(2);

}
