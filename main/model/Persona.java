package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="personas")
public class Persona {
    @DatabaseField(id=true)
    private String nif;
    @DatabaseField(canBeNull=false, columnName="Apellido1")
    private String apellido1;
    @DatabaseField(canBeNull=false, columnName="Apellido2")
    private String apellido2;
    @DatabaseField(canBeNull=false)
    private String nombre;
    @DatabaseField(canBeNull=false)
    private String calle;
    @DatabaseField(canBeNull=false)
    private Integer numero;
    @DatabaseField(canBeNull=false)
    private Integer piso;
    @DatabaseField()
    private String letra;
    @DatabaseField(canBeNull=false, columnName="cod_postal")
    private Integer codigoPostal;
    @DatabaseField()
    private String municipio;
    @DatabaseField(canBeNull=false, columnName="cod_prov")
    private Integer codigoProvincia;
	@ForeignCollectionField()
	ForeignCollection<Sancion> sanciones;
    
	public ForeignCollection<Sancion> getSanciones(){
		return sanciones;
	}	

    public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Integer getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(Integer codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	Persona() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }
    public Persona(String name) {
    	this.nombre = name;
    }
}

