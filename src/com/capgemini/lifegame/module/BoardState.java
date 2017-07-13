package com.capgemini.lifegame.module;

public class BoardState {

	private int[][] boardState;
	private int boardSizeX;
	private int boardSizeY;
	
	
	public int[][] getBoard() {
		return boardState;
	}

	public int getSizeX() {
		return boardSizeX;
	}
	
	public int getSizeY() {
		return boardSizeY;
	}

	public BoardState(int size){
		this.boardSizeX = size;
		this.boardSizeY = 2*size;
		this.boardState = new int[size][2*size];
	}
	
	public BoardState(int size, int[][] board){
		this.boardSizeX = size;
		this.boardSizeY = 2*size;
		this.boardState = board;
	}
	
}
