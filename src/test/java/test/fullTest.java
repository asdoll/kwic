package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CS3219.*;

/**
 * test function Without RequiredWords
 */
public class fullTest {
	@Test
    public void caseTest() throws Exception {
		List<String> inputs = new ArrayList<String>();
		inputs.add("The Day after Tomorrow");
		inputs.add("Fast and Furious");
		inputs.add("Man of Steel");
		inputs.add("Star Trek");
		inputs.add("2001: a Space Odyssey");
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("is");
		wordsToIgnore.addWordToIgnore("the");
		wordsToIgnore.addWordToIgnore("of");
		wordsToIgnore.addWordToIgnore("and");
		wordsToIgnore.addWordToIgnore("as");
		wordsToIgnore.addWordToIgnore("a");
		wordsToIgnore.addWordToIgnore("after");
		RequiredWords requiredwords = RequiredWords.getRequiredWords();
        requiredwords.addRequiredWords("Star");
        requiredwords.addRequiredWords("Space");
		Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }
        String[] result = alphabetizer.getSortedLines();
        System.out.print(result[0]);
        StringBuilder builder = new StringBuilder();
        String separator = "\n";
        for (String str : result) {
            builder.append(str).append("\n");
        }
        assertEquals("Space Odyssey 2001: a\nStar Trek\n",builder.toString());

    }
}
