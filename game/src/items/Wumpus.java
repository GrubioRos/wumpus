package items;

public class Wumpus extends Item{
	

	public Wumpus(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWarning() {
		System.out.print("You can smell the wumpus...\n> ");	
	}

}
