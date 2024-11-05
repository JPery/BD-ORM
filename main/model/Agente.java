package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="agentes")
public class Agente {
    @DatabaseField(id=true, columnName="num_agente")
    private Integer numero;

    @DatabaseField(canBeNull=false, foreign=true, columnName="nif", foreignColumnName="nif")
    private Persona persona;
    
    @DatabaseField(canBeNull=false)
    private Integer unidad;
    

	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numAgente) {
		this.numero = numAgente;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Integer getUnidad() {
		return unidad;
	}


	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}


	Agente() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }
}

