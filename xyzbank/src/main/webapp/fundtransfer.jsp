<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
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
	<form action="accounts/fundtransfer" method="post">
	<table width="98%" border="0px" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<th> 
	<th>Enter Account Id in which you want to Transfer: <input type="number" name="id" required autofocus /> </th></th>
	</tr>
	<tr>
	<th>
	<th>Enter amount you want to Transfer:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="transfer" required autofocus /> </th></th>
	</tr>
	</table>
	<div align="center">
	<input type="submit" value="Submit">
	</div>
	</form>
</body>
</html>