import { DestinationCard, Footer, Navbar, PromotionCard } from '../../components/index.js'
import { destinos } from "../../scripts/data.js";
import { onScroll, setCurrentPage } from "../../scripts/functions.js";

const header = document.querySelector("header")

const carousel = document.querySelector('.carousel')
const carouselIndicators = carousel.querySelector('.carousel-indicators')
const carouselInner = carousel.querySelector('.carousel-inner')

const destiny = document.querySelector('#destinos')
const destinyCardsSection = destiny.querySelector('.card-section')

const promotion = document.querySelector('#promocoes')
const promotionCardsSection = promotion.querySelector('.card-section')

const footer = document.querySelector("footer")

window.addEventListener('scroll', onScroll)

header.innerHTML = Navbar()
footer.innerHTML = Footer()

setCurrentPage()

let randomNums = []
while (randomNums.length < 7) {
  let num = parseInt(Math.random() * destinos.length)
  if (randomNums.indexOf(num) === -1) randomNums.push(num)
}


/* CAROUSEL IMGS */
for (let index = 0; index < randomNums.length; index++) {

  const num = randomNums[index]
  const { nome, img, descricao } = destinos[num];


  if (index < 3) {
    carouselIndicators.innerHTML += `
  <button type="button" data-bs-target="#carouselExampleFade" data-bs-slide-to="${index}" class="${index == 0 ? 'active' : ''}"
          aria-current="true" aria-label="Slide ${index + 1}"></button>
  `
    carouselInner.innerHTML += `
  <div class="carousel-item ${index == 0 ? 'active' : ''}" data-bs-interval="5000">
          <img src="../../assets/imgs/${img}.jpg" class="d-block w-100" alt="Imagem de ${nome}">
           <div class="carousel-caption px-2 d-none d-md-block">
            <h4>${nome}</h4>
            <p>${descricao}</p>
           </div>
  </div> 
  `
  } else if (index < 5) {
    destinyCardsSection.innerHTML += DestinationCard(destinos[num])
  } else {
    promotionCardsSection.innerHTML += PromotionCard(destinos[num])
  }
}