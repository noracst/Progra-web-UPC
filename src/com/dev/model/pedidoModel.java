package com.dev.model;

import java.sql.SQLException;
import java.util.List;


import com.dev.dao.IPedidodao;
import com.dev.dto.Pedido;
import com.dev.factory.Factory;

public class pedidoModel {

	private IPedidodao pedao =null;
	  
	  public pedidoModel(){
		  pedao=Factory.getInstance().getPedidodao();
	  }
		
	  
	  public void RegistrarPedido(Pedido ped) throws Exception{
		  pedao.create(ped);
	  }
	  
	  
	  public void EliminarPedido(String ped) throws Exception{
		  pedao.delete(ped);
	  }
	  
	  public void ActualizarPedido(Pedido ped) throws Exception{
		  pedao.update(ped);
	  }
	  
	  public Pedido BuscarPedido(String cod) throws Exception{
		  return pedao.get(cod);
	  }
	  
	  public List<Pedido> Listarpedido() throws Exception{
		  return pedao.getAll();
	  }
	
}
