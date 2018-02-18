<%-- 
    Document   : index3
    Created on : Sep 27, 2017, 10:47:21 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h2>JavaScript Math</h2>

<p>Math.floor(Math.random() * 10) returns a random integer between 0 and 9 (both included).</p>

<p id="demo"></p>

<script>
document.getElementById("demo").innerHTML =
Math.floor(Math.random() * 10);
</script>

</body>
</html>