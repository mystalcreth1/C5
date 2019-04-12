import javafx.application.Application;

import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.*;

public class Demo3 extends Application {

	//initializes player speed
	public AnimationTimer atimer;
	private Label deadL = new Label("GAMEOVER");
	public Label moneycounter = new Label("$: ");
	public int counter = 9;
	private char move;
	boolean isItOverYet = false;

    //#################################
    private Player user;
    private Gamemap1 gamemap = new Gamemap1();
	private int isItValid = 0;
    //#################################

	public String enemySpriteLocation = "https://i.gyazo.com/dc7a81caa79fbae63b1f32e103d8bac0.png";
	Image enemySprite = new Image(enemySpriteLocation, 46, 85, false, false);
	public Node enemy1 = new ImageView(enemySprite);

    public String bagOfCoins = "https://i.gyazo.com/d2b097f96fbcca37008ebfac4bb0c121.png";
    Image coinsSprite = new Image(bagOfCoins, 46, 85, false, false);
    public Node coins1 = new ImageView(coinsSprite);

    public String spikesLocation = "https://i.gyazo.com/5737db78ae297dc53c74f34b83c1ea98.png";
    Image spikesSprite = new Image(spikesLocation, 46, 43, false, false);
    public Node spikes1 = new ImageView(spikesSprite);
    public Node spikes2 = new ImageView(spikesSprite);
    public Node spikes3 = new ImageView(spikesSprite);
    public Node spikes4 = new ImageView(spikesSprite);
    public Node spikes5 = new ImageView(spikesSprite);
    public Node spikes6 = new ImageView(spikesSprite);
    public Node spikes7 = new ImageView(spikesSprite);
    public Node spikes8 = new ImageView(spikesSprite);
    public Node spikes9 = new ImageView(spikesSprite);
    public Node spikes10 = new ImageView(spikesSprite);
    public Node spikes11 = new ImageView(spikesSprite);
    public Node spikes12 = new ImageView(spikesSprite);
    public Node spikes13 = new ImageView(spikesSprite);
    public Node spikes14 = new ImageView(spikesSprite);
    public Node spikes15 = new ImageView(spikesSprite);
    public Node spikes16 = new ImageView(spikesSprite);
    public Node spikes17 = new ImageView(spikesSprite);
    public Node spikes18 = new ImageView(spikesSprite);
   
    

    public String portalLocation = "https://i.gyazo.com/a1814a2bd337c5965d6b8db26f2c6c27.png";
    Image portalSprite = new Image(portalLocation, 46, 85, false, false);
    public Node portal1 = new ImageView(portalSprite);
    public Node portal2 = new ImageView(portalSprite);

    private TextField tf;

    //player sprite link and sets it up
    public String playerSpriteLocation = "https://i.gyazo.com/12f04f301ecc6634b9bfa58a2b05364a.png";
    Image playerSprite = new Image(playerSpriteLocation);
	public Node player1 = new ImageView(playerSprite);

	// direction Direction
	Direction whichDirection = Direction.NONE;
	//initializes second gamestage
	private Stage stage1 = new Stage();
	private Stage deadStage = new Stage();
	private Stage gameStage = new Stage();
	private Stage gameStage2 = new Stage();
    // CONSTRUCTORS
    public Demo3() {}

    public void start (Stage stage1) {
        BorderPane pane = new BorderPane();

        VBox vb = new VBox();
        Label label1 = new Label("Death Simulator");
         //"Recover the treasure! It's our only hope of escaping the life of poor students everywhere! "
        vb.getChildren().add(label1);
        vb.setAlignment(Pos.CENTER);
        pane.setTop(vb);
				pane.setStyle("-fx-background-color: red");
				label1.setStyle("-fx-text-fill: black; -fx-font-size: 40px;");

        HBox hb = new HBox();
        Button b1 = new Button("Start");
        Button b2 = new Button("Settings");
        Button b3 = new Button("Exit");
        hb.getChildren().add(b1);
        hb.getChildren().add(b2);
        hb.getChildren().add(b3);
        hb.setAlignment(Pos.CENTER);
        pane.setCenter(hb);

        //on button press start uses gameStage here as parameter to in method
        //actualGame to start new stage
        b1.setOnAction(e -> {
        	stage1.close();
        	actualGame(gameStage);
        });

				b3.setOnAction(e -> {
					stage1.close();
				});


        Scene scene = new Scene(pane, 400, 200);
        stage1.setTitle("Demo 3");
        stage1.setScene(scene);
        stage1.show();
    }

    // stage that will have actual game in it, created by b1.setOnAction

