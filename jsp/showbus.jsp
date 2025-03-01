<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1 style="text-align: center">Buses</h1>

<style>
table, th, td {
	border: 1px solid black;
	padding: 5px
}

table.center {
	margin-left: auto;
	margin-right: auto;
}
</style>

<table class="center" style="width: 50%;">
	<tr>
		<th>Bus Name</th>
		<th>Bus Location</th>
		<th>Bus Price</th>
	</tr>

	<c:forEach var="bus" items="${buses}">
		<tr>
			<td>${bus.bus_name}</td>
			<td>${bus.location}</td>
			<td>${bus.ticket_price}</td>
		</tr>

	</c:forEach>

</table>

<h2 style="text-align: left">Search by location</h2>
<form action="/assignment6/showbuses" method="get">
	<input type="text" name="location" placeholder="Enter location">
	<button type="submit">Search</button>
</form>

<br>
<br>

<a href="/assignment6/addbus">
	<button type="button"
		style="background-color: yellow; color: blue; width: 150px; height: 40px;">
		Add Bus</button>
</a>

<br>
<br>

<a href="/assignment6/"
	style="display: block; text-align: left; margin-top: 20px;">Go to
	Home</a>

