package model;

import java.util.Collection;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="vehiculos")
public class Vehiculo {
    @DatabaseField(id=true)
    private String matricula;
    
    @DatabaseField(canBeNull=false, columnName="fec_matriculacion")
    private String fechaMatriculacion;
    
    @DatabaseField(canBeNull=false, foreign=true, columnName="propietario", foreignColumnName="nif")
    private Persona propietario;

    @DatabaseField(canBeNull=false)
    private String bastidor;

    @DatabaseField(canBeNull=false, foreign=true, columnName="cod_modelo", foreignColumnName="cod_modelo")
    private Modelo modelo;

	@ForeignCollectionField()
	ForeignCollection<Sancion> sanciones;
    
        
    public Collection<Sancion> geSanciones() {
		return sanciones;
	}

    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getFechaMatriculacion() {
		return fechaMatriculacion;
	}



	public void setFechaMatriculacion(String fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}



	public Persona getPropietario() {
		return propietario;
	}



	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}



	public String getBastidor() {
		return bastidor;
	}



	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}



	public Modelo getModelo() {
		return modelo;
	}



	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}



	Vehiculo() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }
}

