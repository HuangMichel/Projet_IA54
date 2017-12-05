/**
 * 
 */
package utbm.ia54.test.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 *
 */
public class Vetor2iTest {

	Vector2i vector;
	
	/**
	 * Test method for {@link utbm.ia54.ant2dgrid.objects.Vector2i#Vector2i()}.
	 */
	@Test
	public void testVector2i() {
		vector = new Vector2i(1,1);
		assertEquals(vector, new Vector2i(1,1));
		assertFalse(vector == new Vector2i());
	}

}
