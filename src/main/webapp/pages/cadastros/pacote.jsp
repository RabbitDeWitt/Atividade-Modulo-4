<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pacote</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
 <link rel="stylesheet" href="../../styles/styles.css">
<link rel="stylesheet" href="./cadastros.css">
</head>
<body class="d-flex flex-column justify-content-between min-vh-100">

<!-- NAVBAR -->

  <header class="fixed-top">

  </header>

<!-- NAVBAR -->

<main class="container">
	<div class="p-4">
<div class="select">
</div>
	
	<h1>Lista de Pacotes</h1>
	
		<button class="btn btn-primary mb-4" data-bs-toggle="modal"
			data-bs-target="#cadastroModal">Cadastrar pacote</button>

		<div class="modal fade dark" id="cadastroModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Cadastrar pacote</h1>
			<div data-bs-theme="dark">
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
			</div>
					</div>
					<div class="px-5">
					<form class="d-flex flex-column"
						action="/Atividade-Modulo-4/pacote-save">
						<div class="mb-3">
							<label for="nome" class="form-label">Nome:</label> <input
								type="text" id="nome" name="nome" class="form-control" required>
						</div>
						<div class="mb-3">
							<label for="valor" class="form-label">Valor:</label> <input
								type="text" id="valor" name="valor" class="form-control"
								required>
						</div>
						<div class="d-flex gap-2 justify-content-end mb-3">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancelar</button>
							<button class="btn btn-primary">Cadastrar</button>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>


		<table class="table table-responsive table-hover table-primary table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Valor</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${pacotes}" var="pacote">
					<tr>
						<th>${pacote.id}</th>
						<td>${pacote.nome}</td>
						<td>R$ ${pacote.valor}</td>
						<td>
							<a class="btn btn-warning"  data-bs-toggle="modal" data-bs-target="#atualizarModal${pacote.id}">Editar</a> 
							<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#excluirModal${pacote.id}">Excluir</a>
						</td>
					</tr>
					
					<div class="modal fade dark" id="atualizarModal${pacote.id}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Atualizar pacote</h1>
			<div data-bs-theme="dark">
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
			</div>
					</div>
					<div class="px-5">
					<form class="d-flex flex-column px-5"
						action="/Atividade-Modulo-4/pacote-save">
						<div class="mb-3">
							<input type="text" id="id" name="id" class="form-control" hidden value="${pacote.id }">
						</div>
						<div class="mb-3">
							<label for="nome" class="form-label">Nome:</label> <input
								type="text" id="nome" name="nome" class="form-control" value="${pacote.nome }" required>
						</div>
						<div class="mb-3">
							<label for="valor" class="form-label">Valor:</label> <input
								type="text" id="valor" name="valor" class="form-control"
								value="${pacote.valor}" required>
						</div>
						<div class="d-flex gap-2 justify-content-end mb-3">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancelar</button>
							<button class="btn btn-primary">Atualizar</button>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade dark" tabindex="-1" id="excluirModal${pacote.id}">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Deseja excluir esse registro?</h5>
        <div data-bs-theme="dark">
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
		</div>
      </div>
      <div class="modal-body">
	        <div class="mb-3">
				<p>ID: ${pacote.id}</p>
				<p>Nome: ${pacote.nome}</p>
				<p>Valor: ${pacote.valor}</p>
						</div>
			<div class="d-flex gap-2 justify-content-end mb-3">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Não</button>
				<a href="/Atividade-Modulo-4/pacote-delete?id=${pacote.id}" class="btn btn-danger">Sim</a>
			</div>
      </div>
    </div>
  </div>
</div>
		
				</jstl:forEach>
			</tbody>
		</table>
	</div>
		
	</main>
	
		  <!-- FOOTER -->
  <footer>

  </footer>
	
	  <!-- FOOTER -->
	
	<script src="./cadastro.js" type="module"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>