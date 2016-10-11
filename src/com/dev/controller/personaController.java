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

import com.dev.dao.IPersonadao;
import com.dev.dto.Cliente;
import com.dev.dto.Empleado;
import com.dev.dto.Persona;
import com.dev.factory.Factory;
import com.dev.model.clienteModel;
import com.dev.model.personaModel;

/**
 * Servlet implementation class personaController
 */
@WebServlet({ "/newpr", "/insertapr", "/editapr", "/updatepr", "/removepr", "/deletepr", "/readpr", "/listpr", })
public class personaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private personaModel prmodel = null;	
	private String mensaje = null;
	private String destino = "/panelpr.jsp";

	public  personaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		prmodel = new personaModel();	
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newpr")) {
				destino = "createpr.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertpr")) {
				insert(request);
				mensaje = list(request, prmodel);
				destino = "/panelpr.jsp";
				System.out.println("panelpr");

			} else if (path.equals("/editpr")) {
				read(request, prmodel);
				destino = "/updatepr.jsp";
			} else if (path.equals("/updatepr")) {
				update(request);
				mensaje = list(request, prmodel);
				destino = "/panelpr.jsp";

			} else if (path.equals("/removepr")) {
				read(request, prmodel);
				destino = "/deletepr.jsp";
			} else if (path.equals("/deletepr")) {
				delete(request);
				mensaje = list(request, prmodel);
				destino = "/panelpr.jsp";

			} else if (path.equals("/listpr")) {
				mensaje = list(request, prmodel);
				destino = "/panelpr.jsp";
			} else if (path.equals("/readpr")) {
				read(request, prmodel);
				destino = "/readpr.jsp";
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
		Persona p = new Persona();
		p.setNombre(request.getParameter("nombre"));
		
		prmodel.Registrarpersona(p);
		
	}
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Persona per = new Persona();
		String nombre = (request.getParameter("nombre"));
		
		per.setNombre(nombre);	

		prmodel.ActualizarPersona(per);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		prmodel.EliminarPersona(cod);
	}

	protected String list(HttpServletRequest request, personaModel prmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Persona> list = prmodel.Listarpersonas();
		if (list != null) {
			request.setAttribute("lispersonas", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, personaModel prmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Persona per = prmodel.BuscarPersona(cod);
		if (per != null) {
			request.setAttribute("persona", per);
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

