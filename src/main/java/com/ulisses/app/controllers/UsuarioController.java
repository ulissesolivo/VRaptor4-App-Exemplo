/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 *  Created on : 20/04/2016, 21:51:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ulisses.app.components.UsuarioComponent;
import com.ulisses.app.entities.Usuario;
import javax.inject.Inject;

@Controller
@Path("usuario")
public class UsuarioController {
  
  @Inject
  private Result result;
  @Inject
  private UsuarioComponent usuarioComponent;
  
  @Get("listar")
  public void listar() {
    result.include("usuarios", usuarioComponent.buscar());
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
  
}
