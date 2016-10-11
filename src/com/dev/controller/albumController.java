package com.dev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.*;

import com.dev.dto.Album;
import com.dev.dto.Artista;
import com.dev.dto.Cancion;
import com.dev.factory.Factory;
import com.dev.model.albumModel;

/**
 * Servlet implementation class albumController
 */
@WebServlet({ "/newa", "/inserta", "/edita", "/updatea", "/removea", "/deletea", "/reada", "/lista", })
public class albumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private albumModel amodel = null;
	private String mensaje = null;
	private String destino = "/panela.jsp";

	public albumController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		amodel = new albumModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newa")) {
				destino = "createa.jsp";
				System.out.println("create new");
			} else if (path.equals("/inserta")) {
				insert(request);
				mensaje = list(request, amodel);
				destino = "/panela.jsp";
				System.out.println("panela");

			} else if (path.equals("/edita")) {
				read(request, amodel);
				destino = "/updatea.jsp";
			} else if (path.equals("/updatea")) {
				update(request);
				mensaje = list(request, amodel);
				destino = "/panela.jsp";

			} else if (path.equals("/removea")) {
				read(request, amodel);
				destino = "/deletea.jsp";
			} else if (path.equals("/deletea")) {
				delete(request);
				mensaje = list(request, amodel);
				destino = "/panela.jsp";

			} else if (path.equals("/lista")) {
				mensaje = list(request, amodel);	
				destino = "/panela.jsp";
			} else if (path.equals("/reada")) {
				read(request, amodel);
				destino = "/reada.jsp";
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
		Album albm = new Album();
		albm.setCod_album(request.getParameter("codigo"));
		albm.setTitulo(request.getParameter("titulo"));
		amodel.RegistrarAlbum(albm);
	}

	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Album albm = new Album();
		String cod = (request.getParameter("codigo"));
		String titulo = request.getParameter("titulo");
		albm.setCod_album(cod);
		albm.setTitulo(titulo);

		amodel.ActualizarAlbum(albm);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		amodel.EliminarAlbum(cod);
	}

	protected String list(HttpServletRequest request, albumModel amodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Album> list = amodel.ListarAlbumes();
		if (list != null) {
			request.setAttribute("lisalbumes", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, albumModel amodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Album alb = amodel.BuscarAlbum(cod);
		if (alb != null) {
			request.setAttribute("album", alb);
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

