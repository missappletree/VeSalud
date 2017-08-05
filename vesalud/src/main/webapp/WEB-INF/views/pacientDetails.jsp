<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">
body {
	text-align: center;
	margin: 0 auto;
}

#contenedor {
	margin: 0 auto;
	text-align: left;
	width: 80%;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 24px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 8px;
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: Green;
	color: white;
}

td, th {
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<div id="contenedor">
		<h2>:::::Red de Veterinarias VESALUD:::::</h2>

		<form:form method="post" modelAttribute="pacient"
			action="/SpringMVCHibernateCRUDExample/addPacient">
			<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
				cellpadding="5">
				<tr>
					<th colspan="2">Agregar Paciente</th>
				</tr>
				<tr>
					<form:hidden path="id" />
					<td><form:label path="nombre">Nombre:</form:label></td>
					<td width="10%"><form:input path="nombre" size="30"
							maxlength="30"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="raza">Raza:</form:label></td>
					<td width="10%"><form:input path="raza" size="30"
							maxlength="30"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="edad">Edad:</form:label></td>
					<td width="10%"><form:input path="edad" size="30"
							maxlength="30"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Guardar"
						class="button" /></td>
				</tr>
			</table>
		</form:form>
		</br>
		<h3>Lista de Pacientes</h3>
		<c:if test="${!empty listOfPacients}">
			<table class="tg">
				<tr>
					<th width="80">Id</th>
					<th width="120">Nombre</th>
					<th width="120">Raza</th>
					<th width="120">Edad</th>
					<th width="60">Editar</th>
					<th width="60">Eliminar</th>
				</tr>
				<c:forEach items="${listOfPacients}" var="pacient">
					<tr>
						<td>${pacient.id}</td>
						<td>${pacient.nombre}</td>
						<td>${pacient.raza}</td>
						<td>${pacient.edad}</td>
						<td><a href="<c:url value='/updatePacient/${pacient.id}' />">Editar</a></td>
						<td><a href="<c:url value='/deletePacient/${pacient.id}' />">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>
