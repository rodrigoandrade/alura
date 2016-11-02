describe("Paciente", function() {

	it("Deve calcular o imc", function() {
		var guilherme = new Paciente("Guilherme", 28, 72, 1.82);

		var imc = guilherme.imc();
		expect(imc).toEqual(72 / (1.82 * 1.82));
	});

	it("Deve testar a quantidade de batimentos de um paciente", function() {
		var guilherme = new Paciente("Guilherme", 28, 72, 1.82);

		var batimentos = guilherme.batimentos();
		expect(batimentos).toEqual(28 * 365 * 24 * 60 * 80);
	});

});