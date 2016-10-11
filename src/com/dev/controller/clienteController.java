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

import com.dev.dao.IClientedao;
import com.dev.dto.Cancion;
import com.dev.dto.Cliente;

import com.dev.factory.Factory;
import com.dev.model.cancionModel;
import com.dev.model.clienteModel;
import com.dev.model.generoModel;

/**
 * Servlet implementation class clienteController
 */
@WebServlet({ "/newcl", "/insertacl", "/editacl", "/updatecl", "/removecl", "/deletecl", "/readcl", "/listcl", })
public class clienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private clienteModel clmodel = null;	
	private String mensaje = null;
	private String destino = "/panelcl.jsp";

	public clienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		clmodel = new clienteModel();	
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newcl")) {
				destino = "createcl.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertcl")) {
				insert(request);
				mensaje = list(request, clmodel);
				destino = "/panelcl.jsp";
				System.out.println("panelcl");

			} else if (path.equals("/editcl")) {
				read(request, clmodel);
				destino = "/updatecl.jsp";
			} else if (path.equals("/updatecl")) {
				update(request);
				mensaje = list(request, clmodel);
				destino = "/panelcl.jsp";

			} else if (path.equals("/removecl")) {
				read(request, clmodel);
				destino = "/deletecl.jsp";
			} else if (path.equals("/deletecl")) {
				delete(request);
				mensaje = list(request, clmodel);
				destino = "/panelcl.jsp";

			} else if (path.equals("/listcl")) {
				mensaje = list(request, clmodel);
				destino = "/panelcl.jsp";
			} else if (path.equals("/readcl")) {
				read(request, clmodel);
				destino = "/readcl.jsp";
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
		Cliente clien = new Cliente();
		clien.setCod_cliente(request.getParameter("codigo"));
		
		clmodel.RegistrarCliente(clien);
		
		
	}

	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Cliente clien = new Cliente();
		String cod = (request.getParameter("codigo"));
		String nombre  = (request.getParameter("nombre"));
		clien.setCod_cliente(cod);
		clien.setNombre(nombre);	

		clmodel.ActualizarCliente(clien);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		clmodel.EliminarCliente(cod);
	}

	protected String list(HttpServletRequest request, clienteModel clmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Cliente> list = clmodel.Listarclientes();
		if (list != null) {
			request.setAttribute("lisclientes", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, clienteModel clmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Cliente clien = clmodel.BuscarCliente(cod);
		if (clien != null) {
			request.setAttribute("cliente", clien);
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

