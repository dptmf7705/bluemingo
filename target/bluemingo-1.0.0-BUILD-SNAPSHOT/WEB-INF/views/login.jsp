<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head></head>
<body>
<form action="spring_security_check" method="post">
 <table border="0">
  <tr>
   <td>ID:</td>
   <td><input type="text" name="username"></td>
  </tr>
  <tr>
   <td>패스워드:</td>
   <td><input type="password" name="password"></td>
  </tr>
  <tr>
   <td colspan="2">
    <input type="submit" value="Login">
   </td>
  </tr>
 </table>
</form>
</body>
</html>