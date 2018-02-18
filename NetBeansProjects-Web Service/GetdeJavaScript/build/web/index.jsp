<%-- 
    Document   : index
    Created on : Sep 27, 2017, 10:11:30 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <button type="button"
                onclick =" document.getElementById('demo').innerHTML = Date()">
            Click me to display Date and Time.</button>
        <p id="demo"></p>
        <p id="dem"></p>

        <script>
            var d = new Date("October 13, 2014 11:13:00");
            document.getElementById("dem").innerHTML = d;
        </script>
        <p id="muestra"></p>

        <script>
            var d = new Date(99, 5, 24, 11, 33, 30, 0);
            document.getElementById("muestra").innerHTML = d;
        </script>
        <h2>JavaScript ISO Dates</h2>

        <p id="de"></p>

        <script>
            document.getElementById("de").innerHTML =
                    new Date("2015-03-25");
        </script>
        <p>The internal clock in JavaScript starts at midnight January 1, 1970.</p>
        <p>The getTime() function returns the number of milliseconds since then:</p>

        <p id="demu"></p>

        <script>
            var d = new Date();
            document.getElementById("demu").innerHTML = d.getTime();
        </script>
        <h2>JavaScript Bitwise XOR</h2>

        <p id="Xor"></p>

        <script>
            document.getElementById("Xor").innerHTML = 5 ^ 2;
        </script>
    </body>
</html>
