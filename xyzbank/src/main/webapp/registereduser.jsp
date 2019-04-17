<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registered</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" style=; background-color:#FFFFFF">
  <tr>
    <th colspan="3" scope="col" style="height:90px; background-color:white;"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="900" height="90">
      <param name="movie" value="images/banks.swf" />
      <param name="quality" value="high" />
      <h1 align="center"><font color="grey"><b>Banking System</b></font></h1>
       </object></th>
  </tr>
  
  <td colspan="2"><table width="98%" border="0px" align="center" cellpadding="0" cellspacing="0">
        <tr>
        <th colspan="2" scope="col"><div class="box1">
          <marquee>
            <h2><font color="black">XYZ COMPANY</font></h2>
            </marquee>
        </div></th>
        </tr>
        </table>
<h3 style="color:grey;" align="center">User Details</h3>
	<table align="center" border= 5px solid black vertical-align="center" padding-top=15px>
		<thead>
			<tr>
				<th>User Id</th>
				<th>Full Name</th>
				<th>User Password</th>
				<th>Balance</th>
		
			</tr>
		</thead>
		<tbody>
		<c:forEach var="bank" items="${REGISTER}">
				<tr>
					<td>${bank.id}</td>
					<td>${bank.fullName}</td>
					<td>${bank.password}</td>
					<td>${bank.balance}</td>
					
					
				</tr>
				</c:forEach>
				</tbody>
			</table>
</body>
</body>
</html>