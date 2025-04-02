package sooper.demo.tkrun;

import java.util.List;
import java.util.Objects;



public class SupermercadoController {

	private static final String Interger = null;
	private SupermercadoModel model;
	private SupermercadoView view;
	private Object parseidArticulo;
	
		
	public void setVistaModel( SupermercadoView v , SupermercadoModel m) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.view.getFrame().setVisible(true);
	}
	
	//a partir de aqui, implementamos los metodos de las funcionalidades correspondientes
	
	public void AniadirArticulosPedido(int i) {
		//metodo para rellenar la tabla de articulos y pedidos
		int j;
		List<Object[]> lista=model.AniadirArticulosPedido(i);
		//una vez que me devuelva el modelo el resultado de la consulta, analizo la lista devuelta:
		
		for (j=0; j<lista.size();j++) {
			view.rellenaListaArticulos(lista.get(j));
		}
		
	};
	

	public SupermercadoView getView() {
		return view;
	}

	public void setView(SupermercadoView view) {
		this.view = view;
	}

	public SupermercadoModel getModel() {
		return model;
	}

	public void setModel(SupermercadoModel model) {
		this.model = model;
	}

	public void embolsarArticulos() {
		// TODO Auto-generated method stub
		model.embolsaArticulo();
		
		String idArticulo;		// get coger  // set poner
		
		idArticulo = this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(),0).toString(); // Este valor es variable, inidcar la fila deseada
		
		this.model.mbolsarArticulo(Integer.parseInt(idArticulo));
		
		//añado desde aquí 02-04-25
		this.view.getModelArticulo().removeRow(this.view.getTable().getSelectedRow()); //con esto se elimina la fila
		
		Objects[] fila = null;
		
		this.view.getModeloListaEmbolsados().setValueAt(fila, 0, 0); //aquí añado fila
		//para sacar el numero de fila
		
		
		int numeroFila = this.view.getModeloListaEmbolsados().getRowCount();
		
		//String componente = view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString();
		
		this.view.getModeloListaEmbolsados().setValueAt(idArticulo, numeroFila -1, 0); // (idArticulo,numeroFila-2,0)	
		this.view.getModeloListaEmbolsados().setValueAt("999",numeroFila -1,1);
		
	}
}
