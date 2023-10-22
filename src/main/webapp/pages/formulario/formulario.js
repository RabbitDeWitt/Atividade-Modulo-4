import { Footer, FormCliente, FormDestino, FormPacote, FormReserva, Navbar } from '../../components/index.js'

const header = document.querySelector("header")
const footer = document.querySelector("footer")

const select = document.querySelector("#selecaoFormulario")
const sectionForm = document.querySelector("#formulario")

header.innerHTML = Navbar()
footer.innerHTML = Footer()

sectionForm.innerHTML = FormCliente()


select.addEventListener("change", () => {
  switch (select.value) {
    case "1":
      sectionForm.innerHTML = FormCliente()
      break
    case "2":
      sectionForm.innerHTML = FormDestino()
      break
    case "3":
      sectionForm.innerHTML = FormPacote()
      break
    case "4":
      sectionForm.innerHTML = FormReserva()
      break
  }
}) 