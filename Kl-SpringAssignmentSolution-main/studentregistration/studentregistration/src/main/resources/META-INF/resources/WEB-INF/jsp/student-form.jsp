<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Student Register Form</title>
   </head>

   <body>
      <h2 style="background-color:powderblue;">Student Registration</h2>

      <form:form method = "POST" action = "registerStudent" >
         <table>
            <tr>
                <td><form:label path = "id">Id</form:label></td>
                <td><form:input path = "id" /></td>
            </tr>
            <tr>
               <td><form:label path = "firstname">First Name</form:label></td>
               <td><form:input path = "firstname" /></td>
            </tr>
            <tr>
               <td><form:label path = "lastname">Last Name</form:label></td>
               <td><form:input path = "lastname" /></td>
            </tr>
            <tr>
               <td><form:label path = "course">course</form:label></td>
               <td><form:input path = "course" /></td>
            </tr>
			<tr>
               <td><form:label path = "country">Country</form:label></td>
               <td><form:input path = "country" /></td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
               <td colspan = "2">
                  <input style="font-size: 14px;border-radius: 8px;" type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>