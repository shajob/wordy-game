package com.fes.wordy.impl;

import com.fes.wordy.IWordScorer;
import com.fes.wordy.util.ArgCheck;

/**
 * The Scorer Class is the Final 
 * Score assigner upon Validation 
 * As per Generic Validator / InBoard Validator
 */
public class WordScorerImpl implements IWordScorer {
	/**
	 * Returns the score of the word based on the following rules: <br>
	 * <table summary="">
	 * <tr>
	 * <th>Word Length:</th>
	 * <th rowspan="7">&nbsp;&nbsp;&nbsp;</th>
	 * <th>Points:</th>
	 * </tr>
	 * <tr>
	 * <td>2 or fewer</td>
	 * <td>0 (invalid)</td>
	 * </tr>
	 * <tr>
	 * <td>3 or 4</td>
	 * <td>1</td>
	 * </tr>
	 * <tr>
	 * <td>5</td>
	 * <td>2</td>
	 * </tr>
	 * <tr>
	 * <td>6</td>
	 * <td>3</td>
	 * </tr>
	 * <tr>
	 * <td>7</td>
	 * <td>5</td>
	 * </tr>
	 * <tr>
	 * <td>8 and over</td>
	 * <td>11</td>
	 * </tr>
	 * </table>
	 * <br>
	 *
	 * @param word
	 *            the word to score: must not be null
	 * @return the score for the given word based on the scoring rules.
	 */
	@Override
	public int scoreWord(String word) {
		try {
			ArgCheck.nonNull(word, "word");
			int length = word.length();
			return score[length > max ? max : length];
		} catch(Exception e) {
			return 0;
		}
	}

	private final static int score[] =
		{
			0, // 0
			0, // 1
			0, // 2
			1, // 3
			1, // 4
			2, // 5
			3, // 6
			5, // 7
			11 // >8
		};
	private static final int max = score.length - 1;
}
