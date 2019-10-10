package common;

public class Sensor {
	private int id;
	private String canton;
	private String barrio;
	private String distrito;
	private int consumoNormal;
	
	public Sensor(int pId, String pCanton) {
		this.id = pId;
		this.canton = pCanton;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public int getConsumoNormal() {
		return consumoNormal;
	}
	public void setConsumoNormal(int consumoNormal) {
		this.consumoNormal = consumoNormal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
