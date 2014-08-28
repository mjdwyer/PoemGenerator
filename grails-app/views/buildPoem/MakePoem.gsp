<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Poem</title>
</head>
<body>
<br>
<div style="padding:40px 20px 40px 20px">
<g:form action="MakePoem">
	<input type="submit" value= "Create!"  style="cursor:pointer; background-color: #f7ffcc"/>
	<br><br>
</g:form>
	<div style="font-size:12px">
    <g:each in="${lines}" var="line" >
		${line} <br>
     </g:each>  
     </div>
</div>    
</body>
</html>
