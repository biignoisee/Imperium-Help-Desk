package Interfaces;

import java.util.List;

import Models.CreateDocumentoIncidencia;
import Models.CreateImagenIncidencia;
import Models.CreateIncidencia;
import Models.ReadIncidencia;
import Models.ReadIncidenciaById;

public interface IIncidenciaInterface {
	public List<ReadIncidencia> readIncidencias();
	public void createIncidencia(CreateIncidencia incidencia,
								 List<CreateDocumentoIncidencia> documentos,
								 List<CreateImagenIncidencia> imagenes);
	public ReadIncidenciaById readIncidenciaById(int id);
	public List<ReadIncidencia> readIndidenciasByFilter(int categoriaId, int prioridadId);
	public void eliminarUsuarioAsignadoIncidencia(int incidenciaId);
	public void asignarUsuarioSoporteIncidencia(int incidenciaId, int usuarioId);
}
