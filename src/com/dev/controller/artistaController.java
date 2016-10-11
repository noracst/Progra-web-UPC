package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.IArtistadao;
import com.dev.dto.Album;
import com.dev.dto.Artista;
import com.dev.dto.Cancion;
import com.dev.dto.Genero;
import com.dev.factory.Factory;
import com.dev.model.albumModel;
import com.dev.model.artistaModel;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.lang.String;


/**
 * Servlet implementation class artistaController
 */
@WebServlet({ "/newr", "/insertar", "/editar", "/updater", "/remover", "/deleter", "/readr", "/listr", })
public class artistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private artistaModel rmodel = null;
	private String mensaje = null;
	private String destino = "/panelr.jsp";
	
	private SecureRandom random = new SecureRandom();

	public artistaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		rmodel = new artistaModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newr")) {
				destino = "creater.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertar")) {
				insert(request);
				mensaje = list(request, rmodel);
				destino = "/panelr.jsp";
				System.out.println("panelr");

			} else if (path.equals("/editar")) {
				read(request, rmodel);
				destino = "/updater.jsp";
			} else if (path.equals("/updater")) {
				update(request);
				mensaje = list(request, rmodel);
				destino = "/panelr.jsp";

			} else if (path.equals("/remover")) {
				read(request, rmodel);
				destino = "/deleter.jsp";
			} else if (path.equals("/deleter")) {
				delete(request);
				mensaje = list(request, rmodel);
				destino = "/panelr.jsp";

			} else if (path.equals("/listr")) {
				mensaje = list(request, rmodel);
				destino = "/panelr.jsp";
			} else if (path.equals("/readr")) {
				read(request, rmodel);
				destino = "/readr.jsp";
			}

			if (mensaje != null) {
				request.setAttribute("mensaje", mensaje);
			} else {
				request.removeAttribute("mensaje");
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}
    
	
	protected void insert(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Artista art = new Artista();
		String cod = new BigInteger(130, random).toString(32).substring(1, 10);
		String nombre = request.getParameter("nombre_artista");
		art.setCod_artista(cod);
		art.setNombre_artista(nombre);
		art.setPais_artista(request.getParameter("pais_artista"));
		
		rmodel.RegistrarArtista(art);
	}
    
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		Artista art = new Artista();
		String cod = request.getParameter("codigo");
		String nombre = request.getParameter("nombre_artista");
		art.setCod_artista(cod);
		art.setNombre_artista(nombre);
		art.setPais_artista(request.getParameter("pais_artista"));

		rmodel.ActualizarArtista(art);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		rmodel.EliminarArtista(cod);
	}

	protected String list(HttpServletRequest request, artistaModel rmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Artista> list = rmodel.ListarArtistas();
		if (list != null) {
			request.setAttribute("listartistas", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, artistaModel rmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Artista art = rmodel.BuscarArtista(cod);
		if (art != null) {
			request.setAttribute("artista", art);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

