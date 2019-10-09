package common;

public class SplayTree<E> {
	private Nodo<E> root;

	public SplayTree() {
		root = null;
	}

	private void printHelper(Nodo<E> currPtr, String indent, boolean last) {
		// ayuda a imprimir la estructura en pantalla 
	   	if (currPtr != null) {
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R----");
		      indent += "     ";
		   } else {
		      System.out.print("L----");
		      indent += "|    ";
		   }

		   System.out.println(currPtr.key);

		   printHelper(currPtr.left, indent, false);
		   printHelper(currPtr.right, indent, true);
		}
	}

	private Nodo<E> searchTreeHelper(Nodo<E> node, int key) {
		if (node == null || key == node.key) {
			return node;
		}

		if (key < node.key) {
			return searchTreeHelper(node.left, key);
		} 
		return searchTreeHelper(node.right, key);
	}

	private void deleteNodeHelper(Nodo<E> node, int key) {
		Nodo<E> x = null;
		Nodo<E> t = null; 
		Nodo<E> s = null;
		while (node != null){
			if (node.key == key) {
				x = node;
			}

			if (node.key <= key) {
				node = node.right;
			} else {
				node = node.left;
			}
		}

		if (x == null) {
			System.out.println("Couldn't find key in the tree");
			return;
		}
		// 
		splay(x);
		if (x.right != null) {
			t = x.right;
			t.parent = null;
		} else {
			t = null;
		}
		s = x;
		s.right = null;
		x = null;

		// llama a join
		if (s.left != null){ // borra x
			s.left.parent = null;
		}
		root = join(s.left, t);
		s = null;
	}

	// rotacion izquierda
	private void leftRotate(Nodo<E> x) {
		Nodo<E> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	// rotacion derecha
	private void rightRotate(Nodo<E> x) {
		Nodo<E> y = x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	// operacion splay, lleva a X a la raiz
	private void splay(Nodo<E> x) {
		while (x.parent != null) {
			if (x.parent.parent == null) {
				if (x == x.parent.left) {
					//derecha
					rightRotate(x.parent);
				} else {
					//izquierda
					leftRotate(x.parent);
				}
			} else if (x == x.parent.left && x.parent == x.parent.parent.left) {
				// derecha-derecha
				rightRotate(x.parent.parent);
				rightRotate(x.parent);
			} else if (x == x.parent.right && x.parent == x.parent.parent.right) {
				// izquierda-izquierda
				leftRotate(x.parent.parent);
				leftRotate(x.parent);
			} else if (x == x.parent.right && x.parent == x.parent.parent.left) {
				// izquierda-derecha
				leftRotate(x.parent);
				rightRotate(x.parent);
			} else {
				// derecha-izquierda
				rightRotate(x.parent);
				leftRotate(x.parent);
			}
		}
	}

	// une dos arboles
	private Nodo<E> join(Nodo<E> nodo1, Nodo<E> nodo2){
		if (nodo1 == null) {
			return nodo2;
		}

		if (nodo2 == null) {
			return nodo1;
		}
		Nodo<E> maximo = maximum(nodo1);
		splay(maximo);
		maximo.right = nodo2;
		nodo2.parent = maximo;
		return maximo;
	}


	private void preOrderHelper(Nodo<E> pNodo) {
		if (pNodo != null) {
			System.out.print(pNodo.key + " ");
			preOrderHelper(pNodo.left);
			preOrderHelper(pNodo.right);
		} 
	}

	private void inOrderHelper(Nodo<E> pNodo) {
		if (pNodo != null) {
			inOrderHelper(pNodo.left);
			System.out.print(pNodo.key + " ");
			inOrderHelper(pNodo.right);
		} 
	}

	private void postOrderHelper(Nodo<E> pNodo) {
		if (pNodo != null) {
			postOrderHelper(pNodo.left);
			postOrderHelper(pNodo.right);
			System.out.print(pNodo.key + " ");
		} 
	}

	// Pre-Orden
	// raiz - izquierda -derecha
	public void preorder() {
		preOrderHelper(this.root);
	}

	// In-Orden
	// izquierda - raiz - derecha
	public void inorder() {
		inOrderHelper(this.root);
	}

	// Post-Orden
	// izquierda - derecha - raiz
	public void postorder() {
		postOrderHelper(this.root);
	}

	// busca el nodo con la llave ingresada
	// retorna el nodo
	public Nodo<E> searchTree(String pKey) {
		int key = pKey.hashCode();
		Nodo<E> nodo = searchTreeHelper(root, key);
		if (nodo != null) {
			splay(nodo);
		}
		return nodo;
	}

	// encuentra el nodo con la llave mas pequena
	public Nodo<E> minimum(Nodo<E> pNodo) {
		while (pNodo.left != null) {
			pNodo = pNodo.left;
		}
		return pNodo;
	}

	// encuentra el nodo con la llave mas grande
	public Nodo<E> maximum(Nodo<E> pNodo) {
		while (pNodo.right != null) {
			pNodo = pNodo.right;
		}
		return pNodo;
	}

	// encuentra un sucesor de un nodo
	public Nodo<E> successor(Nodo<E> pNodo) {
		// si el lado derecho no es nulo,
		// el sucesor es el menor de este lado
		if (pNodo.right != null) {
			return minimum(pNodo.right);
		}
		Nodo<E> nodoPadre = pNodo.parent;
		while (nodoPadre != null && pNodo == nodoPadre.right) {
			pNodo = nodoPadre;
			nodoPadre = nodoPadre.parent;
		}
		return nodoPadre;
	}

	// encuentra un predecesor de un nodo
	public Nodo<E> predecessor(Nodo<E> pNodo) {
		// si el lado izquierdo no es nulo,
		// el predecesor es el mayor de este lado 
		if (pNodo.left != null) {
			return maximum(pNodo.left);
		}

		Nodo<E> nodoPadre = pNodo.parent;
		while (nodoPadre != null && pNodo == nodoPadre.left) {
			pNodo = nodoPadre;
			nodoPadre = nodoPadre.parent;
		}

		return nodoPadre;
	}

	// inserta una elemento
	public void insert(E key) {
		Nodo<E> node = new Nodo<E>(key);
		Nodo<E> nodoPadre = null;
		Nodo<E> nodoComparado = this.root;

		while (nodoComparado != null) {
			nodoPadre = nodoComparado;
			if (node.key < nodoComparado.key) {
				nodoComparado = nodoComparado.left;
			} else {
				nodoComparado = nodoComparado.right;
			}
		}

		// y es padre de x
		node.parent = nodoPadre;
		if (nodoPadre == null) {
			root = node;
		} else if (node.key < nodoPadre.key) {
			nodoPadre.left = node;
		} else {
			nodoPadre.right = node;
		}

		// hace splay de node
		splay(node);
	}

	// borra nodo
	void deleteNode(String pNombre) {
		int data = pNombre.hashCode();
		deleteNodeHelper(this.root, data);
	}

	// imprime el arbol
	public void prettyPrint() {
		printHelper(this.root, "", true);
	}
}