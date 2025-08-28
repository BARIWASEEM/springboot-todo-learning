<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Todo Page</title>

    <!-- Bootstrap CSS via WebJars -->
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

 <h1>Enter Todo Details</h1>
   <table class="table table-striped table-bordered shadow-lg rounded">
        <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
            </tr>
        </thead>
        </table>
 <form method="post">
 Description: <input type="text" name="description"/>
 <input type="submit" class="btn btn-success"/>
 
 
 </form>

<a href="list-todos" class="btn btn-success">Back</a>
















</div>

<!-- JQuery + Bootstrap JS via WebJars -->
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
