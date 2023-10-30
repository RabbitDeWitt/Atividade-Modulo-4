import { Footer, Navbar, Select } from "../../components/index.js";
import { onScroll, verifyListPage } from "../../scripts/functions.js";

const header = document.querySelector("header")
const select = document.querySelector(".select")
const footer = document.querySelector("footer")

window.addEventListener('scroll', onScroll)

header.innerHTML = Navbar()
footer.innerHTML = Footer()

select.innerHTML = Select()
const selectRoutes = document.querySelector("#routes")

verifyListPage()

selectRoutes.addEventListener("change", () => {
	window.location = `${selectRoutes.value}`
})