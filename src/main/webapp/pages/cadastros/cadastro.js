import { Select } from "../../components/Select.js"

const select = document.querySelector(".select")
select.innerHTML = Select()

const selectRoutes = document.querySelector("#routes")

selectRoutes.addEventListener("change", () => {
	window.location = `${selectRoutes.value}`
})