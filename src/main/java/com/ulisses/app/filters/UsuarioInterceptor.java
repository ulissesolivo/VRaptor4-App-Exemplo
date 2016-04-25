 /*
 *  Created on : 20/04/2016, 22:36:48
 *  Author     : Ulisses Olivo
 *  E-mail     : ulissesolivo@gmail.com
 */
package com.ulisses.app.filters;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import com.ulisses.app.AppSession;
import com.ulisses.app.controllers.UsuarioController;
import javax.inject.Inject;

/**
 *
 * @author uliss
 */
@Intercepts
public class UsuarioInterceptor implements Interceptor {

  @Inject
  private Result result;
  @Inject
  private AppSession session;
  
  @Override
  public void intercept(InterceptorStack is, ControllerMethod cm, Object o) throws InterceptionException {
    result.forwardTo(UsuarioController.class).login();
  }

  @Override
  public boolean accepts(ControllerMethod cm) {
    return session.getUsuario() == null && !cm.containsAnnotation(Public.class);
  }
  
}
