export const FormPacote = () => {
  return `
  <form class="d-flex gap-3 flex-column" action="/Atividade-Modulo-4/pacote-save" method="post">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome:</label>
      <input type="text" id="nome" class="form-control" name="nome" required>
    </div>
    <div class="mb-3">
      <label for="valor" class="form-label">Valor:</label>
      <input type="text" id="valor" class="form-control" name="valor" required>
    </div>
    <button class="btn btn-primary me-auto">Cadastrar</button>
  </form>
  `
}