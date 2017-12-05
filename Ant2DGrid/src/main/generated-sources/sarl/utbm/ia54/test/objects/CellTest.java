package utbm.ia54.test.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

public class CellTest {
	
	Cell cell;
	
	@Test
	public void testCell() {
		cell = new Cell();
		assertEquals(cell.getState(), CellState.NORMAL);
		assertFalse(cell == new Cell(1,1));
	}
	
	@Test
	public void testAddAnt(){
		fail("not yet implemented");//TODO
	}
	
	@Test
	public void testRemoveAnt() {
		fail("not yet implemented");//TODO
	}
	
	@Test
	public void testIncrementIntensity() {
		cell = new Cell();
		cell.incrementPheromoneFoodIntensity();
		cell.incrementPheromoneHomeIntensity();
		assertEquals(cell.getPheromoneFoodIntensity(), 1f, 0f);
		assertEquals(cell.getPheromoneHomeIntensity(), 1f, 0f);
	}
	
	@Test 
	public void testEvaporation() {
		cell = new Cell();
		cell.incrementPheromoneFoodIntensity();
		cell.incrementPheromoneHomeIntensity();
		cell.evaporationPheromoneFood();
		cell.evaporationPheromoneHome();
		assertEquals(cell.getPheromoneFoodIntensity(), 1f*0.5f, 0f);
		assertEquals(cell.getPheromoneHomeIntensity(), 1f*0.5f, 0f);
	}

}
