/**
 * 
 */
package utbm.ia54.test.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import utbm.ia54.ant2dgrid.objects.Pheromone;

/**
 * @author Michel
 *
 */
public class PheromoneTest {
	
	Pheromone pheromone;
	/**
	 * Test method for {@link utbm.ia54.ant2dgrid.objects.Pheromone#incrementIntensity()}.
	 */
	@Test
	public void testIncrementIntensity() {
		pheromone = new Pheromone();
		pheromone.incrementIntensity();
		assertEquals(pheromone.getIntensity(), 1f, 0f);
	}

	/**
	 * Test method for {@link utbm.ia54.ant2dgrid.objects.Pheromone#evaporation()}.
	 */
	@Test
	public void testEvaporation() {
		pheromone = new Pheromone();
		pheromone.setIntensity(5);
		pheromone.evaporation();
		assertEquals(pheromone.getIntensity(), 5*pheromone.getCoefEvaportation(), 0f);
	}

}
