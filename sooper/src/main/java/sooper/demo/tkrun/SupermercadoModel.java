package sooper.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import sooper.demo.util.Database;

public class SupermercadoModel {
	
	Database db = new Database();
	private Object idArticulo;

	public List<Object[]> AniadirArticulosPedido(int i) {
		// TODO Auto-generated method stub
		List<Object[]> lista = null; //esta lista es el resultado que le va a pasar al controlador como resultado de la consulta
									// a la base de datos
		
		String sql = "SELECT * FROM ARTICULOPEDIDO WHERE IDPEDIDO = ?"; //crear el string que voy a ejecutar en la base de datos
		
		lista = db.executeQueryArray(sql, i);
		
		return lista;
		
	}

	public void embolsaArticulo() {
		
		List<Object[]> lista = null;
		
		lista = new ArrayList<Object[]>();
		
		lista = db.executeQueryArray("SELECT * FROM ARTICULOPEDIDO WHERE IDPEDIDO = ?", 1);
	//kdjjf
		
		
		//String sql = "UPDATE     //ariticuloPedido     SET  //embolsado   =     WERE idArticulo  = //?  "
		String sql = "UPDATE articuloPedido SET embolsado = WERE idArticulo = ?";
		// Que quiero pasar
		
		
		db.executeUpdate(sql, 1, idArticulo);
	
	}

	public void embolsarArticulo(String interger, Object parseidArticulo) {
		// TODO Auto-generated method stub
		
	}

	public void mbolsarArticulo(int int1) {
		// TODO Auto-generated method stub
		
	}
	
}
