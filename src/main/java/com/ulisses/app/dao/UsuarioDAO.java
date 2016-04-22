/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulisses.app.dao;

import com.ulisses.app.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author uliss
 */
public class UsuarioDAO {

  @Inject
  private EntityManager em;

  public Usuario buscar(Long id) {
    if (id != null) {
      return em.find(Usuario.class, id);
    }
    return null;
  }

  public Usuario salvar(Usuario usuario) {
    if (usuario != null) {
      if (usuario.getSenhaConfirmacao() != null) {
        if (!usuario.getSenhaConfirmacao().equals(usuario.getSenha())) {
          throw new RuntimeException("As senhas não conferem!");
        } else if (usuario.getSenhaConfirmacao().length() < 10) {
          throw new RuntimeException("A senha deve conter no mínimo 10 caracteres!");
        } else if (usuario.getSenhaConfirmacao().length() > 125) {
          throw new RuntimeException("A senha deve conter no máximo 125 caracteres!");
        } else {
          usuario.setSenha(DigestUtils.sha512Hex(usuario.getSenha()));
        }
      } else if (usuario.getId() != null) {
        usuario.setSenha(null);
        Usuario u = buscar(usuario.getId());
        if (u != null) {
          usuario.setSenha(u.getSenha());
        }
      } else {
        usuario.setSenha(null);
      }
      usuario = em.merge(usuario);
    }
    return usuario;
  }

  public boolean excluir(Usuario usuario) {
    if (usuario != null) {
      em.remove(usuario);
      return true;
    }
    return false;
  }

  public List<Usuario> buscar() {
    return em.createQuery("from Usuario", Usuario.class).getResultList();
  }

  public List<Usuario> buscarComSenha(String senha) {
    if (senha == null) {
      return new ArrayList<>();
    }
    senha = DigestUtils.sha512Hex(senha);
    return em.createQuery("from Usuario where senha = :senha", Usuario.class).setParameter("senha", senha).getResultList();
  }

  public Long contar() {
    TypedQuery<Long> qtd = em.createQuery("select count(u) from Usuario u", Long.class);
    return qtd.getSingleResult();
  }

}
