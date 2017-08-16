package com.fes.wordy.impl;

import java.util.List;

import com.fes.wordy.IBoard;
import com.fes.wordy.IWordInBoardValidator;
import com.fes.wordy.util.FileUtil;

/**
 * InBoard Validator with respect to Particular
 * Board Values at each Cell , handles below cases 
 * Dictionary , Adjoining & InBoard validation
 * @author Sharadha
 *
 */
public class WordInBoardValidatorImpl implements IWordInBoardValidator {

	// CONDITIONS :
		// 1. WORD LENGTH SHOULD BE MORE THAN 3 LETTERS else Score is 0 - SCORER HANDLES
		// 2. ONLY ADJOINING LETTERS - WORD IN BOARD VALIDATOR
		// 3. NO LETTER REPETITION & 
	// 4. DICTIONARY WORD - similar to check of WordValidatorImpl
	/**
	 * InBoard Validator
	 * 
	 * @param board
	 * @param word
	 * @return boolean
	 */
	@Override
	public boolean isWordInBoard(IBoard board, String word) {
		
		BoardImpl boardImpl = ((BoardImpl) board);
		List<String> validWords = FileUtil.VALID_WORDS;
		if(validWords == null || validWords.size() == 0) return false;
		
		boolean isWordInBoard = false;	
		try {
			if(boardImpl.isAllCharOnBoard(word) && validWords.contains(word)) {
				
				// Validating Board Conditions
				List<String> adjPhrases = boardImpl.getBoardAdjPhrases();
				StringBuffer tempBuff = new StringBuffer();
				
				char[] wcArr = word.toCharArray();
				for(int c = 0; c < wcArr.length - 1; c++) {
					try {
						tempBuff.delete(0, tempBuff.length()).trimToSize();
					} catch(Exception ex) {
						
					}
					tempBuff.append(wcArr[c]);tempBuff.append(wcArr[c+1]);
					if(!adjPhrases.contains(tempBuff.toString().trim().toUpperCase())) {
						return false;
					}
				}
				// Now, the validity of word is proven
				isWordInBoard = true;
				System.out.println("Valid word == " + word);
				
			}
		} catch(Exception ex) {
		
		}
		return isWordInBoard;
		
	}
	
	public WordInBoardValidatorImpl() {
		checkForDictionary();
	}
	
	/**
     * To Ensure Valid Dictionary words
     * Are loaded for this Validator Class
     * Or its further Code dependent classes
     */
    private void checkForDictionary() {
    	if(FileUtil.VALID_WORDS == null || 
    			FileUtil.VALID_WORDS.size() == 0) {
    		try {
    			FileUtil util = new FileUtil(WordyImpl.DICTIONARY_FILE);
    		} catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }
}