
public class Deck extends Pile {

	public Deck(int p) {
		super(p);
		
	}
	public void deal(Hand h,int deal)
	{
		for(int i=0;i<deal;i++)
		{
			Card c = this.removeFromTop();
			h.getHand().add(c);
		}
		
	}

}
