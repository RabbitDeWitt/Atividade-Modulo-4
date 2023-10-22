export const FormReserva = () => {
  return `
        <form class="d-flex gap-3 flex-column">
          <div class="mb-3">
            <label for="nome" class="form-label">Cliente:</label>
            <input type="text" id="nome" class="form-control">
          </div>
          <div class="mb-3">
            <label for="estado" class="form-label">Destino:</label>
            <input type="text" id="estado" class="form-control" maxlength="2">
          </div>
          <div class="mb-3">
            <label for="estado" class="form-label">Pacote:</label>
            <input type="text" id="estado" class="form-control" maxlength="2">
          </div>
          <div class="d-flex mb-3 gap-3 datas">
            <div>
              <label for="dataPartida" class="form-label">Data de Partida:</label>
              <input type="date" id="dataPartida" class="form-control">
            </div>
            <div>
              <label for="dataRetorno" class="form-label">Data de Retorno:</label>
              <input type="date" id="dataRetorno" class="form-control">
            </div>
          </div>
          <button class="btn btn-primary me-auto">Cadastrar</button>
        </form>
  `
}
