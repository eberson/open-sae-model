package br.org.open.sae.model;

public enum TipoNecessidade {
	
	AUDITIVA{
		public void configure(NecessidadeEspecial deficiencia) {
			deficiencia.setDescricao("Portador de deficiência auditiva");
		};
	},
	VISUAL{
		public void configure(NecessidadeEspecial deficiencia) {
			deficiencia.setDescricao("Portador de deficiência visual");
		};
	},
	FISICA{
		public void configure(NecessidadeEspecial deficiencia) {
			deficiencia.setDescricao("Portador de deficiência física");
		};
	},
	OUTRA;
	
	public void configure(NecessidadeEspecial deficiencia){
		deficiencia.setDescricao("Portador de outra necessidade especial");
	}

}
