package Interfaces;

import java.util.List;

import Models.ClassUsuario;
import Models.ReadUsuarioSoporte;

public interface IntUsuarioable {
	void RegistrarUsuario(ClassUsuario clusu);
	void ActualizarUsuario(ClassUsuario clusu);
	void EliminarUsuario(ClassUsuario clusu);
	List<ClassUsuario> ListarUsuario();
	ClassUsuario BuscarUsuario(ClassUsuario bususu);
	List<ReadUsuarioSoporte> readUsuariosSoporte();
}
