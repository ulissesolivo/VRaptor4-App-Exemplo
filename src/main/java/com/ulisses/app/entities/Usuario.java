/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 *  Created on : 20/04/2016, 22:22:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "generator_id", sequenceName = "sequence_id", allocationSize = 1)
  @GeneratedValue(generator = "generator_id", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(length = 255, nullable = false, unique = true)
  @Length(min = 1, max = 255, message = "O login deve conter no máximo 255 caracteres!")
  private String login;

  @Column(length = 130)
  @Length(min = 0, max = 130, message = "A senha deve conter no máximo 130 caracteres!")
  private String senha;

  @Transient
  private String senhaConfirmacao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login == null || login.trim().equals("") ? null : login.trim();
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getSenhaConfirmacao() {
    return senhaConfirmacao;
  }

  public void setSenhaConfirmacao(String senhaConfirmacao) {
    this.senhaConfirmacao = senhaConfirmacao;
  }

  public Usuario() {
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Usuario)) {
      return false;
    }
    Usuario other = (Usuario) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ulisses.app.entities.Usuario[ id=" + id + " ]";
  }

}
