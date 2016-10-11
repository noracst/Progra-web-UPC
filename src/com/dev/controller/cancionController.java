package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.*;
import com.dev.dao.ICanciondao;
import com.dev.dto.Artista;
import com.dev.dto.Cancion;
import com.dev.dto.Genero;
import com.dev.dto.Pedido;
import com.dev.factory.Factory;
import com.dev.model.artistaModel;
import com.dev.model.cancionModel;
import com.dev.model.generoModel;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.lang.String;


/**
 * Servlet implementation class cancionController
 */
@WebServlet({ "/newc", "/insertac", "/editac", "/updatec", "/removec", "/deletec", "/readc", "/listc", })
public class cancionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private cancionModel cmodel = null;
	private generoModel gmodel = null;
	private String mensaje = null;
	private String destino = "/panelc.jsp";

	private SecureRandom random = new SecureRandom();
	
	public cancionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel = new cancionModel();
		gmodel = new generoModel();
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newc")) {
				destino = "createc.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertc")) {
				insert(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";
				System.out.println("panelc");

			} else if (path.equals("/editc")) {
				read(request, cmodel);
				destino = "/updatec.jsp";
			} else if (path.equals("/updatec")) {
				update(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";

			} else if (path.equals("/removec")) {
				read(request, cmodel);
				destino = "/deletec.jsp";
			} else if (path.equals("/deletec")) {
				delete(request);
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";

			} else if (path.equals("/listc")) {
				mensaje = list(request, cmodel);
				destino = "/panelc.jsp";
			} else if (path.equals("/readc")) {
				read(request, cmodel);
				destino = "/readc.jsp";
			}

			if (mensaje != null) {
				request.setAttribute("mensaje", mensaje);
			} else {
				request.removeAttribute("mensaje");
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}
    
    
	private void insert(HttpServletRequest request)throws Exception {
		// TODO Auto-generated method stub
		Cancion can = new Cancion();
		Genero gen = new Genero();
		String cod = new BigInteger(139,random).toString(32).substring(1, 10);
		can.setCod_cancion(cod);
		can.setNombre_cancion(request.getParameter("nombre_cancion"));
		can.setPrecio_cancion(Float.parseFloat(request.getParameter("precio_cancion")));
		can.setDuracion_cancion(Float.parseFloat(request.getParameter("duracion_cancion")));
		gen.setCod_genero(request.getParameter("cod_genero"));
		can.setGen(gen);
		
		cmodel.RegistrarCancion(can);
		
	}


	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Cancion can = new Cancion();
		String cod = (request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		can.setCod_cancion(cod);
		can.setNombre_cancion(nombre);
		

		cmodel.ActualizarCancion(can);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		cmodel.EliminarCancion(cod);
	}

	protected String list(HttpServletRequest request, cancionModel cmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Cancion> list = cmodel.Listarcanciones();
		if (list != null) {
			request.setAttribute("liscanciones", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, cancionModel cmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Cancion can = cmodel.BuscarCancion(cod);
		if (can != null) {
			request.setAttribute("cancion", can);
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

