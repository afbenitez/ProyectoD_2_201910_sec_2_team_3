package model.data_structures;

import junit.framework.TestCase; 
import model.data_structures.Queue;
import org.junit.*;
public class TestQueue extends TestCase{

	Queue <Integer> cola;

	@Before
	public void setUp()
	{
		cola = new Queue<Integer>();
		cola.enqueue(11);
		cola.enqueue(12);
		cola.enqueue(13);
	}

	public void testEnqueue()
	{
		assertEquals("No es el elemento esperado", 13, cola.darUltimo().intValue());
	}

	
	public void testDequeue()
	{
		assertEquals("No se eliminó el primero",11,cola.dequeue().intValue());
	}

	public void testSizeQ() throws Exception
	{
		assertEquals("El tamaño no es el esperado",3,cola.size());
	}

	public void testEmpty()
	{
		cola.dequeue();
		cola.dequeue();
		cola.dequeue();
		assertTrue("No retorna si la cola está vacía", cola.isEmpty());
	}
}