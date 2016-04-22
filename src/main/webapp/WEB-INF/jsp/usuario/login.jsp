<%-- 
    Document   : login
    Created on : 21/04/2016, 23:29:27
    Author     : Ulisses Olivo
    E-mail     : ulissesolivo@gmail.com
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
  </head>
  <body>
    <form action="<c:url value="/usuario/logar" />" enctype="application/x-www-form-urlencoded" method="post">
      <h2>${mensagem}</h2>
      <table>
        <tbody>
          <tr>
            <td>Login</td>
            <td><input type="email" name="usuario.login" style="width: 250px;" /></td>
          </tr>
          <tr>
            <td>Senha</td>
            <td><input type="password" name="usuario.senha" /></td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td>&nbsp;</td>
            <td><button type="button" onclick="window.history.back();">Cancelar</button></td>
            <td><button type="submit">Entrar</button></td>
          </tr>
        </tfoot>
      </table>
    </form>
  </body>
</html>
