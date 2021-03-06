package com.sven.chess.model;

import java.util.List;

public class ChessBoard {

	private int height;
	private int width;
	private List<Piece> pieces;

	public ChessBoard(final int height, final int width, final List<Piece> pieces) {
		this.height = height;
		this.width = width;
		this.pieces = pieces;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(final List<Piece> pieces) {
		this.pieces = pieces;
	}

}
