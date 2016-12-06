package enemys;

public class Pit extends Enemy{

	public Pit(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWarning() {
		System.out.print("You can smell the water from a pit...\n> ");	
		
	}

}
