 /*
 *  Created on : 20/04/2016, 21:51:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.controllers;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ulisses.app.AppSession;
import com.ulisses.app.components.UsuarioComponent;
import com.ulisses.app.entities.Usuario;
import javax.inject.Inject;

@Controller
@Path("usuario")
public class UsuarioController {

  @Inject
  private Result result;
  @Inject
  private AppSession session;
  @Inject
  private UsuarioComponent usuarioComponent;

  @Get("listar")
  public void listar() {
    result.include("usuarios", usuarioComponent.buscarTodos());
  }

  @Get("editar")
  public void editar() {
    result.include("usuario", new Usuario());
  }

  @Get("editar/{id}")
  public void editar(Long id) {
    result.include("usuario", usuarioComponent.buscar(id));
  }

  @Post("editar")
  public void editar(Usuario usuario) {
    result.include("usuario", usuarioComponent.salvar(usuario));
    result.forwardTo(this).listar();
  }

  @Get("excluir/{id}")
  public void excluir(Long id) {
    usuarioComponent.excluir(id);
    result.forwardTo(this).listar();
  }

  @Public
  @Get("login")
  public void login(String mensagem) {
    result.include("mensagem", mensagem == null ? "Área restrita, informe o nome de usuário e senha!" : mensagem);
  }

  @Public
  @Post("logar")
  public void logar(Usuario usuario) {
    session.setUsuario(usuarioComponent.buscar(usuario.getLogin(), usuario.getSenha()));
    if (session.getUsuario() == null) {
      if (usuarioComponent.contar() > 0) {
        result.forwardTo(this).login("Login e/ou senha inválidos!");
      } else {
        usuario.setSenhaConfirmacao(usuario.getSenha());
        session.setUsuario(usuarioComponent.salvar(usuario));
        result.forwardTo(AppController.class).index();
      }
    } else {
      result.forwardTo(AppController.class).index();
    }
  }

  @Get("sair")
  public void sair() {
    session.setUsuario(null);
    result.forwardTo(AppController.class).index();
  }

}
