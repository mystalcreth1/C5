import java.util.*;

 public class Enemy extends Location{

	private Location enemyLoc;
	private Player user;
	private int health = 100;

	public Enemy(int x, int y) {
		super(x, y);
	}

	@Override
	public int getX(){
			return super.getX();
	}

	@Override
	public int getY(){
			return super.getY();
	}

	public Direction getMove(Player user) {
		int playerX = user.getX();
		int playerY = user.getY();
		if (playerX > getX()) {
			if (playerY < getY()) {
				return Direction.UP;
			} else {
				return Direction.RIGHT;
			}
		} else if (playerX < getX()){
			if (playerY < getY()) {
				return Direction.UP;
			} else {
				return Direction.LEFT;
			}
		} else if (playerY > getY()) {
			return Direction.DOWN;
		} else {
			return Direction.NONE;
		}


	}


}
