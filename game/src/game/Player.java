package game;

public class Player {
	private int x;
	private int y;
	private int[] lookingAt;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		int[] newlooking = new int[2];
		newlooking[0] = x;
		newlooking[1] = y + 1;
		this.lookingAt = newlooking;
	}

	public void setLookingAt(String direction) {
		if (direction == "right") {
			// if looking at bottom
			if (this.lookingAt[0] == this.x && this.lookingAt[1] < this.y) {
				this.lookingAt[0] = this.x - 1;
				this.lookingAt[1] = this.y;
			} else {
				// if looking at left
				if (this.lookingAt[0] < this.x && this.lookingAt[1] == this.y) {
					this.lookingAt[0] = this.x;
					this.lookingAt[1] = this.y + 1;
				} else {
					// if looking at right
					if (this.lookingAt[0] > this.x && this.lookingAt[1] == this.y) {
						this.lookingAt[0] = this.x;
						this.lookingAt[1] = this.y - 1;
					} else {
						// if looking at top
						this.lookingAt[0] = this.x + 1;
						this.lookingAt[1] = this.y;
					}
				}
			}
		}
		if (direction == "left") {
			// if looking at bottom
			if (this.lookingAt[0] == this.x && this.lookingAt[1] < this.y) {
				this.lookingAt[0] = this.x + 1;
				this.lookingAt[1] = this.y;
			} else {
				// if looking at left
				if (this.lookingAt[0] < this.x && this.lookingAt[1] == this.y) {
					this.lookingAt[0] = this.x;
					this.lookingAt[1] = this.y - 1;
				} else {
					// if looking at right
					if (this.lookingAt[0] > this.x && this.lookingAt[1] == this.y) {
						this.lookingAt[0] = this.x;
						this.lookingAt[1] = this.y + 1;
					} else {
						// if looking at top
						this.lookingAt[0] = this.x - 1;
						this.lookingAt[1] = this.y;
					}
				}
			}
		}
		printLooking();
	}

	public void run(String input) {
		// TODO Auto-generated method stub
		if (input.equalsIgnoreCase("go"))
			go();
		if (input.equalsIgnoreCase("right"))
			setLookingAt("right");
		if (input.equalsIgnoreCase("left"))
			setLookingAt("left");

	}

	private void go() {
		// TODO Auto-generated method stub
		if(outOfMap()){
			System.out.print("You crashed into a wall.\n>");
			return;
		}
		// if looking at bottom
		if (this.lookingAt[0] == this.x && this.lookingAt[1] < this.y) {
			setX(this.lookingAt[0]);
			setY(this.lookingAt[1]);
			this.lookingAt[1]--;
		}
		// if looking at left
		if (this.lookingAt[0] < this.x && this.lookingAt[1] == this.y) {
			setX(this.lookingAt[0]);
			setY(this.lookingAt[1]);
			this.lookingAt[0]--;
		}
		// if looking at right
		if (this.lookingAt[0] > this.x && this.lookingAt[1] == this.y) {
			setX(this.lookingAt[0]);
			setY(this.lookingAt[1]);
			this.lookingAt[0]++;
		}
		// if looking at top
		if (this.lookingAt[0] == this.x && this.lookingAt[1] > this.y) {
			setX(this.lookingAt[0]);
			setY(this.lookingAt[1]);
			this.lookingAt[1]++;
		}
		printCell();
		printLooking();
	}

	private boolean outOfMap() {
		if(this.lookingAt[0] > 0 && this.lookingAt[0] < Main.WIDTH && this.lookingAt[1] > 0 && this.lookingAt[1] < Main.HEIGHT){
			return false;
		}
		return true;
	}

	public void printCell() {
		System.out.print("You are now in the cell " + this.x + ", " + this.y + "\n");
	}

	public void printLooking() {
		System.out.print("You are now facing the cell " + this.lookingAt[0] + ", " + this.lookingAt[1] + "\n> ");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
