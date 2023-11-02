export const Select = () => {
	const links = [
		{
			name: "Cliente"
		},
		{
			name: "Destino"
		},
		{
			name: "Pacote"
		},
		{
			name: "Reserva"
		},
		{
			name: "Contato"
		}
	]

	let options = []
	
	links.map(({name}) => {
		options.push(`
		<option value="/Atividade-Modulo-4/pages/cadastros/${name.toLowerCase()}">${name}</option>
		`)
	})
	
	options = options.join(" ")
	
	return `
		<select id="routes" class="mb-2">
			<option selected disabled>Escolha</option>
			${options}
		</select>
	`
}