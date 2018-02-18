<%-- 
    Document   : index2
    Created on : Sep 27, 2017, 10:30:52 AM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <body>

        <h2>What Can JavaScript Do?</h2>

        <p id="demo">JavaScript can change HTML content.</p>

        <button type="button" onclick='document.getElementById("demo").innerHTML = "Hello JavaScript!"'>Click Me!</button>


        <p id="demo2">JavaScript can change the style of an HTML element.</p>

        <button type="button" onclick="document.getElementById('demo2').style.fontSize = '35px'">Click Me!</button>

        <p id="demo3">JavaScript can hide HTML elements.</p>

        <button type="button" onclick="document.getElementById('demo3').style.display = 'none'">Click Me!</button>


        <p id="demo4" style="display:none">Hello JavaScript!</p>

        <button type="button" onclick="document.getElementById('demo4').style.display = 'block'">Click Me!</button>

    </body>
</html>
