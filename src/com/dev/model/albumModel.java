package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.*;
import com.dev.dao.IAlbumdao;
import com.dev.dto.Album;
import com.dev.factory.Factory;


public class albumModel {
	
		private IAlbumdao adao =null;
	  
	  public albumModel(){
		  adao=Factory.getInstance().getAlbumdao();
	  }
		
	  
	  public void RegistrarAlbum(Album alb) throws Exception{
		  adao.create(alb);
	  }
	  
	  
	  public void EliminarAlbum(String alb) throws Exception{
		  adao.get(alb);
	  }
	  
	  public void ActualizarAlbum(Album alb) throws Exception{
		  adao.update(alb);
	  }
	  
	  public Album BuscarAlbum(String cod) throws Exception{
		  return adao.get(cod);
	  }
	  
	  public List<Album> ListarAlbumes() throws Exception{
		  return adao.getAll();
	  }

}
