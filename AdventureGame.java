 import java.util.*;
import javafx.application.Application;

public class AdventureGame {

	public static void main(String[] args){
		int version;
		Scanner scanner = new Scanner(System.in);
		boolean bool = true;
		while (bool) {
			try {
				System.out.println("Would you like to play in console (text version) or in a new window (GUI)? ");
				System.out.println("for a new window input: 0, for console version input: 1.");

				version = scanner.nextInt();


				if (version == 0) {
					bool = false;
					System.out.println("Have Fun!");
					javafx.application.Application.launch(Demo3.class);
				} else if (version == 1) {
					bool = false;
					TextApp ta = new TextApp();
					ta.playgame();
				} else {
					System.out.println("Please make sure the number you input is only either 0 or 1.");
				}
			} catch (InputMismatchException ime) {
				String badInput = scanner.next();

				System.out.println("Input was neither a 0 nor a 1, input: " + badInput);


			} catch (Exception e) {
				System.out.println("Exception occured, please only input either 0 or 1");
			}

		}




	}





}
