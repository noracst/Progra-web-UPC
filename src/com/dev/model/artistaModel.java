package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IArtistadao;
import com.dev.dto.Artista;
import com.dev.dto.Cancion;
import com.dev.factory.Factory;

public class artistaModel {
	
	private IArtistadao rdao =null;
	  
	  public artistaModel(){
		  rdao=Factory.getInstance().getArtistadao();
	  }
		
	  
	  public void RegistrarArtista(Artista art) throws Exception{
		  rdao.create(art);
	  }
	  
	  
	  public void EliminarArtista(String art) throws Exception{
		  rdao.delete(art);
	  }
	  
	  public void ActualizarArtista(Artista art) throws Exception{
		  rdao.update(art);
	  }
	  
	  public Artista BuscarArtista(String cod) throws Exception{
		  return rdao.get(cod);
	  }
	  
	  public List<Artista> ListarArtistas() throws Exception{
		  return rdao.getAll();
	  }

}
