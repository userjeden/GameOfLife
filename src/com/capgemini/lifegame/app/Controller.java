package com.capgemini.lifegame.app;

import java.io.IOException;

import com.capgemini.lifegame.module.BoardState;
import com.capgemini.lifegame.module.GameService;

public class Controller {

	public void run() {

		GameService game = new GameService();
		BoardState initialBoardState = game.initializeBoard(Data.initArrangSize, Data.initArrang);

		while (true) {

			System.out.flush();
			System.out.println(game.printBoard(initialBoardState));
			BoardState nextBoardState = game.transitionBoard(initialBoardState);
			initialBoardState = nextBoardState;

			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
