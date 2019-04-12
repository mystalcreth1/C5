import java.util.*;
public class Gamemap1{
//game map
//private instance variables
private Player user;
private Enemy enemy;
private Location lootLocation;

//private int xcoord; //not less than 0 or bigger than 1280 +/- width of avatar
//private int ycoord; //not less than not bigger than 720 +/- height of the avatar

private static char[][] map = new char[][] {
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','O',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
};

private static char[][] map2 = new char[][] {
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
    {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
		{'X',' ',' ',' ',' ',' ','S',' ',' ',' ',' ',' ',' ',' ',' ',' ','S',' ',' ',' ',' ','X'},
    {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
};


public Gamemap1(){
//creating instances of 2 objects, Player and Enemy
    user = new Player(1, 1);
    enemy = new Enemy(20, 10);

//Spawning P at the location of player & E at the location of the enemy
    map[user.getY()][user.getX()] = 'P';
    map[enemy.getY()][enemy.getX()] = 'E';

}


public Player getPlayer() {
	return user;
}
public Enemy getEnemy() {
	return enemy;
}
public char[][] getMap(){
	return map;
}


//Spawns the loot
public void setLootLocation(int x, int y) {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == '$') {
				map[row][col] = ' ';
			}
    }
	}
	lootLocation = new Location(x, y);
	map[y][x] = '$';
}

public Location getLootLocation() {
	return lootLocation;
}



public void setEnemyLocation(int x, int y) {
	enemy.setX(x);
	enemy.setY(y);
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'E';
}

public void setPlayerLocation(int x, int y) {
	user.setX(x);
	user.setY(y);
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P') {
				map[row][col] = ' ';
			}
    }
	}
	map[y][x] = 'P';
}
public void mapChecker() {
	Location lootLocation = getLootLocation();
	for (int row=0; row<  map.length; row++)
	{
			for(int col=0; col< map[row].length; col++){
				if (col == lootLocation.getX() && row == lootLocation.getY())
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = '$';
					}
				} else if (row == 1 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				} else if (row == 10 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				}
			}
	}
}


public void stop() {
	for (int row=0; row < map.length; row++) {
		for(int col=0; col< map[row].length; col++) {
			if (map[row][col] == 'P' || map[row][col] == 'E') {
				map[row][col] = ' ';
			}
    }
	}
}

public void drawMap() {
	Location lootLocation = getLootLocation();
	for (int row=0; row<  map.length; row++)
	{
			for(int col=0; col< map[row].length; col++){
				if (col == lootLocation.getX() && row == lootLocation.getY())
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = '$';
					}
				} else if (row == 1 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				} else if (row == 10 && col == 10)
				{
					if (map[row][col] == ' ')
					{
						map[row][col] = 'O';
					}
				}
					System.out.print(map[row][col] + "  ");
			}
			System.out.println();
	}
	System.out.println();
}

public void moving(Direction i, boolean whoMoves) {
	//boolean isOnSomething = false;
	if (whoMoves) {
		int x = user.getX();
		int y = user.getY();
		/*if (map[y][x] != ' ') {
			char thing = map[y][x];
			isOnSomething = true;
		}*/

	  if (i == Direction.UP) {
				y--;
	      user.setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      user.setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      user.setX(x);
	  }
	  else if (i==Direction.RIGHT){

				x++;
	      user.setX(x);
	  }

		setPlayerLocation(x, y);
	} else {
		int x = enemy.getX();
		int y = enemy.getY();

	  if (i == Direction.UP) {
				y--;
	      enemy.setY(y);
	  }
	  else if (i==Direction.DOWN){
				y++;
	      enemy.setY(y);
	  }
	  else if (i==Direction.LEFT){
				x--;
	      enemy.setX(x);
	  }
	  else if (i==Direction.RIGHT){
				x++;
	      enemy.setX(x);
	  }

		setEnemyLocation(x, y);


}
}




public int isPlayerValid(Player player, Direction x){
    /*
     * checks if the direction inputed has a wall, or an object, if it does, returns an appropriate integer
     */
			if (x == Direction.LEFT){
	        if(map[player.getY()][player.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()][player.getX()-1] == '$'){
	            return 1;
	        }
					else if(map[player.getY()][player.getX()-1] == 'E'){
							return 3;
					}
					else if(map[player.getY()][player.getX()-1] == 'O'){
							return 4;
					}

	    }
	    if (x == Direction.RIGHT){
	        if(map[player.getY()][player.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()][player.getX()+1] == '$'){
	            return 1;
	        }
					else if(map[player.getY()][player.getX()+1] == 'E'){
							return 3;
					}
					else if(map[player.getY()][player.getX()+1] == 'O'){
							return 4;
					}

	    }
	    if (x == Direction.UP){
	        if(map[player.getY()-1][player.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()-1][player.getX()] == '$'){
	            return 1;
	        }
					else if(map[player.getY()-1][player.getX()] == 'E'){
							return 3;
					}
					else if(map[player.getY()-1][player.getX()] == 'O'){
							return 4;
					}

	    }
	    if (x == Direction.DOWN){
	        if(map[player.getY()+1][player.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[player.getY()+1][player.getX()] == '$'){
	            return 1;
	        }
					else if(map[player.getY()+1][player.getX()] == 'E'){
							return 3;
					}
					else if(map[player.getY()+1][player.getX()] == 'O'){
							return 4;
					}
	    }
			return 2;
		}




		public int isEnemyValid(Enemy enemy, Direction x){
			if (x == Direction.LEFT){
	        if(map[enemy.getY()][enemy.getX()-1] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()][enemy.getX()-1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.RIGHT){
	        if(map[enemy.getY()][enemy.getX()+1] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()][enemy.getX()+1] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.UP){
	        if(map[enemy.getY()-1][enemy.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()-1][enemy.getX()] == 'P'){
	            return 3;
	        }

	    }
	    if (x == Direction.DOWN){
	        if(map[enemy.getY()+1][enemy.getX()] == 'X'){
	            return 0;
	        }
	        else if(map[enemy.getY()+1][enemy.getX()] == 'P'){
	            return 3;
	        }

	    }
		return 2;
	}
}
