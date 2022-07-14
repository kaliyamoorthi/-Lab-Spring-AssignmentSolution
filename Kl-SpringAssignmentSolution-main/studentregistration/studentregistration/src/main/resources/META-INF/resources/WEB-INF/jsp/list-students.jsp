<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Registration</title>

    <style>
        table, th, td {
          border: 1px solid black;
           border-collapse: collapse;
        }
        td {
          text-align: center;
        }
        table tr:nth-child(even) { background-color:#dddddd; }
        table style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;"
    </style>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h1  style="background-color:powderblue;text-align: center;" >Event - Debate </h1>

    <!--br/><br/-->

    <div class="panel-heading">
     <div class="panel-title" style="font-size: 25px;text-align: center;" > Registered Students</div>
    </div>
    <br/>
    <div class="panel-body">
     <table style="width:100%;" class="table table-striped table-bordered">
      <tr>
       <th style="background-color:powderblue;">Student Id</th>
       <th style="background-color:powderblue;">First Name</th>
       <th style="background-color:powderblue;">Last Name</th>
       <th style="background-color:powderblue;">Course</th>
       <th style="background-color:powderblue;">Country</th>
       <th style="background-color:powderblue;">Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempStudent" items="${students}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/event/updateForm">
        <c:param name="studentId" value="${tempStudent.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/event/delete">
        <c:param name="studentId" value="${tempStudent.id}" />
       </c:url>

       <tr>
        <td>${tempStudent.id}</td>
        <td>${tempStudent.firstname}</td>
        <td>${tempStudent.lastname}</td>
        <td>${tempStudent.course}</td>
		<td>${tempStudent.country}</td>

        <td>
         <!-- display the update link -->
          <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <br>
  <input type="button" value="Register Student"
     onclick="window.location.href='showStudentform';"
     class="btn btn-primary"
     style="font-size: 14px;border-radius: 8px;"/>
 <br>
  <br>


   <c:url var="homepage" value="/event/homePage"></c:url>
 <a href  = "${homepage}">Home Page</a>
</body>
</html>