package enemys;

public abstract class Enemy {
    protected int x;
    protected int y;
    

    public Enemy(int x, int y){
    	
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
