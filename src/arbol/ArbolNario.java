package arbol;

public class ArbolNario<T> {
	Nodo<T> raiz;
	Nodo<T> auxiliarBusqueda;
	
	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}
	
	public Nodo<T> getAuxiliar(){
		return this.auxiliarBusqueda;
	}

	public ArbolNario(T pRaiz){
		raiz = new Nodo<T>(pRaiz);
	}
	
	public void agregarElemento(T pElemento, T pPadre) {
		if( raiz == null) {
			raiz = new Nodo<T>(pElemento);
			return;
		}
		if(buscarElementoAux(raiz, pPadre)){
			Nodo<T> aAgregar = new Nodo<T>(pElemento);
			auxiliarBusqueda.agregarHijo(aAgregar);
			return;
		}
	}
	public void eliminarElemento(T pElemento) {
		if(buscarElementoAux(raiz, pElemento)) {
			Nodo<T> nuevoPadre = auxiliarBusqueda.getPadre();
			for(int i = 0; i < auxiliarBusqueda.getNumeroHijos(); i++) {
				Nodo<T> hijoActual = auxiliarBusqueda.getListaHijos().get(i);
				nuevoPadre.agregarHijo(hijoActual);
			}
			nuevoPadre.eliminarHijo(auxiliarBusqueda.getValue());
		}
		
	}
	private boolean buscarElementoAux(Nodo<T> pNodoActual, T pABuscar) {
		if( pNodoActual.getValue().equals(pABuscar)) {
			auxiliarBusqueda = pNodoActual;
			return true;
		}else {
			for(int i = 0; i < pNodoActual.getNumeroHijos(); i++) {
				if(buscarElementoAux(pNodoActual.obtenerHijo(i), pABuscar)) {
					return true;
				}
			}
			return false;
		}
		
	}
	public T buscarElemento(T pElemento) {
		if(buscarElementoAux(raiz,pElemento)) {
			return auxiliarBusqueda.getValue();
		}
		return null;
		
		
	}
}
