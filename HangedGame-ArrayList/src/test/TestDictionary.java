package test;

import main.Dictionary;

import org.junit.Assert;
import org.junit.Test;


public class TestDictionary {

	@Test
	public void testGetNextWord(){
		
		Dictionary hanged = new Dictionary("test.txt");
		
		Assert.assertEquals(3, hanged.size());
		
		hanged.getNextWord();
		Assert.assertEquals(2, hanged.size());
		
		hanged.getNextWord();
		Assert.assertEquals(1, hanged.size());
		
		hanged.getNextWord();
		Assert.assertEquals(0, hanged.size());
		
		hanged.getNextWord();
		Assert.assertEquals(2, hanged.size());

	}
	
}
