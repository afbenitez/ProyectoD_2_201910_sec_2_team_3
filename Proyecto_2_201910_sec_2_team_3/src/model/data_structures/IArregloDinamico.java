package model.data_structures;

public interface IArregloDinamico<T> 
{

	/**
	 * Retornar el elemento en la posición i.
	 * @param i posicion del elemento.
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T darElemento( int i );

	/**
	 * Retornar el numero de elementos en el arreglo.
	 * @return el tamaño del arreglo.
	 */
	int darTamanio( );
	
	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) .
	 * @param pDato nuevo elemento.
	 */
	public void agregar( Object pDato );

}
