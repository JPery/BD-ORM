package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="modelos")
public class Modelo {

    @DatabaseField(id=true, columnName="cod_modelo")
    private Integer codigo;
    
    @DatabaseField(canBeNull=false, foreign=true, columnName="cod_marca", foreignColumnName="cod_marca")
    private Marca marca;
    
    @DatabaseField(canBeNull=false, columnName="nom_modelo")
    private String nombre;
    
    @DatabaseField(canBeNull=false)
    private Integer potencia;

    public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	Modelo() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }

	public Modelo(int codigo, String nombre, Marca marca, int potencia){
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.potencia = potencia;
	}
}

