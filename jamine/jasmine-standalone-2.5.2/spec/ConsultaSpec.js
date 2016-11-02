describe("Consulta", function() {

	var guilherme;

	beforeEach(function() {
		guilherme = new PacienteBuilder().comPeso(10).constroi();
	});

	describe("consultas do tipo retorno", function() {
		it("nao deve cobrar nada se for um retorno", function() {	
			var consulta = new Consulta(guilherme, [], true, true);

			expect(consulta.preco()).toEqual(0);
		});
	});
	
	describe("consultas com procedimentos", function() {
		it("deve cobrar 25 por cada procedimento comum", function() {
			var consulta = new Consulta(guilherme, ["proc1", "proc2"], false, false);

			expect(consulta.preco()).toEqual(50);
		});

		it("deve cobrar preco especifico dependendo do procedimento", function() {
			var consulta = new Consulta(guilherme, ["procedimento-comum", "raio-x", "procedimento-comum", "gesso"], false, false);

			expect(consulta.preco()).toEqual(25 + 55 + 25 + 32);
		});
	});

});