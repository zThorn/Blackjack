import java.util.Scanner;

public class Game{

	private static Player computer,player;
	private static Hand compHand,playerHand;
	private static Deck mainDeck;
	
	
	public static void main(String[] args)
	{
		initialize();
		play();
	}
	
	public static void initialize()
	{
		mainDeck = new Deck(52);
		mainDeck.shuffleDeck();
		
		compHand = new Hand(2);
		playerHand = new Hand(2);
		
		mainDeck.deal(compHand,2);
		mainDeck.deal(playerHand,2);
		
		computer = new Player("Bill",compHand);
		player = new Player("Player", playerHand);
	}
	
	public static void play()
	{
		boolean playerTurn=true;
		Scanner in = new Scanner(System.in);
		String playerMove="";

			System.out.println("Your hand:");
			playerHand.displayHand();
			System.out.println("Your current score: "+player.calculateScore());
			System.out.println("Your opponents showing: ");
			compHand.displayOpponentHand();
			
			while(playerTurn && player.calculateScore()<=21)
			{
				System.out.println("Press h to hit or s to stay");
				playerMove=in.nextLine();
				if(playerMove.toLowerCase().equals("h"))
				{
					mainDeck.deal(playerHand,1);
					System.out.println("Your hand:");
					playerHand.displayHand();
					System.out.println("Your current score: "+player.calculateScore());
				}
				else if(playerMove.toLowerCase().equals("s"))
					playerTurn=false;

			}
			
			
			computeMoves();
			int compScore = computer.calculateScore();
			int playerScore = player.calculateScore();
			
			System.out.println(playerScore);
			System.out.println(compScore);
			
		if((playerScore<=21 && compScore>=playerScore && compScore<=21) || (playerScore>21 && compScore<21))
			System.out.println("Computer won with "+compScore+" You had "+playerScore);
		else if(playerScore<=21 || compScore>21)
			System.out.println("You won with "+playerScore+" Computer had "+compScore);
		
	}
	
	public static void computeMoves()
	{
		while(computer.calculateScore()<17)
			mainDeck.deal(compHand,1);
	}
	}
