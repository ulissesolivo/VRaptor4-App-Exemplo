/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 *  Created on : 20/04/2016, 22:36:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.components;

import com.ulisses.app.dao.UsuarioDAO;
import com.ulisses.app.entities.Usuario;
import java.util.List;
import javax.inject.Inject;

public class UsuarioComponent {

  @Inject
  private UsuarioDAO usuarioDAO;

  public Usuario buscar(Long id) {
    return usuarioDAO.buscar(id);
  }

  public Usuario salvar(Usuario usuario) {
    return usuarioDAO.salvar(usuario);
  }

  public boolean excluir(Long id) {
    Usuario usuario = usuarioDAO.buscar(id);
    if (usuario != null) {
      return usuarioDAO.excluir(usuario);
    }
    return false;
  }

  public List<Usuario> buscar() {
    return usuarioDAO.buscar();
  }

}
