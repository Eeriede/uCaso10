package Controlador;
import java.util.ArrayList;

import arbol.*;
import common.*;
import common.Nodo;

public class Controlador {
	ArbolNario<Sensor> arbol = new ArbolNario<Sensor>(new Sensor(000,"Salida"));
	SplayTree<Sensor> arbolBusqueda = new SplayTree<Sensor>();
	
	public boolean agregarSensor( int pId, String pCanton) {
		Sensor aAgregar = new Sensor(pId,pCanton);
		if(arbol.buscarElemento(aAgregar) != null) {
			return false;
		}
		arbol.agregarElemento(aAgregar, arbol.getRaiz().getValue());
		arbolBusqueda.insert(aAgregar);
		return true;
	}
	
	public boolean agregarSensor( int pId, String pCanton, int pIdPadre) {
		Sensor aAgregar = new Sensor(pId,pCanton);
		if(arbol.buscarElemento(aAgregar) != null) {
			return false;
		}
		Sensor auxiliar = new Sensor(pIdPadre, "");
		Sensor padreHipotetico = arbol.buscarElemento(auxiliar);
		if(padreHipotetico == null){
			return false;
		}
		arbol.agregarElemento(aAgregar,padreHipotetico);
		arbolBusqueda.insert(aAgregar);
		return true;
	}
	
	public boolean eliminarSensor(int pId) {
		Sensor auxiliar = new Sensor(pId,"");
		Sensor elementoHipotetico = arbol.buscarElemento(auxiliar);
		if(elementoHipotetico == null) {
			return false;
		}
		arbol.eliminarElemento(elementoHipotetico);
		arbolBusqueda.deleteNode(pId);
		return true;
	}
	
	public ArrayList<Sensor> buscarSensor(int pId) {
		ArrayList<Sensor> listaSensores = new ArrayList<Sensor>();
		Nodo<Sensor> nodoEncontrado = arbolBusqueda.searchTree(pId);
		if(nodoEncontrado!=null) {
			Sensor sensor = nodoEncontrado.getValue();
			listaSensores.add(sensor);
			arbol.buscarElemento(sensor);
			arbol.Nodo<Sensor> nodosHijos  = arbol.getAuxiliar();
			listaSensores.add(nodosHijos.getPadre().getValue());
			for(int contador = 0; contador<nodosHijos.getNumeroHijos();contador++) {
				listaSensores.add(nodosHijos.getListaHijos().get(contador).getValue());
			}
			return listaSensores;
		}
		return null;
	}

	public ArbolNario<Sensor> getArbol() {
		return arbol;
	}

	public SplayTree<Sensor> getArbolBusqueda() {
		return arbolBusqueda;
	}	
}
