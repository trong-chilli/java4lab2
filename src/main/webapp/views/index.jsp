<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* Style the form */
form {
  margin: 20px;
  padding: 20px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 5px;
  width: 50%;
}

form label {
  font-weight: bold;
  margin-top: 10px;
}

form input[type="text"], form textarea {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

form button {
  padding: 10px 15px;
  margin-top: 10px;
  margin-right: 5px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

form button:hover {
  background-color: #0056b3;
}

/* Style the table */
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

table, th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

table th {
  background-color: #f2f2f2;
  text-align: left;
  font-weight: bold;
}

table td {
  text-align: left;
}

table tr:hover {
  background-color: #f1f1f1;
}

table a {
  color: #007BFF;
  text-decoration: none;
}

table a:hover {
  text-decoration: underline;
}
</style>
</head>
<body>
	<c:url var="path" value="/user" />
	<form method="post">
		<label>Id:</label><br> <input name="id" value="${item.id}"><br>
		<label>Fullname:</label><br> <input name="name" value="${item.name}"><br>
		<label>Password:</label> <input name="password" value= "${item.pass}"> <br>
		<label>Email:</label> <input name="email" value= "${item.email}"> <br>
		<label>Role:</label>
        <input type="radio" name="admin" value="true" ${item.admin?"checked" } /> Admin 
        <input type="radio" name="admin" value="false" ${item.admin?:'checked'} /> User<br />
		<hr>
		<button formaction="${path}/create">Create</button>
		<button formaction="${path}/update">Update</button>
		<button formaction="${path}/delete">Delete</button>
		<button formaction="${path}/reset">Reset</button>
	</form>
	<hr>
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Id</th>
				<th>Fullname</th>
				<th>Password</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="d" items="${list}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${d.id}</td>
					<td>${d.fullname}</td>
					<td>${d.password}</td>
					<td>${d.email}</td>
					<td>${d.admin?'Admin':'User'}</td>
					<td><a href="${path}/edit/${d.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>