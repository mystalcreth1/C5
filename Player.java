import java.util.*;

//HERE IS SOME NICE BS FOR INHERTINCANE SEE IF IT RUNS
//LEV IS HIGH AND FUCKED UP LACTION CLASS WITH HIS TO STRING METHOD
public class Player extends Location{


	private int health = 100;
	//private Item items;

	// private Location location;
	private char move = 'k';

	public Player(int X, int Y) {//Location loc
		// location = new Location(loc.getX(), loc.getY());
        super(X, Y);
	}

    @Override
    public int getX(){
        return super.getX();
    }

    @Override
    public int getY(){
        return super.getY();
    }




	// public Location getLocation(){
	// 	return location;
	// }
    // public Location getLocation(){
    //     return location;
    // }

	// public void setLoc(Location loc){
	// 	location = loc;
	// }

	public Direction getDirection() {

		//scanner takes in user input which can be assigned to variables

		Scanner input = new Scanner(System.in);
		// variable it gets assigned to, so it can be used in if statements
		move = input.next().charAt(0);
		//if statements to return direction based on move variable
		if(move=='w'){
			return Direction.UP;
		} else if(move=='a'){
			return Direction.LEFT;
		} else if(move=='s'){
			return Direction.DOWN;
		} else if(move=='d'){
			return Direction.RIGHT;
		} else {
			System.out.println("Use the wasd keys to move");
			return Direction.NONE;
		}
	}

	/*public AttackType getMove(Enemy enemy) {
		return AttackType.KICK;
	}*/





}
