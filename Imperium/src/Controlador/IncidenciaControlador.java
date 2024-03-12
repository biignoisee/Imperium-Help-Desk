package Controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import CategoriaDao.CategoriaMantenimiento;
import Interfaces.IIncidenciaInterface;
import Interfaces.IntUsuarioable;
import Models.CreateDocumentoIncidencia;
import Models.CreateImagenIncidencia;
import Models.CreateIncidencia;
import Models.ReadCategoria;
import Models.ReadIncidencia;
import Models.ReadIncidenciaById;
import Models.ReadPrioridad;
import Models.ReadUsuarioSoporte;
import PrioridadesDao.PrioridadMantenimiento;
import UsuarioDAO.CrudUsuarioImp;
import incidenciaDao.IncidenciaMantenimiento;

/**
 * Servlet implementation class IncidenciaControlador
 */
@WebServlet(name = "incidencias", urlPatterns = {"/incidencias"})
@MultipartConfig
		//"/IncidenciaControlador")
public class IncidenciaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File docuIncidencias = new File("D:/CIBERTEC-4TO/JAVA/PROYECTOS/Imperium/WebContent/documentos/");
	private File imgIncidencias = new File("D:/CIBERTEC-4TO/JAVA/PROYECTOS/Imperium/WebContent/imagenes/");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncidenciaControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion){
		case "r": readIncidencias(request, response); break;
		case "ri": readIncidenciaById(request, response);break;
		case "rf": readIndicenciasByFilter(request, response);break;
		case "c": createViewIncidencia(request, response); break;
		case "cp": createIncidencia(request, response); break;
		case "aui": asignarUsuarioSoporteIncidencia(request, response);break;
		case "dui": deleteUsuarioAsignadoIncidencia(request, response);
		default:
			break;
		}
	}

	private void readIncidencias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IIncidenciaInterface im = new IncidenciaMantenimiento();
		CategoriaMantenimiento cm = new CategoriaMantenimiento();
		PrioridadMantenimiento pm = new PrioridadMantenimiento();
		IntUsuarioable crudUsuarioImpl = new CrudUsuarioImp();
		
		List<ReadIncidencia> incidencias = im.readIncidencias();
		List<ReadCategoria> categorias = cm.getCategorias();
		List<ReadPrioridad> prioridades = pm.readPrioridades();
		List<ReadUsuarioSoporte> usuariosSoporte = crudUsuarioImpl.readUsuariosSoporte();
		
		request.setAttribute("incidencias", incidencias);
		request.setAttribute("categorias", categorias);
		request.setAttribute("prioridades", prioridades);
		request.setAttribute("usuariosSoporte", usuariosSoporte);
		request.getRequestDispatcher("/incidencias.jsp").forward(request, response);
	}
	
	private void readIncidenciaById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int incidenciaId = Integer.parseInt(request.getParameter("incidenciaId"));
		IncidenciaMantenimiento incidenciaMantenimiento = new IncidenciaMantenimiento();
		ReadIncidenciaById incidencia = incidenciaMantenimiento.readIncidenciaById(incidenciaId);
		
		List<String> documentosArr = null;
		List<String> imagenesArr = null;
		
		if(incidencia.getDocumentos() != null) {
			documentosArr = new ArrayList<>();
			String[] documentos = incidencia.getDocumentos().split(",");
			for (String documento : documentos) {
				documentosArr.add(documento);
			}			
		}
		
		if(incidencia.getImagenes() != null) {
			imagenesArr = new ArrayList<>();
			String[] imagenes = incidencia.getImagenes().split(",");
			for (String imagen : imagenes) {
				imagenesArr.add(imagen);
			}			
		}
		
		request.setAttribute("incidencia", incidencia);
		request.setAttribute("documentos", documentosArr);
		request.setAttribute("imagenes", imagenesArr);
		request.getRequestDispatcher("/incidencia.jsp").forward(request, response);
	}
	
	private void readIndicenciasByFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoriaId = Integer.parseInt(request.getParameter("categoria"));
		int prioridadId = Integer.parseInt(request.getParameter("prioridad"));
		
		IIncidenciaInterface im = new IncidenciaMantenimiento();
		CategoriaMantenimiento cm = new CategoriaMantenimiento();
		PrioridadMantenimiento pm = new PrioridadMantenimiento();
		IntUsuarioable crudUsuarioImpl = new CrudUsuarioImp();
		
		List<ReadIncidencia> incidencias = im.readIndidenciasByFilter(categoriaId, prioridadId);
		List<ReadCategoria> categorias = cm.getCategorias();
		List<ReadPrioridad> prioridades = pm.readPrioridades();
		List<ReadUsuarioSoporte> usuariosSoporte = crudUsuarioImpl.readUsuariosSoporte();
		
		request.setAttribute("incidencias", incidencias);
		request.setAttribute("categorias", categorias);
		request.setAttribute("prioridades", prioridades);
		request.setAttribute("categoriaId", categoriaId);
		request.setAttribute("prioridadId", prioridadId);
		request.setAttribute("usuariosSoporte", usuariosSoporte);
		
		request.getRequestDispatcher("/incidencias.jsp").forward(request, response);
	}
	
	private void createViewIncidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaMantenimiento cm = new CategoriaMantenimiento();
		List<ReadCategoria> categorias = cm.getCategorias();
		
		PrioridadMantenimiento pm = new PrioridadMantenimiento();
		List<ReadPrioridad> prioridades = pm.readPrioridades();
		
		request.setAttribute("categorias", categorias);
		request.setAttribute("prioridades", prioridades);
		request.getRequestDispatcher("/crearIncidencia.jsp").forward(request, response);
	}
	
	private void createIncidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		int subcategoriaId = Integer.parseInt(request.getParameter("subcategoria"));
		int prioridadId = Integer.parseInt(request.getParameter("prioridad"));
		String descripcion = request.getParameter("descripcion");
		Date fechaCreacion = new Date();
		
		List<CreateDocumentoIncidencia> documentos = new ArrayList<CreateDocumentoIncidencia>();
		List<CreateImagenIncidencia> imagenes = new ArrayList<CreateImagenIncidencia>();
			
		List<Part> documentosPart = request.getParts().stream().filter(part -> "documentos".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		List<Part> imagenesPart = request.getParts().stream().filter(part -> "imagenes".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		
		if(documentosPart.size() > 0) {
			for (Part part : documentosPart) {
				String documento = saveFile(part, docuIncidencias);
				CreateDocumentoIncidencia createDocumentoIncidenciaDto = new CreateDocumentoIncidencia();
				createDocumentoIncidenciaDto.setDocumento(documento);
				documentos.add(createDocumentoIncidenciaDto);
			}
		}
		
		if(imagenesPart.size() > 0) {
			for (Part part : imagenesPart) {
				String imagen = saveFile(part, imgIncidencias);
				CreateImagenIncidencia createImagenIncidenciaDto = new CreateImagenIncidencia();
				createImagenIncidenciaDto.setImagen(imagen);
				imagenes.add(createImagenIncidenciaDto);
			}
		}
	
		CreateIncidencia createIncidenciaDto = new CreateIncidencia();
		createIncidenciaDto.setTitulo(titulo);
		createIncidenciaDto.setSubcategoriaId(subcategoriaId);
		createIncidenciaDto.setPrioridadId(prioridadId);
		createIncidenciaDto.setDescripcion(descripcion);
		createIncidenciaDto.setFechaCreacion(fechaCreacion);
		
		IIncidenciaInterface incidenciaMantenimiento = new IncidenciaMantenimiento();
		incidenciaMantenimiento.createIncidencia(createIncidenciaDto, documentos, imagenes);
		
		response.sendRedirect("incidencias?accion=r&mensaje=" + "Incidencia registrada correctamente");
	}
	
	private void asignarUsuarioSoporteIncidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		int incidenciaId = Integer.parseInt(request.getParameter("incidenciaId"));
		
		IIncidenciaInterface incidenciaMantenimiento = new IncidenciaMantenimiento();
		incidenciaMantenimiento.asignarUsuarioSoporteIncidencia(incidenciaId, usuarioId);
		
		response.sendRedirect("incidencias?accion=r&mensaje=" + "Usuario de Soporte asignado a incidencia correctamente");
	}
	
	private void deleteUsuarioAsignadoIncidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int incidenciaId = Integer.parseInt(request.getParameter("incidenciaId"));
		System.out.print(incidenciaId);
		IIncidenciaInterface incidenciaMantenimiento = new IncidenciaMantenimiento();
		incidenciaMantenimiento.eliminarUsuarioAsignadoIncidencia(incidenciaId);
		
		response.sendRedirect("incidencias?accion=r&mensaje=" + "Tarea completada correctamente");
	}
	
	private String saveFile(Part part, File pathUploads) {
		String pathAbsolute = "";
		
		try {
			Path path = Paths.get(part.getSubmittedFileName());
			String filename = path.getFileName().toString();
			InputStream input = part.getInputStream();
			
			int nAleatorio = getNumeroAleatorio();
			File file = new File(pathUploads,  nAleatorio + "_" + filename);
			pathAbsolute = nAleatorio + "_" + filename;
			Files.copy(input, file.toPath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pathAbsolute;
	}
	
	private int getNumeroAleatorio() {
		return (int) (Math.random() * 900000000) + 1;
	}
	
}






















