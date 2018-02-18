<%-- 
    Document   : index4
    Created on : Sep 27, 2017, 11:21:03 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function validateForm() {
                var x = document.forms["myForm"]["fname"].value;
                if (x == "") {
                    alert("Name must be filled out");
                    return false;
                }
            }
        </script>
    </head>
    <body>

        <form name="myForm" action="/action_page_post.php"
              onsubmit="return validateForm()" method="post">
            Name: <input type="text" name="fname">
            <input type="submit" value="Submit">
        </form>
        <script>
            function validateForm() {
                var x = document.forms["myForm"]["fname"].value;
                if (x == "") {
                    alert("Name must be filled out");
                    return false;
                }
            }
        </script>
    </head>
<body>

    <form name="myForm" action="/action_page_post.php"
          onsubmit="return validateForm()" method="post">
        Name: <input type="text" name="fname">
        <input type="submit" value="Submit">
    </form>
    <form action="/action_page_post.php" method="post">
        <input type="text" name="fname" required>
        <input type="submit" value="Submit">
    </form> 
    <p id="dem1"></p>

    <script>
        var person = {firstName: "John", lastName: "Doe", age: 50, eyeColor: "blue"};

        document.getElementById("dem1").innerHTML =
                person.firstName + " is " + person.age + " years old.";
    </script>

</body>
</html>
