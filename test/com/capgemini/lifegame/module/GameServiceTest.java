package com.capgemini.lifegame.module;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class GameServiceTest {

	static GameService game;
	
	int arrangSize = 4;
	int[][] arrangOne = {
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0} };
	
	int[][] arrangTwo = {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0} };
	
	int[][] arrangThree = {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0} };
	
	String outputOne = "\n\n" +
			"| | | |#| | | | |\n" +
	        "| | | | |#| | | |\n" +
			"| | |#|#|#| | | |\n" +
		   	"| | | | | | | | |";
	
	
	
	@BeforeClass
	public static void setup(){
		game = new GameService();
	}
	
	
	@Test
	public void shouldInitializeBoard(){
		
		//WHEN
		BoardState boardStateOne = game.initializeBoard(arrangSize, arrangOne);
		
		//THEN
		assertArrayEquals(arrangOne, boardStateOne.getBoard());
	}
	
	
	@Test
	public void shouldTransitionBoard() {
		
		//WHEN
		BoardState boardStateOne = game.initializeBoard(arrangSize, arrangOne);
		BoardState boardStateTwo = game.transitionBoard(boardStateOne);
		BoardState boardStateThree = game.transitionBoard(boardStateTwo);
		
		//THEN
		assertArrayEquals(arrangThree, boardStateThree.getBoard());
	}
	
	
	@Test
	public void shouldPrintBoard(){
		
		//WHEN
		BoardState boardStateOne = game.initializeBoard(arrangSize, arrangOne);
		String output = game.printBoard(boardStateOne);
		
		//THEN
		assertEquals(outputOne, output);
	}

}
