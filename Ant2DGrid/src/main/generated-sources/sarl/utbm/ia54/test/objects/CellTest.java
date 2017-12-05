package utbm.ia54.test.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import utbm.ia54.ant2dgrid.Enum.CellState;
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
	public void testSetCell() {
		cell = new Cell(4, 6, CellState.WALL);
		assertEquals(cell, new Cell(4,6, CellState.WALL));
		cell.setPosition(5, 6);
		assertFalse(cell == new Cell(4,6, CellState.WALL));
	}

}
