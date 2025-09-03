<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form method="post" modelAttribute="todo">


<fieldset class="mb-3">
<form:label path="description">Description</form:label>
<form:input type="text"  path="description" required="required"/>
 <form:errors  path="description"  cssClass="text-warning"  />
 </fieldset>
 
 
 <fieldset class="mb-3">
<form:label path="targetDate">Date</form:label>
<form:input type="text" path="targetDate" required="required"/>
 <form:errors  path="targetDate"  cssClass="text-warning"  />
 </fieldset>
 

 <form:input type="hidden" path="id"/> 
  <form:input type="hidden" path="done"/> 


 <input type="submit" class="btn btn-success"/>
 
  </form:form>

<a href="list-todos" class="btn btn-success">Back</a>
















</div>

<!-- JQuery + Bootstrap JS via WebJars -->
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
