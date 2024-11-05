import java.sql.*;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import model.Marca;
import model.Modelo;
import model.Persona;
import model.Sancion;
import model.Vehiculo;
import utils.InputUtils;

public class ClienteSQLiteORMMenu {
	private ConnectionSource connectionSource;
	private final static String DATABASE_PATH = "DGTORM.db";

	public boolean conectar() {
		try {
		    // Creación de la conexión a la BD
			connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + DATABASE_PATH);
			return true;
		} catch (SQLException e) {
		    // Error. No se ha podido conectar a la BD
			e.printStackTrace();
			return false;
		}
	}
	
	public void getVehiculos(){
		try {
			Dao<Vehiculo, String> vehiculoDao = DaoManager.createDao(connectionSource, Vehiculo.class);
			List<Vehiculo> results =  vehiculoDao.queryBuilder().orderBy("matricula", true).query();
			// Podemos retornar la lista de vehículos aquí se fuese necesario
			if (results.size() > 0) {
				System.out.println("Vehículos en la base de datos");
				for (int i = 0; i < results.size(); i++){
					Vehiculo v = results.get(i);
					System.out.println((i+1) + ". " + v.getModelo().getMarca().getNombre() + " " + v.getModelo().getNombre() + ": " + v.getMatricula());
				}
			}
			else {
				System.out.println("No hay vehículos en la base de datos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getPropietarioVehiculo(String matricula) {
		try {
			Dao<Vehiculo, String> vehiculoDao = DaoManager.createDao(connectionSource, Vehiculo.class);
			Vehiculo vehiculo = vehiculoDao.queryForId(matricula);
			Persona persona = null;
			if (vehiculo != null)
				persona = vehiculo.getPropietario();
			// Podemos retornar la Persona aquí se fuese necesario
			if (persona != null) {
				System.out.println("El propietario del vehículo con matrícula \"" + matricula + "\" es: " + persona.getNombre() + " " + persona.getApellido1() + " " + persona.getApellido2() + " - " + persona.getNif());
			}
			else {
				System.out.println("No se encontraron vehiculas con matrícula \"" + matricula+ "\"");
			}
		} catch (SQLException e) {
			// Se ejecuta si hay algún error en la consulta
			e.printStackTrace();
		}
	}
	
	public void getPersonasByApellido(String apellido) {
		try {
			Dao<Persona, String> personaDao = DaoManager.createDao(connectionSource, Persona.class);
			List<Persona> results = personaDao.queryBuilder().where().like("apellido1", "%" + apellido + "%").or().like("apellido2", "%" + apellido + "%").query();
			// Podemos retornar la lista de Personas aquí se fuese necesario
			if (results.size() > 0) {
				System.out.println("Personas encontradas:");
				for (int i = 0; i < results.size(); i++){
					Persona p = results.get(i);
					System.out.println((i+1) + ". " + p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2() + " - " + p.getNif());
				}
			}
			else {
				System.out.println("No se encontraron personas con el apellido: \"" + apellido +"\"");
			}
		} catch (SQLException e) {
			// Se ejecuta si hay algún error en la consulta
			e.printStackTrace();
		}
	}

	public void getArticulos(){
		// TODO: Mostrar los distintos artículos de las sanciones ordenados de forma ascendente
	}

	public void getSancionesByNif(String nif) {
		// TODO: Buscar las sanciones donde infractor = nif. Mostrar fecha, artículo e importe
	}	
	
	public void getVehiculosByArticuloSancion(String articulo){
		// TODO: Obtener las sanciones cuyo artículo = articulo. Mostrar el expediente de la sanción, la marca, el modelo y la matrícula del vehículo
	}

	public void getSancionesByMarca(String marca){
		// TODO: Buscar las sanciones cuya marca de vehículo = marca. Mostrar nombre, apellido1, apellido2 del propietario así como la matrícula del vehículo, la fecha y el importe de la sanciíon
	}


	public void deleteSancion(String expediente){
		// TODO: Ejecutar consulta y mostrar el número de filas afectadas (debería ser 1 si la sanción fue eliminada o 0 si el expediente no existe)
	}

	public void insertModelo(String marca, String modelo, int potencia){
		// TODO: Obtener el id de la marca si existe o crearla si no existe. Pista: el nuevo cod_marca debería ser max(cod_marca) + 1 of marcas
		
		// TODO: Insertar nuevo modelo con cod_marca, nom_modelo y potencia. Pista: el nuevo cod_modelo debería ser max(cod_modelo) + 1 of modelos

	}

	public static void main(String[] args) {
		ClienteSQLiteORMMenu cliente = new ClienteSQLiteORMMenu();
		// Realizar la conexión a la Base de Datos
		if (!cliente.conectar()) {
			System.out.println("Error: Conexion no realizada.");
			System.exit(-1);
		}
		else
			System.out.println("Conectado a la base de datos.");
		boolean exit = false;
		do 
		{	
			int option = InputUtils.menu();
			switch (option) {
				case 1:
					// Listar  vehículos
					cliente.getVehiculos();
					break;
				case 2: 
					// Buscar propietario de vehículo por matrícula
					String matriculaABuscar = InputUtils.readInput("Introduce una matrícula para buscar");
					cliente.getPropietarioVehiculo(matriculaABuscar);
					break;
				case 3:
					// Buscar persona por apellido
					String apellidoABuscar = InputUtils.readInput("Introduce un apellido para buscar");
					cliente.getPersonasByApellido(apellidoABuscar);
					break;
				case 4:
					// Listar los diferentes artículos de las sanciones
					cliente.getArticulos();
					break;
				case 5:
					// Listar sanciones por nif
					String nifABuscar = InputUtils.readInput("Introduce un nif para buscar");
					cliente.getSancionesByNif(nifABuscar);
					break;
				case 6:
					// Buscar vechículos por artículo de la sanción
					String articulo = InputUtils.readInput("Introduce un artículo para buscar");
					cliente.getVehiculosByArticuloSancion(articulo);
					break;
				case 7:
					// Buscar las sanciones para una marca de vehículo
					String marca = InputUtils.readInput("Introduce una marca para buscar").toUpperCase();
					cliente.getSancionesByMarca(marca);
					break;
				case 8:
					// Eliminar una sanción
					String expediente = InputUtils.readInput("Introduce un expediente para eliminar");
					cliente.deleteSancion(expediente);
					break;
				case 9:
					// Añadir modelo de vehículo
					String nombreMarca = InputUtils.readInput("Introduce el nombre de la marca").toUpperCase();
					String nombreModelo = InputUtils.readInput("Introduce el nombre del modelo");
					int potencia = -1;
					boolean potenciaValida = false;
					do{
						String potenciaModelo = InputUtils.readInput("Introduce la potencia del modelo");
						try{
							potencia = Integer.parseInt(potenciaModelo);
							if (potencia > 0 && potencia < 2000)
								potenciaValida = true;
							else
								System.out.println("La potencia debe ser mayor de 0 y menor de 2000 CV");
						}
						catch(NumberFormatException e){
							System.out.println("Potencia no válida");
						}
					}
					while (!potenciaValida);
					cliente.insertModelo(nombreMarca, nombreModelo, potencia);
					break;
				
				default: 
					// Salir
					if (option != 0){
						System.out.println("Función no implementada");
					}
					exit = true;
					break;
			}
		}
		while(!exit);
	}
}