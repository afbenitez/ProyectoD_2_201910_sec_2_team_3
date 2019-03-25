package model.data_structures;

import org.junit.Test;

import java.util.ArrayList;



import junit.framework.TestCase;

public class TestHashTableSeparateChaining extends TestCase
{

	public void testSize() {
		ArrayList<Integer> arregloPrueba = new ArrayList();
		arregloPrueba.add(1);
		arregloPrueba.add(2);
		arregloPrueba.add(3);
		arregloPrueba.add(4);
		arregloPrueba.add(5);
		arregloPrueba.add(null);
		assertEquals(5, arregloPrueba.size());
	}

	public void testGetBucketIndex() {

	}

	public void testRemove() {

	}

	public void testGet() {

	}

	public void testAdd() {

	}


}