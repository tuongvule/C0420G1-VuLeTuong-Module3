<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/26/2020
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator_index" method="get">
  <fieldset>
    <legend>Simple Calculator</legend>
    <table>
      <tr>
        <td>First operand</td>
        <td><input type="text" name="first_operand"></td>
      </tr>
      <tr>
        <td>Operator:</td>
        <td>
          <select name="operator" >
          <option value="+">Addition</option>
          <option value="-">Substraction</option>
          <option value="*">Multiplication</option>
          <option value="/">Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand</td>
        <td><input type="text" name="second_operand"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="calculate"></td>
      </tr>

    </table>
  </fieldset>
  </form>
  </body>
</html>
