<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	*{
		margin: 0;
		padding: 0;
	}
	nav {
		background-color: #3578E5;
	}
	nav ul{
		display: flex;
		justify-content: flex-start;
		align-items: center;
		list-style: none;
	}
	nav ul li a{
		display: block;
		color: #fff;
		padding: 1rem;
		text-decoration: none;
	}
</style>

<nav>
	<uL>
		<li> 
			<a href="${pageContext.request.contextPath }/home">Home</a>
		</li>
		<li> 
			<a href="${pageContext.request.contextPath }/productList">Product List</a>
		</li>
		<li> 
			<a href="${pageContext.request.contextPath }/userList">User List</a>
		</li>
	</uL>
</nav>    