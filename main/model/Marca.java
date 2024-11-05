package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="marcas")
public class Marca {

    @DatabaseField(id=true, columnName="cod_marca")
    private Integer codigo;
    
    @DatabaseField(canBeNull=false, columnName="nom_marca")
    private String nombre;
    
    public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	Marca() {
    	// all persisted classes must define a no-arg constructor with at least package visibility
    }

	public Marca(int codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
}

