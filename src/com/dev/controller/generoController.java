package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.IGenerodao;
import com.dev.dto.Cliente;
import com.dev.dto.Empleado;
import com.dev.dto.Genero;
import com.dev.factory.Factory;
import com.dev.model.clienteModel;
import com.dev.model.generoModel;

/**
 * Servlet implementation class generoController
 */
@WebServlet({ "/newg", "/insertg", "/editag", "/updateg", "/removeg", "/deleteg", "/readg", "/listg", })
public class generoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private generoModel gmodel = null;
	private String mensaje = null;
	private String destino = "/panelg.jsp";
	
	private SecureRandom random = new SecureRandom();

	public generoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		gmodel = new generoModel();	
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newg")) {
				destino = "createg.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertg")) {
				insert(request);
				mensaje = list(request, gmodel);
				destino = "/panelg.jsp";
				System.out.println("panelg");

			} else if (path.equals("/editg")) {
				read(request, gmodel);
				destino = "/updateg.jsp";
			} else if (path.equals("/updateg")) {
				update(request);
				mensaje = list(request, gmodel);
				destino = "/panelg.jsp";

			} else if (path.equals("/removeg")) {
				read(request, gmodel);
				destino = "/deleteg.jsp";
			} else if (path.equals("/deleteg")) {
				delete(request);
				mensaje = list(request, gmodel);
				destino = "/panelg.jsp";

			} else if (path.equals("/listg")) {
				mensaje = list(request, gmodel);
				destino = "/panelg.jsp";
			} else if (path.equals("/readg")) {
				read(request, gmodel);
				destino = "/readg.jsp";
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
		Genero gen = new Genero();
		String cod = new BigInteger(130, random).toString(32).substring(1, 10);
		gen.setCod_genero(cod);
		gen.setNombre_genero(request.getParameter("nombre_genero"));
		
		gmodel.RegistrarGenero(gen);
		
	}
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Genero g = new Genero();
		String cod = (request.getParameter("codigo"));
		String nombre  = (request.getParameter("nombre"));
		g.setCod_genero(cod);
		g.setNombre_genero(nombre);
		gmodel.ActualizarGenero(g);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		gmodel.EliminarGenero(cod);
	}

	protected String list(HttpServletRequest request, generoModel gmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Genero> list =gmodel.Listargenero();
		if (list != null) {
			request.setAttribute("lisgeneros", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, generoModel gmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Genero gen = gmodel.BuscarGenero(cod);
		if (gen != null) {
			request.setAttribute("genero", gen);
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

