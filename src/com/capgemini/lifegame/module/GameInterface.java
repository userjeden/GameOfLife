package com.capgemini.lifegame.module;


public interface GameInterface {

	/**
	 * Prepares the initial Board State based on the input
	 * arrangement (indicating which cells are alive) and arrangement size.
	 * 
	 * @param initArrang        the initial arrangement of cells
	 * @param initArrangSize   size of the given initial arrangement
	 * @return                  the initial state of the board
	 */
	public BoardState initializeBoard(int initArrangSize, int[][] initArrang);
	
	
	/**
	 * Creates a transition of a board (next step board) 
	 * based on a current step board state.
	 * 
	 * @param boardState        current state of the board
	 * @return                  state of the board after transition
	 */
	public BoardState transitionBoard(BoardState boardState);
	
	
	/**
	 * Returns the String representation of the board state
	 * for visual output.
	 * 
	 * @param boardState        current state of the board
	 * @return                  text representation of the visual output
	 */
	public String printBoard(BoardState boardState);
	
}
