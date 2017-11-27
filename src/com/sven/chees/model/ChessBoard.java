package com.sven.chees.model;

import java.util.List;

public class ChessBoard {

	private int height;
	private int width;
	private List<Piece> pieces;

	public ChessBoard(int height, int width, List<Piece> pieces) {
		this.height = height;
		this.width = width;
		this.pieces = pieces;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

}
