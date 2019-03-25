package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterador<T> implements Iterator<T>
{
	T[] actual; 
	
	int i; 

	public Iterador(T[] pIterador)
	{
		actual = pIterador; 
		i = 0; 
	}

	@Override
	public boolean hasNext() 
	{
		return actual[i+1] != null;
	}

	@Override
	public T next() throws NoSuchElementException
	{
		T siguiente = actual[i++];
		return siguiente; 
	}

	public void remove()
	{ }
}