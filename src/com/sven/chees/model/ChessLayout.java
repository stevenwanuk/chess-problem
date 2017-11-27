package com.sven.chees.model;

public class ChessLayout {

	private ChessBoard chessBoard;
	private Piece[][] layout;

	public ChessLayout(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;

		layout = new Piece[chessBoard.getHeight()][chessBoard.getWidth()];
		for (int i = 0; i < chessBoard.getHeight(); i++) {
			for (int j = 0; j < chessBoard.getWidth(); j++) {
				layout[i][j] = EmptyPiece.INSTANCE;
			}
		}
	}

	public void place(Piece piece, Position position) {

		layout[position.getX()][position.getY()] = piece;
	}

	public void print() {
		for (Piece[] row : layout) {
			System.out.println("");
			for (Piece piece : row) {
				System.out.print(piece.getName());
			}
		}
	}
}
