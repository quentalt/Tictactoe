package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {
	
	static ArrayList<Integer> joueurPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
	char[][] plateau  = {{' ','|',' ','|',' '},
						{'-','+','-','+','-'},
						{' ','|',' ','|',' '},
						{'-','+','-','+','-'},
						{' ','|',' ','|',' '}};

	
	
	
	printGameBoard(plateau);

	while(true) {
		Scanner scan = new Scanner(System.in);	
		System.out.println("entrer votre placement (1-9):");
		int joueurPos = scan.nextInt();
		while(joueurPositions.contains(joueurPos) || cpuPositions.contains(joueurPositions) ) {
			
			System.out.println("position prise");
			
			joueurPos = scan.nextInt();
		}
		System.out.println(joueurPos);
		
		placePiece(plateau, joueurPos, "joueur");
		
		Random rand = new Random();
		int cpuPos = rand.nextInt(9)+1;
while(joueurPositions.contains(cpuPos) || cpuPositions.contains(joueurPositions) ) {
						
			cpuPos = rand.nextInt(9)+1;
		}
		placePiece(plateau, cpuPos, "cpu");

		printGameBoard(plateau);
		
		String result = verifieGagnant();
		
		if(result.length() > 0) {
			
			System.out.println(result);
break;			
		}
	}
	

}
	
	public static void printGameBoard(char[][] plateau) {
	
	for (char[] row: plateau) {
		for(char c: row) {
			System.out.print(c);
			
		}
		System.out.println();
		
	}
	
	}
	
	public static void placePiece(char[][] plateau, int pos, String user ) {
		
		char symbol = 'X';
		
		if(user.equals("player")) {
			
			 symbol = 'X';
			 
			 joueurPositions.add(pos);
			
		} else if (user.equals("cpu")) {
			
			symbol = '0';
			
			cpuPositions.add(pos);
		}
		
		switch(pos) {
		
		case 1:
			
			plateau[0][0] = symbol;
			break;
			
		case 2:
			
			plateau[0][2] = symbol;
			break;
			
		case 3:
			
			plateau[0][4] = symbol;
			break;
	case 4:
		
		plateau[2][0] = symbol;
		break;
	case 5:
		
		plateau[2][2] = symbol;
		break;
		
	case 6:
		
		plateau[2][4] = symbol;
		break;
		
	case 7:
		
		plateau[4][0] = symbol;
		break;
		
	case 8:
		
		plateau[4][2] = symbol;
		break;
		
		
	case 9:
			
		plateau[4][4] = symbol;
		
		default:
		break;
		}
	}
	
	public static String verifieGagnant() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bothRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List  cross1= Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bothRow);
		winning.add(leftCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l: winning) {
			
			if(joueurPositions.containsAll(l)) {
		return "marvelous tu as gagne";
			} else if(cpuPositions.containsAll(l)) {
				return "cpu wins!";		
			} else if(joueurPositions.size()+ cpuPositions.size() == 9) {
				
				return "plein";
			}
		}
		return "";
	}
		
}	
	
