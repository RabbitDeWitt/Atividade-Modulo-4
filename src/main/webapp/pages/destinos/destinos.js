import { DestinationCard, Footer, Navbar } from "../../components/index.js";
import { destinos } from "../../scripts/data.js";
import { onScroll, setCurrentPage } from "../../scripts/functions.js";

const header = document.querySelector("header")
const footer = document.querySelector("footer")

window.addEventListener('scroll', onScroll)

header.innerHTML = Navbar()
footer.innerHTML = Footer()

setCurrentPage()


destinos.sort((a, b) => {
  return a.nome < b.nome ? -1 : a.nome > b.nome ? 1 : 0
})

destinos.map((destino) => {
  destino.tipo === "nacional" ?
    nacionais.innerHTML += DestinationCard(destino) :
    internacionais.innerHTML += DestinationCard(destino)
})