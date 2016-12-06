package items;

public class Pit extends Item{

	public Pit(int x, int y) {
		super(x, y);
		this.killer = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWarning() {
		System.out.print("You can smell the water from a pit...\n> ");	
		
	}

}
