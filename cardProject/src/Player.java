
public class Player {
	private String name;
	private Hand hand;
	private int score=0;
	
	public Player(String n, Hand h)
	{
		this.name=n;
		this.hand=h;
	}
	
	public int calculateScore()
	{
		score=0;
		for(int i=0;i<this.hand.getHand().size();i++)
			this.score+=this.hand.getHand().get(i).getVal();
		if(score>21)
		{
				for(int i=0;i<this.hand.findCard("Ace");i++)
					this.score-=10;
		}
		return this.score;
		
	}
}
