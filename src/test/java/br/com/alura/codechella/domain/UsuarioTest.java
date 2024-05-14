package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entity.usuario.FabricaDeUsuario;
import br.com.alura.codechella.domain.entity.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123456789-99", "erick", LocalDate.parse("1985-11-11"),"erick@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("12345678999", "erick", LocalDate.parse("1985-11-11"),"erick@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario(" ", "erick", LocalDate.parse("1985-11-11"),"erick@gmail.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();
        Usuario usuario = fabricaDeUsuario.comNomeCpfNascimento("Emily", "123.456.789-00", LocalDate.parse("1994-10-20"));

        Assertions.assertEquals("Emily", usuario.getNome());

        usuario = fabricaDeUsuario.incluiEndereco("123456-999", 10,"apto 201");

        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());


    }
}
