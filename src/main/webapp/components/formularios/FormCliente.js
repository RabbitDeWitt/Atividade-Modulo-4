export const FormCliente = () => {
  return `
  <form class="d-flex gap-3 flex-column" action="/Atividade-Modulo-4/cliente-save" method="post">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome:</label>
      <input type="text" id="nome" name="nome" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="data" class="form-label">Data de nascimento:</label>
      <input type="date" id="data" name="data" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="telefone" class="form-label">Telefone:</label>
      <input type="text" id="telefone" name="telefone" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="numPassaporte" class="form-label">Número do passaporte:</label>
      <input type="text" id="numPassaporte" name="numPassaporte" class="form-control" required>
    </div>
    <button class="btn btn-primary me-auto">Cadastrar</button>
  </form>
  `
}
