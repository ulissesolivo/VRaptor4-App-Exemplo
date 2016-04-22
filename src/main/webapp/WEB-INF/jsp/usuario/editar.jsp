<%-- 
    Document   : edita
    Created on : 20/04/2016, 23:30:40
    Author     : Ulisses Olivo
    E-mail     : ulissesolivo@gmail.com
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${empty usuario.id ? 'Inserindo' : 'Editando'} usuario</title>
  </head>
  <body>
    <%@include file="../../menu.jsp" %>
    <form action="<c:url value="/usuario/editar" />" enctype="application/x-www-form-urlencoded" method="post">
      <table>
        <thead>
          <tr>
            <th colspan="2"><h3>${empty usuario.id ? 'Inserindo' : 'Editando'} usuario</h3></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Id</td>
            <td><input type="number" name="usuario.id" value="${usuario.id}" readonly="readonly" /></td>
          </tr>
          <tr>
            <td>Login</td>
            <td><input type="email" name="usuario.login" value="${usuario.login}" style="width: 250px;" /></td>
          </tr>
          <tr>
            <td>Senha</td>
            <td><input type="password" name="usuario.senha" /></td>
          </tr>
          <tr>
            <td>Senha confirmação</td>
            <td><input type="password" name="usuario.senhaConfirmacao" /></td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td>&nbsp;</td>
            <td><button type="button" onclick="window.history.back();">Cancelar</button></td>
            <td><button type="submit">Salvar</button></td>
          </tr>
        </tfoot>
      </table>
    </form>
  </body>
</html>
