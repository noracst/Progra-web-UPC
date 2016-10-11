package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.ICanciondao;
import com.dev.dto.Cancion;
import com.dev.factory.Factory;

public class cancionModel {
	
	private ICanciondao cdao =null;
	  
	  public cancionModel(){
		  cdao=Factory.getInstance().getCanciondao();
	  }
		
	  
	  public void RegistrarCancion(Cancion can) throws Exception{
		  cdao.create(can);
	  }
	  
	  
	  public void EliminarCancion(String can) throws Exception{
		  cdao.delete(can);
	  }
	  
	  public void ActualizarCancion(Cancion can) throws Exception{
		  cdao.update(can);
	  }
	  
	  public Cancion BuscarCancion(String cod) throws Exception{
		  return cdao.get(cod);
	  }
	  
	  public List<Cancion> Listarcanciones() throws Exception{
		  return cdao.getAll();
	  }
	

}
