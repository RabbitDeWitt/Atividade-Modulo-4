<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="./styles/styles.css"> -->
</head>
<body>

<section class="container">
	<div class="p-4">
		<button class="btn btn-primary mb-4" data-bs-toggle="modal"
			data-bs-target="#cadastroModal">Cadastrar cliente</button>

		<div class="modal fade dark" id="cadastroModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Cadastrar cliente</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form class="d-flex flex-column px-5"
						action="/Atividade-Modulo-4/cliente-save">
						<div class="mb-3">
							<label for="nome" class="form-label">Nome:</label> <input
								type="text" id="nome" name="nome" class="form-control" required>
						</div>
						<div class="mb-3">
							<label for="data" class="form-label">Data de nascimento:</label>
							<input type="date" id="data" name="data" class="form-control"
								required>
						</div>
						<div class="mb-3">
							<label for="telefone" class="form-label">Telefone:</label> <input
								type="text" id="telefone" name="telefone" class="form-control"
								required>
						</div>
						<div class="mb-3">
							<label for="numPassaporte" class="form-label">Número do
								passaporte:</label> <input type="text" id="numPassaporte"
								name="numPassaporte" class="form-control" required>
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


		<table class="table table-responsive table-hover table-primary table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Telefone</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Nº do Passaporte</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${clientes}" var="cliente">
					<tr>
						<th>${cliente.id}</th>
						<td>${cliente.nome}</td>
						<td>${cliente.telefone}</td>
						<td>${cliente.dataNasc}</td>
						<td>${cliente.numPassaporte}</td>
						<td>
							<a class="btn btn-warning"  data-bs-toggle="modal" data-bs-target="#atualizarModal${cliente.id}">Editar</a> 
							<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#excluirModal${cliente.id}">Excluir</a>
						</td>
					</tr>
					
					<div class="modal fade dark" id="atualizarModal${cliente.id}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Atualizar cliente</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form class="d-flex flex-column px-5"
						action="/Atividade-Modulo-4/cliente-save">
						<div class="mb-3">
							<input type="text" id="id" name="id" class="form-control" hidden value="${cliente.id }">
						</div>
						<div class="mb-3">
							<label for="nome" class="form-label">Nome:</label> <input
								type="text" id="nome" name="nome" class="form-control" value="${cliente.nome }" required>
						</div>
						<div class="mb-3">
							<label for="data" class="form-label">Data de nascimento:</label>
							<input type="date" id="data" name="data" class="form-control"
							value="${cliente.dataNasc }"	required>
						</div>
						<div class="mb-3">
							<label for="telefone" class="form-label">Telefone:</label> <input
								type="text" id="telefone" name="telefone" class="form-control"
								value="${cliente.telefone }" required>
						</div>
						<div class="mb-3">
							<label for="numPassaporte" class="form-label">Número do
								passaporte:</label> <input type="text" id="numPassaporte"
								name="numPassaporte" class="form-control" value="${cliente.numPassaporte }" required>
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
		
		<div class="modal" tabindex="-1" id="excluirModal${cliente.id}">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Deseja excluir esse registro?</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
	        <div class="mb-3">
				<p>ID: ${cliente.id}</p>
				<p>Nome: ${cliente.nome}</p>
				<p>Telefone: ${cliente.telefone}</p>
				<p>Data de Nascimento: ${cliente.dataNasc}</p>
				<p>Nº do Passaporte: ${cliente.numPassaporte}</p>
						</div>
			<div class="d-flex gap-2 justify-content-end mb-3">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Não</button>
				<a href="/Atividade-Modulo-4/cliente-delete?id=${cliente.id}" class="btn btn-danger">Sim</a>
			</div>
      </div>
    </div>
  </div>
</div>
		
				</jstl:forEach>
			</tbody>
		</table>
	</div>
		
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar exclusão?</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja excluir esse cliente?
      </div>
      <div class="modal-footer">
        <a class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</a>
        <a href="/Atividade-Modulo-4/cliente-delete?id=${id}" class="btn btn-danger">Excluir</a>
      </div>
    </div>
  </div>
</div>
		
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>