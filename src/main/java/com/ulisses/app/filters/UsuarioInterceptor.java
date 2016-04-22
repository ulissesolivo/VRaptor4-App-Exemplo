/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    result.forwardTo(UsuarioController.class).login(null);
  }

  @Override
  public boolean accepts(ControllerMethod cm) {
    return session.getUsuario() == null && !cm.containsAnnotation(Public.class);
  }
  
}
