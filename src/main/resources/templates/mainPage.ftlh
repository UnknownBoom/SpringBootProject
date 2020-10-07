<html>

<head>
    <title> OurApp</title>

    <link type="text/css" href="/css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>


<body class="bg-body">
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value=${_csrf.token} />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<form method="post" id="save_edit" action="save">
</form>
<form action="/tables/filter" method="post" >
        <input type="text" name="filter" placeholder="Input an id"/>
    <input type="hidden" name="_csrf" value=${_csrf.token} />
    <button type="submit" class="btn-primary">Filter</button>
</form>
<table class="table table-hover table-dark" contenteditable="true">

    <thead >
    <tr>
        <th scope="col">#</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td><button form="save_edit" type="submit" class="btn btn-light cellbut" contenteditable="false">Save</button>
    </tr>
        </#list>
    </tbody>
</table>
</body>
</html>