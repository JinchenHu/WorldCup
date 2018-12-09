
//-----------------------------------------------------------------------
//This a program is about generating a road map of matches and related
//goal statistics in the FIFA World Cup Final.The user enter a team, and 
//it will execute loop until the team entered win the final or up to the
//max number of tournaments. Then the total goals scored in each match, 
//the average goal for each tournament, the average goal for the entire
//game, and the number of matches with scores greater than the overall 
//average.
//-----------------------------------------------------------------------
import java.util.Scanner;//import the package

public class Qustion1 {

	public static void main(String[] args) {
		//declare a string array to store the names of 16 teams
		String[] team16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", "Colombia", "England"};
		//declare the scanner class
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your favourite team: ");
		//read a string and assign it to favaouriteTeam
		String favouriteTeam = sc.nextLine();
		System.out.println();
		//declare an integer and assign 0 to it
		int tournament = 0;
		//declare a string
		String winner;
		//declare a 2D array; the first dimension stores the tournament, while the second stores the total goals scored in each play in each tournament
		int[][] totalGoals = new int[20][15];
		boolean ifExist = false;
		//judge whether the user input is correct with for, after the loop, as long as the team name entered by the user is one of the 16 teams, a true will assign to the ifExist
		for(int i = 0; i < 16; i++) {
			if(favouriteTeam.equalsIgnoreCase(team16[i])) {
				ifExist = true;
			}
		}
		if(ifExist) {
			//since it should be executed before judgment, so we use do...while statement
			do {
				//declare a integer array to store the goal of each team
				int[] scores = new int[16];
				//declare a String array to store the teams that reach quarter-final
				String[] quarter = new String[8];
				System.out.print("ROUND OF 16");
				//get the goal of each team in the round of 16 with for statement,if statement, and random class
				for(int i = 0; i < 8; i++) {
					int j = 2 * i;
					scores[j] = (int)(Math.random() * 5);//the goal of the first team 
					scores[j + 1] = (int)(Math.random() * 5);//the goal of the second team
					if(scores[j] == scores[j + 1]) { //if the two teams score the same goal in the 90-minute period, there is a 30-minute sudden death period
						//stimulate sudden death period with random class
						int suddenDeath = (int)(Math.random() * 2);
						//if the random number is 0, we add 1 goal to the first team; otherwise, we add 1 to the other
						if(suddenDeath == 0) { 
							scores[j] += 1;
						}else {					
							scores[j + 1] += 1;
						}
					}
					//if the goal of first team is greater than the other, we assign the team name the quarter array; otherwise, we assign the other.
					if(scores[j] > scores[j + 1]) {
						quarter[i] = team16[j];//the goal of the first team
					}else {
						quarter[i] = team16[j + 1];
					}
					System.out.print("[" + team16[j] + " " + scores[j] + ":" + scores[j + 1] + " " + team16[j + 1] + "]" + " ");
					//assign the total goals of the two teams to the totalGoals and store in the index of 0 to 7
					totalGoals[tournament][i] = scores[j] + scores[j + 1];
				}
				System.out.println();
				System.out.print("QUARTER-FINALS");
				//declare an array to store the goal of each team
				scores = new int[8];
				//declare an array to store the teams that reach semi-final
				String[] semiFinal= new String[4];
				//Similarly, get the goal with for statement,if statement, and random class
				for(int i = 0; i < 4; i++) {
					int j = 2 * i;
					scores[j] = (int)(Math.random() * 5);//the goal of the first team
					scores[j + 1] = (int)(Math.random() * 5);//the goal of the second team
					if(scores[j] == scores[j + 1]) {//if the two teams score the same goal in the 90-minute period, there is a 30-minute sudden death period
						int suddenDeath = (int)(Math.random() * 2);
						if(suddenDeath == 0) {//if the random number is 0, we add 1 goal to the first team; otherwise, we add 1 to the other
							scores[j] += 1;
						}else {
							scores[j + 1] += 1;
						}
					}
					if(scores[j] > scores[j + 1]) {//if the goal of first team is greater than the other, we assign the team name to the quarter array; otherwise, we assign the other.
						semiFinal[i] = quarter[j];
					}else {
						semiFinal[i] = quarter[j + 1];
					}
					System.out.print("[" + quarter[j] + " " + scores[j] + ":" + scores[j + 1] + " " + quarter[j + 1] + "]" + " ");
					totalGoals[tournament][i + 8] = scores[j] + scores[j + 1];//store the total goal in the index of 8 to 12
				}
				System.out.println();
				System.out.print("SEMI-FINALS");
				scores = new int[4];
				//declare an array to store tow teams that reach the final
				String[] finals = new String[2];
				//Similarly, get the goal with for statement, if statement, and random class
				for(int i = 0; i < 2; i++) {
					int j = 2 * i;
					scores[j] = (int)(Math.random() * 5);//the goal of the first team
					scores[j + 1] = (int)(Math.random() * 5);//the goal of the second team
					if(scores[j] == scores[j + 1]) {//if the two teams score the same goal in the 90-minute period, there is a 30-minute sudden death period
						int suddenDeath = (int)(Math.random() * 2);
						if(suddenDeath == 0) {//if the random number is 0, we add 1 goal to the first team; otherwise, we add 1 to the other
							scores[j] += 1;
						}else {
							scores[j + 1] += 1;
						}
					}
					if(scores[j] > scores[j + 1]) {//if the goal of first team is greater than the other, we assign the team name to the quarter array; otherwise, we assign the other.
						finals[i] = semiFinal[j];
					}else {
						finals[i] = semiFinal[j + 1];
					}
					System.out.print("[" + semiFinal[j] + " " + scores[j] + ":" + scores[j + 1] + " " + semiFinal[j + 1] + "]" + " ");
					totalGoals[tournament][i + 12] = scores[j] + scores[j + 1];//store the total goal in the index of 12 and 13
				}
				System.out.println();
				//stimulate the final and get the goal with random class and if statement
				int finalA = (int)(Math.random() * 5);//the goal of the first team
				int finalB = (int)(Math.random() * 5);//the goal of the second team
				if(finalA == finalB) {//if the two teams score the same goal in the 90-minute period, there is a 30-minute sudden death period
					int suddenDeath = (int)(Math.random() * 2);
					if(suddenDeath == 0) {//if the random number is 0, we add 1 goal to the first team; otherwise, we add 1 to the other
						finalA += 1;
					}else {
						finalB += 1;
					}
				}
				if(finalA > finalB) {//if the goal of first team is greater than the other, we assign the team name to the winner; otherwise, we assign the other.
					winner = finals[0];
				}else {
					winner = finals[1];
				}
				System.out.println("FINAL[" + finals[0] + " " + finalA + ":" + finalB + " " + finals[1] + "]");
				System.out.println("Tournament: " + tournament + " The WINNER is: " + winner);
				totalGoals[tournament][14] = finalA + finalB; //store the total goal in the index of 14
				System.out.println();
				tournament++;//when the loop execute one time, the tournament will be increment
				//if the winner is not the team that the user enter and the the number of tournaments is smaller than 20, the loop will be execute
			}while((!winner.equalsIgnoreCase(favouriteTeam)) && (tournament < 20) );
			System.out.println("GOAL STATS");
			System.out.println();
			//declare a double 
			double sumOfAverages = 0;
			//declare a double
			double totalAverage = 0;
			//through the array with 2 for statement to calculate the average goal of each tournament and print each total goal
			for(int i = 0; i < tournament; i++) {
				double sum = 0.0;
				System.out.print("[Tournament " + i + "] Total goals: [");
				for(int j = 0; j < 15; j++) {
					sum += totalGoals[i][j];//calculate the sum of goal of all the 15 matches
					System.out.print(totalGoals[i][j]);//print total goals of each play
					if(j < 14) { 			//use if statement to make sure that a comma do not follow the last number
						System.out.print(", ");
					}
				}
				double average = sum / 15;//calculate the average of 15 total goals
				System.out.println("] [Average: " + String.format("%.1f", average) + "]");
				sumOfAverages += average;//calculate the sum of each average of every tournament
			}
			totalAverage = sumOfAverages / tournament;//calculate the overall average of the whole game
			System.out.println();
			System.out.println("Average goals for " + tournament + " tournament(s): " + String.format("%.1f", totalAverage));
			int count = 0;
			//through the array to get each number
			for(int i = 0; i < tournament; i++) {
				for(int j = 0; j < 15; j++) {
					//count the number that the number of matches with scores greater than the overall average
					if (totalGoals[i][j] > totalAverage) { 
						count++;
					}
				}
			}
			System.out.println("Total matches in all tournaments over the average goal value: " + count);
			//if the last winner is equal to the team entered by the use, print the statement below
			if(winner.equalsIgnoreCase(favouriteTeam)) { 
				System.out.println();
				System.out.println("It took " + tournament + " tournament(s) of the game for " + favouriteTeam + " to win!!!");
			}else {
				System.out.println("Sorry, " + favouriteTeam + " didn't win in 20 tournaments");
			}
		}else { //if the user enter the team name that is not the one of the 16 teams, we give them a prompt
			System.out.println("Your team is not in the Round of 16");
		}
		sc.close();//close the scanner
		
	}//end of main

}//end of class
