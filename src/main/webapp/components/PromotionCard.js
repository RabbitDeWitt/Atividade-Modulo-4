export const PromotionCard = ({ img, nome, valor, desconto }) => {
  const valorComDesconto = valor - (valor * (desconto / 100))
  return `
        <div class="card" style="width: 18rem;">
          <img src="../../assets/imgs/min/${img}_min.jpg" class="card-img-top" alt="Imagem de ${nome}">
          <div class="card-body">
            <h5 class="card-title">${nome}</h5>
          </div>
          <ul class="list-group list-group-flush position-relative bg-bg-danger  ">
          <li class="list-group-item">
          <p class="my-2 mb-1 text-secondary " style="font-size: 14px;">Preço por pessoa</p>
          <p class="mb-0 text-decoration-line-through text-secondary " style="font-size: 15px;">R$ ${valor.toFixed(2)}</p>
          <p class="mb-0" style="font-size: 25px; color: black !important;">R$ ${valorComDesconto.toFixed(2)}</p>
          <span class="position-absolute top-0 translate-middle badge rounded-pill bg-success" style="left: 35px; color: white !important;">
        ${desconto}% Off
        <span class="visually-hidden">unread messages</span>
          </li>
          </ul>
          <div class="card-body d-flex align-items-center justify-content-between">
            <a href="#" class="btn btn-primary">Comprar</a>
            <a href="#" class="btn btn-primary">Saiba mais</a>
          </div>
        </div>
  `
}