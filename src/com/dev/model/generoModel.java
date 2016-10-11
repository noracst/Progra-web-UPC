package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IGenerodao;
import com.dev.dto.Genero;
import com.dev.factory.Factory;

public class generoModel {

	private IGenerodao gdao =null;
	  
	  public generoModel(){
		  gdao=Factory.getInstance().getGenerodao();
	  }
		
	  
	  public void RegistrarGenero(Genero gen) throws Exception{
		  gdao.create(gen);
	  }
	  
	  
	  public void EliminarGenero(String gen) throws Exception{
		  gdao.delete(gen);
	  }
	  
	  public void ActualizarGenero(Genero gen) throws Exception{
		  gdao.update(gen);
	  }
	  
	  public Genero BuscarGenero(String cod) throws Exception{
		  return gdao.get(cod);
	  }
	  
	  public List<Genero> Listargenero() throws Exception{
		  return gdao.getAll();
	  }
	
}
