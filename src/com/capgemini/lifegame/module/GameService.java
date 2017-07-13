package com.capgemini.lifegame.module;

public class GameService implements GameInterface {

	@Override
	public BoardState initializeBoard(int initArrangSize, int[][] initArrang) {
		return new BoardState(initArrangSize, initArrang);
	}

	@Override
	public BoardState transitionBoard(BoardState initialBoard) {
		int boardSizeX = initialBoard.getSizeX();
		int boardSizeY = initialBoard.getSizeY();

		BoardState nextState = new BoardState(boardSizeX);
		for (int row = 0; row < boardSizeX; row++) {
			for (int col = 0; col < boardSizeY; col++) {
				nextState.getBoard()[row][col] = willCellBeAlive(initialBoard, row, col);
			}
		}
		return nextState;
	}

	@Override
	public String printBoard(BoardState boardState) {
		int boardSizeX = boardState.getSizeX();
		StringBuilder strb = new StringBuilder();
		strb.append("\n");
		for (int row = 0; row < boardSizeX; row++) {
			strb.append("\n|");
			printRow(boardState, strb, row);
		}
		return strb.toString();
	}

	private void printRow(BoardState boardState, StringBuilder strb, int row) {
		int boardSizeY = boardState.getSizeY();
		for (int col = 0; col < boardSizeY; col++) {
			printCell(boardState, strb, row, col);
		}
	}

	private void printCell(BoardState boardState, StringBuilder strb, int row, int col) {
		if (boardState.getBoard()[row][col] == 1) {
			strb.append("#|");
		} else {
			strb.append(" |");
		}
	}

	private int willCellBeAlive(BoardState initialBoard, int row, int col){
		int numOfNeighbours = countNeighbours(initialBoard, row, col);
		if(initialBoard.getBoard()[row][col] == 1){
			return (numOfNeighbours == 3 || numOfNeighbours == 2)  ? 1 : 0;
		}else{
			return (numOfNeighbours == 3) ? 1 : 0;
		}
	}

	private int countNeighbours(BoardState boardState, int row, int col) {
		int numOfNeighbours = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			numOfNeighbours = numOfNeighbours + countNeighboursInRow(boardState, col, i);
		}
		return boardState.getBoard()[row][col] == 1 ? numOfNeighbours - 1 : numOfNeighbours;
	}

	private int countNeighboursInRow(BoardState boardState, int col, int row) {
		int numOfNeighbours = 0;
		for (int j = col - 1; j <= col + 1; j++) {
			if(checkCellLives(boardState, row, j)){
				numOfNeighbours++;
			}
		}
		return numOfNeighbours;
	}

	private boolean checkCellLives(BoardState boardState, int row, int col) {
		int[][] board = boardState.getBoard();
		int boardSizeX = boardState.getSizeX();
		int boardSizeY = boardState.getSizeY();
		if (!(row < 0 || col < 0 || row > boardSizeX - 1 || col > boardSizeY - 1)) {
			return board[row][col] == 1 ? true : false;
		} else {
			return false;
		}
	}

}
