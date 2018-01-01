package utbm.ia54.test.objects;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.AntBody;
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
		UUID id = UUID.randomUUID();
		cell.addAnt(id, new AntBody(id, new Vector2i()));
		assertEquals(cell.getNumberAnt(), 1);
	}
	
	@Test
	public void testRemoveAnt() {
		UUID id = UUID.randomUUID();
		AntBody body = new AntBody(id, new Vector2i());
		cell.addAnt(id, body);
		cell.removeAnt(id, body);
		assertEquals(cell.getNumberAnt(), 0);
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
