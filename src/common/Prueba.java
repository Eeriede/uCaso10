package common;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplayTree<Sensor> arbol = new SplayTree<Sensor>();
		for(int contador = 0;contador < 10;contador++) {
			arbol.insert(new Sensor(contador, ""+contador));
		}
		for(int contador = 0;contador < 10;contador++) {
			arbol.prettyPrint();
			System.out.println(arbol.searchTree(contador).getValue().getId());
			arbol.prettyPrint();
		}
		
	}

}
