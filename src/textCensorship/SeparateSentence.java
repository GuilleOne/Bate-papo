package textCensorship;




public class SeparateSentence {
	
	public String[] frasesFortes = {"foda-se", "fuder", "foder", 
									"caralho", "puta", "puto",
									"viadinho", "viado", "imbecil",
									"porra"};
	
	String mensagem = "";
	
	public String[] separarFraseNormal(String e) {
		
		String[] vet = e.split(" ");
		
		return vet;
	}
	
	
	public String formatString(String e) {
		String[] vetor = e.split("");
		String novaWord="";
		
		for(int i = 0; i<vetor.length; i++) {
			vetor[i] = "*";
			novaWord += vetor[i];
		}
		
		return novaWord;
		
	}
	
	
	public String newFrase(String[] vet) {
		String msg="";
		
		for(int i =0; i<vet.length; i++) {
			for(int j=0; j<this.frasesFortes.length; j++) {
				if(vet[i].equalsIgnoreCase(frasesFortes[j])) {
					vet[i] = this.formatString(vet[i]);
				}
			}
			msg += ' '+vet[i];
		}	
		
		return msg.trim();
	}
	
	
//	public String comparaPalavra(String e) {
//		
//		String novaString = null;
//		
//		for(int i =0; i < frasesFortes.length; i++) {
//			
//			if(e.equals(frasesFortes[i])) {
//				novaString = formatString(e);
//			}
//			
//		}
//		
//		return novaString; 
//	}
//	

}
