package items;

public abstract class Item {
    protected int x;
    protected int y;
    

    public Item(int x, int y){
    	
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public boolean isClose(int x, int y){
    	if (x >= this.x - 1 && y >= this.y - 1 && x <= this.x + 1 && y <= this.y + 1){
    		return true;
    	}
    	return false;
    }
    
    public abstract void printWarning();


}
