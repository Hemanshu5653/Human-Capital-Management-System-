<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="login.css">
</head>
<body>
<div style="padding: 3px ;border: 2px solid black;  border-radius: 5px;" >
	<h1 style="text-align:center">WelCome</h1>
</div>
	<div class="c"  >
	
		<form action="login" method="post">
			<div class="col-25">
				<label class="lable" for="id">Id</label>
			</div>
			<div class="col-75">
				<input type="number" name="id">
			</div>
			<br> <br>
			<div class="col-25">
				<label class="lable" for="pwd">Password</label>
			</div>
			<div class="col-75">
				<input type="password" name="pwd" />
			</div>
			<br> <br>
			<div class="col-25">
				<label class="lable" for="radio" >Type</label>
			</div>
			<div class="col-75" >
				<select class="select" name="radio" id="Type" >
					<option value="Employee">Employee</option>
					<option value="HR">HR</option>
				</select>
			</div>
			<br> <br> 
			<input type="submit" value="Submit"></input>
	</form>
	</div>

</body>
</html>