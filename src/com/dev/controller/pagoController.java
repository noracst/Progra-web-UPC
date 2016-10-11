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


import com.dev.dao.IPagodao;
import com.dev.dto.Pedido;
import com.dev.dto.Empleado;
import com.dev.dto.Genero;
import com.dev.dto.Pago;
import com.dev.factory.Factory;
import com.dev.model.generoModel;
import com.dev.model.pagoModel;
import com.dev.model.pedidoModel;

@WebServlet({ "/newp", "/insertap", "/editap", "/updatep", "/removep", "/deletep", "/readp", "/listp", })
public class pagoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private pagoModel pmodel = null;
	private pedidoModel pdmodel = null;
	private String mensaje = null;
	private String destino = "/panelp.jsp";

	public pagoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		pmodel = new pagoModel();	
		pdmodel = new pedidoModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {

			if (path.equals("/newp")) {
				destino = "createp.jsp";
				System.out.println("create new");
			} else if (path.equals("/insertp")) {
				insert(request);
				mensaje = list(request, pmodel);
				destino = "/panelp.jsp";
				System.out.println("panelp");

			} else if (path.equals("/editp")) {
				read(request,pmodel);
				destino = "/updatep.jsp";
			} else if (path.equals("/updatep")) {
				update(request);
				mensaje = list(request, pmodel);
				destino = "/panelp.jsp";

			} else if (path.equals("/removep")) {
				read(request, pmodel);
				destino = "/deletep.jsp";
			} else if (path.equals("/deletep")) {
				delete(request);
				mensaje = list(request, pmodel);
				destino = "/panelp.jsp";

			} else if (path.equals("/listp")) {
				mensaje = list(request, pmodel);
				destino = "/panelp.jsp";
			} else if (path.equals("/readp")) {
				read(request, pmodel);
				destino = "/readp.jsp";
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
		Pago p = new Pago();
		Pedido pd = new Pedido();
		p.setCod_pago(request.getParameter("codigo"));
		pd.setCod_pedido(request.getParameter("cod_pedido"));
		p.setPed(pd);
	
		pmodel.RegistrarPago(p);
	}
	
	protected void update(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Pago p = new Pago();
		Pedido pd = new Pedido();
		String cod = (request.getParameter("codigo"));
		String cod_pedido = (request.getParameter("cod_pedido"));
		p.setCod_pago(cod);
		pd.setCod_pedido(cod_pedido);
		p.setPed(pd);
		
		pmodel.ActualizarPago(p);
	}

	protected void delete(HttpServletRequest request) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String cod = (request.getParameter("codigo"));

		pmodel.EliminarPago(cod);
	}

	protected String list(HttpServletRequest request, pagoModel pmodel)
			throws Exception {
		// TODO Auto-generated method stub
		String error = null;

		List<Pago> list =pmodel.Listarpagos();
		if (list != null) {
			request.setAttribute("lispagos", list);
		} else {
			error = "Sin acceso a Base de datos";
		}

		return error;
	}

	 protected String read(HttpServletRequest request, pagoModel pmodel)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String error = null;

		String cod=(request.getParameter("codigo"));
		Pago pag = pmodel.BuscarPago(cod);
		if (pag != null) {
			request.setAttribute("pago", pag);
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

