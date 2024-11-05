package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="sanciones")
public class Sancion {
    @DatabaseField(id=true)
    private Integer expediente;
    
    @DatabaseField(canBeNull=false, foreign=true, columnName="infractor", foreignColumnName="nif")
    private Persona infractor;
    
    @DatabaseField(canBeNull=false, foreign=true, columnName="num_agente", foreignColumnName="num_agente")
    private Agente agente;

    @DatabaseField(canBeNull=false)
    private String fecha;

    @DatabaseField(canBeNull=false)
    private String articulo;

    @DatabaseField(canBeNull=false)
    private Float importe;
    
    @DatabaseField(canBeNull=false, foreign=true, columnName="matricula", foreignColumnName="matricula", maxForeignAutoRefreshLevel=3)
    private Vehiculo vehiculo;

    @DatabaseField(canBeNull=false)
    private String via;
    
    @DatabaseField(canBeNull=false)
    private Integer kilometro;

    @DatabaseField(canBeNull=false)
    private String direccion;
    
    @DatabaseField(canBeNull=false)
    private String estado;
    
    
    public Integer getExpediente() {
		return expediente;
	}


	public void setExpediente(Integer expediente) {
		this.expediente = expediente;
	}


	public Persona getInfractor() {
		return infractor;
	}


	public void setInfractor(Persona infractor) {
		this.infractor = infractor;
	}


	public Agente getAgente() {
		return agente;
	}


	public void setAgente(Agente agente) {
		this.agente = agente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getArticulo() {
		return articulo;
	}


	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}


	public Float getImporte() {
		return importe;
	}


	public void setImporte(Float importe) {
		this.importe = importe;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public Integer getKilometro() {
		return kilometro;
	}


	public void setKilometro(Integer kilometro) {
		this.kilometro = kilometro;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	Sancion() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }
}

