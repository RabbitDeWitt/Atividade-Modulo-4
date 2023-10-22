import { Footer, Navbar } from "../../components/index.js";
import { onScroll, setCurrentPage } from "../../scripts/functions.js";

const header = document.querySelector("header")
const footer = document.querySelector("footer")

window.addEventListener('scroll', onScroll)

header.innerHTML = Navbar()
footer.innerHTML = Footer()

setCurrentPage()
