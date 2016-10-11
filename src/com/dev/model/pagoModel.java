package com.dev.model;

import java.sql.SQLException;
import java.util.List;


import com.dev.dao.IPagodao;
import com.dev.dto.Pago;
import com.dev.factory.Factory;

public class pagoModel {
	
	
	private IPagodao pgdao =null;
	  
	  public pagoModel(){
		  pgdao=Factory.getInstance().getPagodao();
	  }
		
	  
	  public void RegistrarPago(Pago pag) throws Exception{
		  pgdao.create(pag);
	  }
	  
	  
	  public void EliminarPago(String pag) throws Exception{
		  pgdao.delete(pag);
	  }
	  
	  public void ActualizarPago(Pago pag) throws Exception{
		  pgdao.update(pag);
	  }
	  
	  public Pago BuscarPago(String cod) throws Exception{
		  return pgdao.get(cod);
	  }
	  
	  public List<Pago> Listarpagos() throws Exception{
		  return pgdao.getAll();
	  }

}
