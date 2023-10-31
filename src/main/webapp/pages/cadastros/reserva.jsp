<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva</title>
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
	
	<h1>Lista de Reservas</h1>
	
		<button class="btn btn-primary mb-4" data-bs-toggle="modal"
			data-bs-target="#cadastroModal">Cadastrar reserva</button>

		<div class="modal fade dark" id="cadastroModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Cadastrar reserva</h1>
			<div data-bs-theme="dark">
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
			</div>
					</div>
					<div class="px-5">
					<form class="d-flex flex-column"
						action="/Atividade-Modulo-4/reserva-save">
						<div class="mb-3">
							<label for="cliente" class="form-label">Cliente:</label>
							<select class="form-select" id="cliente" name="cliente" class="form-control" required>
							<jstl:forEach items="${clientes}" var="cliente">
								<option value="${cliente.id}">${cliente.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="destino" class="form-label">Destino:</label>
							<select class="form-select" id="destino" name="destino" class="form-control" required>
							<jstl:forEach items="${destinos}" var="destino">
								<option value="${destino.id}">${destino.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="pacote" class="form-label">Pacote:</label>
							<select class="form-select" id="pacote" name="pacote" class="form-control" required>
							<jstl:forEach items="${pacotes}" var="pacote">
								<option value="${pacote.id}">${pacote.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="dataPartida" class="form-label">Data de Partida:</label>
							<input type="date" id="dataPartida" name="dataPartida" class="form-control"
								required>
						</div>
						<div class="mb-3">
							<label for="dataRetorno" class="form-label">Data de Retorno:</label>
							<input type="date" id="dataRetorno" name="dataRetorno" class="form-control"
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


<div class="table-responsive ">
		<table class="table table-hover table-primary table-striped">
			<thead class="table-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Cliente</th>
					<th scope="col">Destino</th>
					<th scope="col">Pacote</th>
					<th scope="col">Valor</th>
					<th scope="col">Data de Partida</th>
					<th scope="col">Data de Retorno</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${reservas}" var="reserva">
					<tr>
						<th>${reserva.id}</th>
						<td>${reserva.cliente.nome}</td>
						<td>${reserva.destino.nome}</td>
						<td>${reserva.pacote.nome}</td>
						<td>R$ ${reserva.valorTotal}</td>
						<td>${reserva.dataPartida}</td>
						<td>${reserva.dataRetorno}</td>
						<td class="">
							<a class="btn btn-warning"  data-bs-toggle="modal" data-bs-target="#atualizarModal${reserva.id}">Editar</a> 
							<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#excluirModal${reserva.id}">Excluir</a>
						</td>
					</tr>
					
					<div class="modal fade dark" id="atualizarModal${reserva.id}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">
							Atualizar reserva</h1>
			<div data-bs-theme="dark">
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
			</div>
					</div>
					<div class="px-5">
					<form class="d-flex flex-column"
						action="/Atividade-Modulo-4/reserva-save">
						<div class="mb-3">
							<input type="text" id="id" name="id" class="form-control" hidden value="${reserva.id }">
						</div>
						<div class="mb-3">
							<label for="cliente" class="form-label">Cliente:</label>
							<select class="form-select" id="cliente" name="cliente" class="form-control" required>
							<option value="${reserva.cliente.id}" selected>${reserva.cliente.nome}</option>
							<jstl:forEach items="${clientes}" var="cliente">
								<option value="${cliente.id}">${cliente.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="destino" class="form-label">Destino:</label>
							<select class="form-select" id="destino" name="destino" class="form-control" required>
								<option value="${reserva.destino.id}" selected>${reserva.destino.nome}</option>
							<jstl:forEach items="${destinos}" var="destino">
								<option value="${destino.id}">${destino.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="pacote" class="form-label">Pacote:</label>
							<select class="form-select" id="pacote" name="pacote" class="form-control" required>
							<option value="${reserva.pacote.id}" selected>${reserva.pacote.nome}</option>
							<jstl:forEach items="${pacotes}" var="pacote">
								<option value="${pacote.id}">${pacote.nome}</option>
							</jstl:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label for="dataPartida" class="form-label">Data de Partida:</label>
							<input type="date" id="dataPartida" name="dataPartida" class="form-control"
								value="${reserva.dataPartida }" required>
						</div>
						<div class="mb-3">
							<label for="dataRetorno" class="form-label">Data de Retorno:</label>
							<input type="date" id="dataRetorno" name="dataRetorno" class="form-control"
								value="${reserva.dataRetorno }" required>
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
		
		<div class="modal fade dark" tabindex="-1" id="excluirModal${reserva.id}">
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
				<p>ID: ${reserva.id}</p>
				<p>Nome: ${reserva.cliente.nome}</p>
				<p>Destino: ${reserva.destino.nome}</p>
				<p>Pacote: ${reserva.pacote.nome}</p>
				<p>Data de Partida: ${reserva.dataPartida}</p>
				<p>Data de Retorno: ${reserva.dataRetorno}</p>
				<p>Valor: R$ ${reserva.valorTotal}</p>
						</div>
			<div class="d-flex gap-2 justify-content-end mb-3">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Não</button>
				<a href="/Atividade-Modulo-4/reserva-delete?id=${reserva.id}" class="btn btn-danger">Sim</a>
			</div>
      </div>
    </div>
  </div>
</div>
		
				</jstl:forEach>
			</tbody>
		</table>
		</div>
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