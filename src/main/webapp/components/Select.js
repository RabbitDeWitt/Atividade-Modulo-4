export const Select = () => {
	const links = [
		{
			name: "Cliente",
			route: "Atividade-Modulo-4/pages/cadastros/cliente"
		},
		{
			name: "Destino",
			route: "Atividade-Modulo-4/pages/cadastros/destino"
		},
		{
			name: "Pacote",
			route: "Atividade-Modulo-4/pages/cadastros/pacote"
		},
		{
			name: "Reserva",
			route: "Atividade-Modulo-4/pages/cadastros/reserva"
		},
		{
			name: "Contato",
			route: "Atividade-Modulo-4/pages/cadastros/contato"
		}
	]

	let options = []
	
	links.map(({name, route}) => {
		options.push(`
		<option value="${route}">${name}</option>
		`)
	})
	
	options = options.join(" ")
	
	return `
		<select id="routes">
			<option selected disabled>Escolha</option>
			${options}
		</select>
	`
}