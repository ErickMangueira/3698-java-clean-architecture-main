package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entity.usuario.Usuario;
import br.com.alura.codechella.infra.controller.UsuarioDto;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuarios(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

   public List<Usuario> obterTodosUsarios() {
        return this.repositorioDeUsuario.listarTodos();
    }


}
