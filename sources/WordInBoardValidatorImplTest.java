package com.fes.wordy.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fes.wordy.IBoard;
import com.fes.wordy.IWordInBoardValidator;

/**
 * In Board Validator
 * JUnit Test Class
 * @author Sharadha
 *
 */
public class WordInBoardValidatorImplTest {

	private IWordInBoardValidator wordInBoardValidator ;
	private IBoard sampleBoard ;
	
	/**
	Per Word In Board Validator
	Valid word == DIE
	Valid word == KID
	Valid word == RID
	Valid word == RIDE
	Valid word == PIE
	Valid word == PRIDE
	Valid word == WE
	*/
	private char[][] _sampleData = {{'P', 'R', 'K', 'V'},{'U', 'I', 'D', 'Y'},
			{'Y', 'E', 'U', 'S'},{'C', 'Y', 'W', 'Z'}};

    @Before
    public void setUp() throws IOException {
        wordInBoardValidator = new WordInBoardValidatorImpl();
        sampleBoard = new BoardImpl();
    	((BoardImpl)sampleBoard).setCellMatrix(_sampleData);
    }
    
    @Test(timeout=64000)
    public void testForNullArgument() {
    	assertFalse(wordInBoardValidator.isWordInBoard(sampleBoard, null));
    }

    @Test(timeout=64000)
    public void testEmptyWord() {
    	assertFalse(wordInBoardValidator.isWordInBoard(sampleBoard, ""));
    }
    
    @Test(timeout=64000)
    public void testAllValidBoardWords() {
    	assertTrue(wordInBoardValidator.isWordInBoard(sampleBoard,"DIE"));
    	assertTrue(wordInBoardValidator.isWordInBoard(sampleBoard,"RIDE"));
    	assertEquals(Boolean.TRUE, 
    			wordInBoardValidator.isWordInBoard(sampleBoard,"KID"));
    	assertFalse(!wordInBoardValidator.isWordInBoard(sampleBoard,"PRIDE"));
    	assertEquals(Boolean.TRUE, 
    			wordInBoardValidator.isWordInBoard(sampleBoard,"RID"));
    	assertTrue(wordInBoardValidator.isWordInBoard(sampleBoard,"WE"));
    }

    @Test(timeout=64000)
    public void testAllInValidBoardWords() {
    	assertTrue(!wordInBoardValidator.isWordInBoard(sampleBoard,"DTBWIEFA"));
    	assertTrue(!wordInBoardValidator.isWordInBoard(sampleBoard,"HYAENM"));
    	assertEquals(Boolean.FALSE, wordInBoardValidator.isWordInBoard(sampleBoard,"YTWIM"));
    	assertFalse(wordInBoardValidator.isWordInBoard(sampleBoard,"CARSD"));
    	assertEquals(Boolean.FALSE, wordInBoardValidator.isWordInBoard(sampleBoard,"UWHNS"));
    	assertTrue(!wordInBoardValidator.isWordInBoard(sampleBoard,"YJUNQ"));    
    }
    
}