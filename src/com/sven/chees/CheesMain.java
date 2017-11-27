package com.sven.chees;

import java.util.Arrays;
import java.util.List;

import com.sven.chees.model.ChessBoard;
import com.sven.chees.model.ChessLayout;
import com.sven.chees.model.King;
import com.sven.chees.model.Piece;
import com.sven.chees.model.Rook;

public class CheesMain {

	public static void main(String[] args) {

		ChessBoard chessBoard = new ChessBoard(4, 4, Arrays.asList(new King(), new King(), new Rook()));

		ChessLayout layout = new ChessLayout(chessBoard);
		layout.print();
	}

	public static String[] getAllLists(List<Piece> pieces, int lengthOfList) {
		// initialize our returned list with the number of elements calculated above
		String[] allLists = new String[(int) Math.pow(elements.length, lengthOfList)];

		// lists of length 1 are just the original elements
		if (lengthOfList == 1)
			return elements;
		else {
			// the recursion--get all lists of length 3, length 2, all the way up to 1
			String[] allSublists = getAllLists(elements, lengthOfList - 1);

			// append the sublists to each element
			int arrayIndex = 0;

			for (int i = 0; i < elements.length; i++) {
				for (int j = 0; j < allSublists.length; j++) {
					// add the newly appended combination to the list
					allLists[arrayIndex] = elements[i] + allSublists[j];
					arrayIndex++;
				}
			}
			return allLists;
		}
	}
}
