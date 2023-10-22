export const DestinationCard = ({ img, nome, descricaoMaior }) => {
  return `
        <div class="card" style="width: 18rem;">
          <img src="../../assets/imgs/min/${img}_min.jpg" class="card-img-top" alt="Imagem de ${nome}">
          <div class="card-body">
            <h5 class="card-title">${nome}</h5>
            <p class="card-text">${descricaoMaior}
            </p>
          </div>
        </div>
`
}