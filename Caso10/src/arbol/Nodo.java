package arbol;

import java.util.ArrayList;

public class Nodo<T> {
	private Nodo<T> padre;
	private ArrayList<Nodo<T>> listaHijos;
	private T value;
	private int numeroHijos;
	
	public Nodo<T> getPadre() {
		return padre;
	}

	public void setPadre(Nodo<T> padre) {
		this.padre = padre;
	}

	public ArrayList<Nodo<T>> getListaHijos() {
		return listaHijos;
	}

	public void setListaHijos(ArrayList<Nodo<T>> listaHijos) {
		this.listaHijos = listaHijos;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public Nodo(T pValue, Nodo<T> pPadre) {
		this.padre = pPadre;
		this.value = pValue;
		this.listaHijos = new ArrayList<Nodo<T>>();
	}
	
	public Nodo(T pValue) {
		this.value = pValue;
		this.listaHijos = new ArrayList<Nodo<T>>();
	}
	
	public void agregarHijo(Nodo<T> pAdd) {
		pAdd.setPadre(this);
		listaHijos.add(pAdd);
		numeroHijos ++;
	}
	public Nodo<T> obtenerHijo(int pIndice) {
		return listaHijos.get(pIndice);
	}
	public void eliminarHijo(T pDel) {
		if(numeroHijos == 0) {
			return;
		}
		for(int i = 0; i < numeroHijos; i++) {
			if(listaHijos.get(i).getValue().equals(pDel)){
				listaHijos.remove(i);
				numeroHijos --;
				return;
			}
		}
	}
	
}
