package com.fes.wordy;

/**
 * Verifies that the word can be found in a particular board or instance. <br>
 * NOTE: This is the extra credit interface. You should implement this interface
 * and hook it up in the your implementation of IWordy.
 */
public interface IWordInBoardValidator {
	/**
	 * Checks whether the given word can be found in the board. The rules for a
	 * "valid" word are:
	 * <ul>
	 * <li>Words are formed from adjoining letters.</li>
	 * <li>Letters must join in the proper sequence to spell a word.</li>
	 * <li>They may join horizontally, vertically, or diagonally, to the left,
	 * right, or up-and-down.</li>
	 * <li>No letter cell may be used more than once within a single word.</li>
	 * </ul>
	 *
	 * @param board
	 *            IBoard
	 * @param word
	 *            String
	 * @return boolean
	 */
	boolean isWordInBoard(IBoard board, String word);
}
