package com.dev.model;

import java.sql.SQLException;
import java.util.List;


import com.dev.dao.IPersonadao;
import com.dev.dto.Empleado;
import com.dev.dto.Persona;
import com.dev.factory.Factory;

public class personaModel {
	
	private IPersonadao prdao =null;
	  
	  public personaModel(){
		  prdao=Factory.getInstance().getPersonadao();
	  }
		
	  
	  public void Registrarpersona(Persona per) throws Exception{
		  prdao.create(per);
	  }
	  
	  
	  public void EliminarPersona(String per) throws Exception{
		  prdao.delete(per);
	  }
	  
	  public void ActualizarPersona(Persona per) throws Exception{
		  prdao.update(per);
	  }
	  
	  public Persona BuscarPersona(String cod) throws Exception{
		  return prdao.get(cod);
	  }
	  
	  public List<Persona> Listarpersonas() throws Exception{
		  return prdao.getAll();
	  }

}
