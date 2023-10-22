import { Footer, Navbar, PromotionCard } from "../../components/index.js";
import { destinos } from "../../scripts/data.js";
import { onScroll, setCurrentPage } from "../../scripts/functions.js";

const header = document.querySelector("header")
const footer = document.querySelector("footer")

const main = document.querySelector("main")
const descontos = main.querySelector("#descontos")
const precos = main.querySelector("#precos")
const populares = main.querySelector("#populares")

window.addEventListener('scroll', onScroll)

header.innerHTML = Navbar()
footer.innerHTML = Footer()

setCurrentPage()

destinos.sort((a, b) => {
  return a.desconto > b.desconto ? -1 : a.desconto < b.desconto ? 1 : 0
})

for (let i = 0; i < 4; i++) {
  descontos.innerHTML += PromotionCard(destinos[i])
}

destinos.sort((a, b) => {
  return a.valor < b.valor ? -1 : a.valor > b.valor ? 1 : 0
})


for (let i = 0; i < 4; i++) {
  precos.innerHTML += PromotionCard(destinos[i])
}

destinos.sort((a, b) => {
  return a.popularidade > b.popularidade ? -1 : a.popularidade < b.popularidade ? 1 : 0
})

for (let i = 0; i < 4; i++) {
  populares.innerHTML += PromotionCard(destinos[i])
}