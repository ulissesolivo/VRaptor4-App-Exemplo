 /*
 *  Created on : 20/04/2016, 22:36:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.dao;

import com.ulisses.app.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioDAO extends BaseDAO<Usuario> {
  
  public List<Usuario> findBySenha(String senha) {
    if (senha == null) {
      return new ArrayList<>();
    }
    senha = DigestUtils.sha512Hex(senha);
    return findByQuery("from Usuario where senha = '" + senha + "'");
  }

}
