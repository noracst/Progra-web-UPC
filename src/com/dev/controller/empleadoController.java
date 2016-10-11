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

import com.dev.dao.IEmpleadodao;
import com.dev.dto.Cancion;
import com.dev.dto.Cliente;
import com.dev.dto.Empleado;

import com.dev.factory.Factory;
import com.dev.model.clienteModel;
import com.dev.model.empleadoModel;

/**
 * Servlet implementation class empleadoController
 */
@WebServlet({ "/newe", "/inserte", "/edite", "/updatee", "/removee", "/deletee", "/reade", "/liste", })
public class empleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private empleadoModel emodel = null;	
	private String mensaje = null;
	private String destino = "/panele.jsp";

	public empleadoController() {
		// TODO Auto-generated constructor stub
	super();
		
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		emodel = new empleadoModel();	
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newe")) {
				destino = "createe.jsp";
				System.out.println("create new");
			} else if (path.equals("/inserte")) {
				insert(request);
				mensaje = list(request, emodel);
				destino = "/panele.jsp";
				System.out.println("panele");

			} else if (path.equals("/edite")) {
				read(request,emodel);
				destino = "/updatee.jsp";
			} else if (path.equals("/updatee")) {
				update(request);
				mensaje = list(request, emodel);
				destino = "/panele.jsp";

			} else if (path.equals("/removee")) {
				read(request, emodel);
				destino = "/deletee.jsp";
			} else if (path.equals("/deletee")) {
				delete(request);
				mensaje = list(request, emodel);
				destino = "/panele.jsp";

			} else if (path.equals("/liste")) {
				mensaje = list(request, emodel);
				destino = "/panele.jsp";
			} else if (path.equals("/reade")) {
				read(request, emodel);
				destino = "/reade.jsp";
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
		Empleado em = new Empleado();
		em.setCod_empleado(request.getParameter("codigo"));
		emodel.RegistrarEmpleado(em);
		
	
	}
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado();
		String cod = (request.getParameter("codigo"));
		String nombre  = (request.getParameter("nombre"));
		emp.setCod_empleado(cod);
		emp.setNombre(nombre);
		
		emodel.ActualizarEmpleado(emp);
		
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		emodel.EliminarEmpleado(cod);
	}

	protected String list(HttpServletRequest request, empleadoModel emodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Empleado> list = emodel.Listarempleado();
		if (list != null) {
			request.setAttribute("lisempleados", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, empleadoModel emodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Empleado emp = emodel.BuscarEmpleado(cod);
		if (emp != null) {
			request.setAttribute("empleado", emp);
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

