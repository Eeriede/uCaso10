package common;

public class Sensor {
	private String ID;
	private String path;
	private int consumoNormal;
	private int capacidadSalida;
	
	public Sensor(String pID, String pPath, int pConsumoNormal, int pCapacidadSalida) {
		setID(pID);
		setPath(pPath);
		setConsumoNormal(pConsumoNormal);
		setCapacidadSalida(pCapacidadSalida);
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String pID) {
		ID = pID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String pPath) {
		this.path = pPath;
	}
	public int getConsumoNormal() {
		return consumoNormal;
	}
	public void setConsumoNormal(int pConsumoNormal) {
		this.consumoNormal = pConsumoNormal;
	}
	public int getCapacidadSalida() {
		return capacidadSalida;
	}
	public void setCapacidadSalida(int pCapacidadSalida) {
		this.capacidadSalida = pCapacidadSalida;
	}
	
	
}
