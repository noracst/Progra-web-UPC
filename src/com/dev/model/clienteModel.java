package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IClientedao;
import com.dev.dto.Cliente;
import com.dev.factory.Factory;

public class clienteModel {
	
	private IClientedao cldao =null;
	  
	  public clienteModel() {
		// TODO Auto-generated constructor stub
		  cldao=Factory.getInstance().getClientedao();
	  }
		
	  
	  public void RegistrarCliente(Cliente clien) throws Exception{
		  cldao.create(clien);
	  }
	  
	  
	  public void EliminarCliente(String clien) throws Exception{
		  cldao.get(clien);
	  }
	  
	  public void ActualizarCliente(Cliente clien) throws Exception{
		  cldao.update(clien);
	  }
	  
	  public Cliente BuscarCliente(String cod) throws Exception{
		  return cldao.get(cod);
	  }
	  
	  public List<Cliente> Listarclientes() throws Exception{
		  return cldao.getAll();
	  }

}
