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
		<option value="${name.toLocaleLowerCase()}">${name}</option>
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