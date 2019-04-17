<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
.login-box
		{
			height: 50%;
			width: 30%;
			border: 1px solid grey;
			margin-left: 35%;
			margin-top: 10%;
			position: relative;
      		box-shadow: 21px 12px 24px 10px rgba(0, 0, 0, .5);
      		background: #dadada;
		}
		</style>
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
        <div class="login-box"  align="center" >
<h3>	<div class="login-header">Enter Login details</div></h3>
	<div class="login-body">
	<form action="accounts/checkuser" method="post">
	
	<label>Username Id</label>
	<input type="number" name="id" required autofocus /> </th></th>
<br>	<label>Password</label>
	<input type="password" name="password" required autofocus /> </th></th>
<br>	<input type="checkbox" value="checked"><b>Remember me</b><br>
		<input class="btn btn-success " type="submit" value="Submit">
	</form>
	
</div>
</div>
</body>
</html>