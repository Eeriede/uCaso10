package common;

public class Nodo<E> {
	private E data;
	Nodo<E> parent;
	Nodo<E> left;
	Nodo<E> right;
	int key;

	public Nodo(E pValor) {
		this.data = pValor;
		Sensor sensor = (Sensor)pValor;
		this.key = sensor.getId();
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public E getValue() {
		return data;
	}

	public Nodo<E> getParent() {
		return parent;
	}

	public void setParent(Nodo<E> parent) {
		this.parent = parent;
	}

	public Nodo<E> getLeft() {
		return left;
	}

	public void setLeft(Nodo<E> left) {
		this.left = left;
	}

	public Nodo<E> getRight() {
		return right;
	}

	public void setRight(Nodo<E> right) {
		this.right = right;
	}
}