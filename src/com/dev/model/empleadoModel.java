package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IEmpleadodao;
import com.dev.dto.Empleado;
import com.dev.factory.Factory;

public class empleadoModel {
	
	private IEmpleadodao edao =null;
	  
	  public empleadoModel(){
		  edao=Factory.getInstance().getEmpleadodao();
	  }
		
	  
	  public void RegistrarEmpleado(Empleado emp) throws Exception{
		  edao.create(emp);
	  }
	  
	  
	  public void EliminarEmpleado(String emp) throws Exception{
		  edao.delete(emp);
	  }
	  
	  public void ActualizarEmpleado(Empleado emp) throws Exception{
		  edao.update(emp);
	  }
	  
	  public Empleado BuscarEmpleado(String cod) throws Exception{
		  return edao.get(cod);
	  }
	  
	  public List<Empleado> Listarempleado() throws Exception{
		  return edao.getAll();
	  }

}
