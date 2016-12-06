package items;

public class Gold extends Item{
	public Gold(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void printWarning() {
		// TODO Auto-generated method stub
		System.out.print("You can see a golden light...\n> ");	
	}
	

}
