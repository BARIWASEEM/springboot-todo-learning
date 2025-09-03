<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Todos</title>

    <!-- Bootstrap CSS via WebJars -->
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <h2 class="mb-4 text-center text-primary">Welcome to 28min, ${name}</h2>
    <p class="lead">Here are your Todos:</p>

    <table class="table table-striped table-bordered shadow-lg rounded">
        <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                     <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                   <td>${todo.done}</td>
                   <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete ${todo.id}</a></td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update ${todo.id}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<a href="add-todo" class="btn btn-success">Add Todo</a>
















</div>

<!-- JQuery + Bootstrap JS via WebJars -->
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