		public void actualGame(Stage gameStage){
		setStartConditions();
		Group gamePane = new Group(player1, coins1, enemy1, moneycounter, portal1, portal2);
		Scene gameScene = new Scene(gamePane, 46*20, 85*10);


		//starts moving player, added links to sprites of player facing different directions
		//not sure how to implement them yet
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent pressed){


				if(pressed.getCode() == KeyCode.W){
					whichDirection = Direction.UP;
				}
				else if(pressed.getCode() == KeyCode.A){
					whichDirection = Direction.LEFT;
				}
				else if(pressed.getCode() == KeyCode.S){
					whichDirection = Direction.DOWN;
				}
				else if(pressed.getCode() == KeyCode.D){
					whichDirection = Direction.RIGHT;

				}

			}
		}

	);

		// stops the player once key is released
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent lifted){
			if(lifted.getCode()== KeyCode.W){
				whichDirection = Direction.NONE;
			}
			else if(lifted.getCode()== KeyCode.A){
				whichDirection = Direction.NONE;
			}
			else if(lifted.getCode()== KeyCode.S){
				whichDirection = Direction.NONE;
			}
			else if(lifted.getCode()== KeyCode.D){
				whichDirection = Direction.NONE;
			}
			else{
				whichDirection = Direction.NONE;
			}

		}
		});

		moneycounter.setStyle("-fx-font-size: 40px;");
		gameStage.setTitle("Try Not to Die Simulator");
		gameStage.setScene(gameScene);
		gameStage.show();

		//determines speed of player
		AnimationTimer timer = new AnimationTimer() {
			private long lastMapUpdate = 0;
					@Override
					public void handle(long now) {
						if(now - lastMapUpdate >= 28_000_000){
					 int x = 0;
					 int y = 0;
					 if (whichDirection != Direction.NONE) {

						 Direction enemyMove = gamemap.getEnemy().getMove(gamemap.getPlayer());
						 isItValid = gamemap.isEnemyValid(gamemap.getEnemy(), enemyMove);
						 if (isItValid == 2) {
							 gamemap.moving(enemyMove, false);
							 x = gamemap.getEnemy().getX();
							 y = gamemap.getEnemy().getY();
							 enemy1.relocate(x*46 - 46, y*85 - 85);

						 } else if (isItValid == 3) {
							 //setStartConditions();
							 gamemap.stop();
							 gameStage.close();
							 gameOver(deadStage);
							 //System.out.println("Awww you got caught, try again next time.");
						 }

						 int isItValid = gamemap.isPlayerValid(gamemap.getPlayer(), whichDirection);
						 if (isItValid == 2) {
							 gamemap.moving(whichDirection, true);
							 x = gamemap.getPlayer().getX();
							 y = gamemap.getPlayer().getY();
							 player1.relocate(x*46 - 46, y*85 - 85);



						 } else if (isItValid == 1) {
							 counter++;
							 moneycounter.setText("$: " + Integer.toString(counter));
							 //System.out.println("Congratulations you found a bag of gold!");
							 if(counter ==10) {
							 gamemap.stop();
							 gameStage.close();
							 actualGame2(gameStage2);
							 isItValid = 10;
							 }
							 setStartConditions();
							 isItValid = 0;
						 } else if(isItValid == 4) {
							 //		portal1.relocate(9*46, 9*85);
							 //		portal2.relocate(9*46, 0*85);
								if (gamemap.getPlayer().getY() != 10) {
									gamemap.setPlayerLocation(10, 10);
									player1.relocate(10*46, 10*85);
								} else {
									gamemap.setPlayerLocation(10, 1);
									player1.relocate(10*46, 1*85);
								}

						 }
						gamemap.mapChecker();
					 }


					 lastMapUpdate = now;
					 }
					}
			};
			timer.start();

		}
   
   public void actualGame2(Stage gameStage2){
		setStartConditions();
		Group gamePane = new Group(player1, coins1, enemy1, moneycounter, portal1, portal2, spikes1,spikes2,spikes3,spikes4,spikes5,spikes6,spikes7,spikes8,spikes9,spikes10,spikes11,spikes12,spikes13,spikes14,spikes15,spikes16,spikes17);
		Scene gameScene = new Scene(gamePane, 46*20, 85*10);
		


	   //starts moving player, added links to sprites of player facing different directions
	   //not sure how to implement them yet
	   gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		   public void handle(KeyEvent pressed){


			   if(pressed.getCode() == KeyCode.W){
				   whichDirection = Direction.UP;
			   }
			   else if(pressed.getCode() == KeyCode.A){
				   whichDirection = Direction.LEFT;
			   }
			   else if(pressed.getCode() == KeyCode.S){
				   whichDirection = Direction.DOWN;
			   }
			   else if(pressed.getCode() == KeyCode.D){
				   whichDirection = Direction.RIGHT;

			   }

		   }
	   }

 );
	   // stops the player once key is released
	   gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		   public void handle(KeyEvent lifted){
		   if(lifted.getCode()== KeyCode.W){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.A){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.S){
			   whichDirection = Direction.NONE;
		   }
		   else if(lifted.getCode()== KeyCode.D){
			   whichDirection = Direction.NONE;
		   }
		   else{
			   whichDirection = Direction.NONE;
		   }

	   }
	   });

	   moneycounter.setStyle("-fx-font-size: 40px;");
	   gameStage2.setTitle("Try Not to Die Simulator");
	   gameStage2.setScene(gameScene);
	   gameStage2.show();

	   //determines speed of player
	   AnimationTimer timer = new AnimationTimer() {
			private long lastMapUpdate = 0;
					@Override
					public void handle(long now) {
					if(now - lastMapUpdate >= 28_000_000){
					 int x = 0;
					 int y = 0;

					 if (whichDirection != Direction.NONE) {

						 Direction enemyMove = gamemap.getEnemy().getMove(gamemap.getPlayer());
						 isItValid = gamemap.isEnemyValid(gamemap.getEnemy(), enemyMove);
						 if (isItValid == 2) {
							 gamemap.moving(enemyMove, false);
							 x = gamemap.getEnemy().getX();
							 y = gamemap.getEnemy().getY();
							 enemy1.relocate(x*46 - 46, y*85 - 85);

						 } else if (isItValid == 3) {
							 //setStartConditions();
							 gamemap.stop();
							 gameStage2.close();
							 gameOver(deadStage);
							 //System.out.println("Awww you got caught, try again next time.");
						 }

						 int isItValid = gamemap.isPlayerValid(gamemap.getPlayer(), whichDirection);
						 if (isItValid == 2) {
							 gamemap.moving(whichDirection, true);
							 x = gamemap.getPlayer().getX();
							 y = gamemap.getPlayer().getY();
							 player1.relocate(x*46 - 46, y*85 - 85);



						 } else if (isItValid == 1) {
							 counter++;
							 moneycounter.setText("$: " + Integer.toString(counter));
							 //System.out.println("Congratulations you found a bag of gold!");
							 gamemap.stop();
							 gameStage.close();
							 actualGame2(gameStage2);
							 setStartConditions();
							 isItValid = 0;
						 } 
					 }


					 lastMapUpdate = now;
					 }
					}
			};
     timer.start();



   }
   

	 public void gameOver(Stage deadStage){
       deadL.setStyle("-fx-font-size: 80px;");
       BorderPane gamePane = new BorderPane(deadL);
       HBox hb1 = new HBox();
       Button b1 = new Button("Try again!");
       hb1.getChildren().add(b1);
       hb1.setAlignment(Pos.BOTTOM_CENTER);
       deadL.setAlignment(Pos.CENTER);
       b1.setOnAction(e -> {
    	   
    	gamemap.stop();
       	deadStage.close();
       	start(stage1);
       });
       Scene gameScene = new Scene(gamePane, 800, 400);
       gamePane.setStyle("-fx-background-color: red");
       gamePane.setCenter(hb1); 
       deadStage.setTitle("nice one dingus!");
       deadStage.setScene(gameScene);
       deadStage.show();
   }
	 //multiple screens maybe, add more obstacles in new stages maybe, settings to mess with AI
	public void setStartConditions() {
		player1.relocate(0, 0);
		gamemap.setPlayerLocation(1, 1);
		gamemap.setEnemyLocation(20, 10);
		enemy1.relocate(19*46, 9*85);
		portal1.relocate(9*46, 9*85);
		portal2.relocate(9*46, 0*85);
		spikes1.relocate(5*46,0*85);
		spikes2.relocate(5*46,1*85);
		spikes3.relocate(5*46,2*85);
		spikes4.relocate(5*46,7*85);
		spikes5.relocate(5*46,8*85);
		spikes6.relocate(5*46,9*85);
		spikes7.relocate(10*46,2*85);
		spikes8.relocate(10*46,3*85);
		spikes9.relocate(10*46,4*85);
		spikes10.relocate(10*46,5*85);
		spikes11.relocate(10*46,6*85);
		spikes12.relocate(10*46,7*85);
		spikes13.relocate(15*46,0*85);
		spikes14.relocate(15*46,1*85);
		spikes15.relocate(15*46,2*85);
		spikes16.relocate(15*46,7*85);
		spikes16.relocate(15*46,8*85);
		spikes17.relocate(15*46,9*85);
		Random randomObj = new Random();
		int randomX = randomObj.nextInt(20);
		int randomY = randomObj.nextInt(10);
		coins1.relocate(randomX*46, randomY*85);
		gamemap.setLootLocation(randomX + 1, randomY + 1);
		//coins1.relocate(10*46,5*85);
		//gamemap.setLootLocation(11, 6);
	}

}
