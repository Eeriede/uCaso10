package arbol;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolNario<String> arbol = new ArbolNario<String>("raiz");
		arbol.agregarElemento("1", "raiz");
		arbol.agregarElemento("2", "raiz");
		arbol.agregarElemento("1.1", "1");
		System.out.println(arbol.buscarElemento("1.1"));
		arbol.eliminarElemento("1");
		System.out.println(arbol.buscarElemento("1.1"));
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("hola");
		lista.add("adios");
		lista.remove(0);
		System.out.println(lista.get(0));
	}

}
