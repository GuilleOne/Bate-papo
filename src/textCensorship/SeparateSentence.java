package textCensorship;




public class SeparateSentence {
	
	private String[] frasesFortes = {"foda-se", "fuder"};
	
	public String[] separarFraseNormal(String e) {
		
		String[] vet = e.split(" ");
		
		return vet;
	}
	
	
	
	private String formatString(String e) {
		String[] vetor = e.split("");
		String novaWord="";
		
		for(int i = 0; i<vetor.length; i++) {
			vetor[i] = "*";
			novaWord += vetor[i];
		}
		
		return novaWord;
		
	}
	
	
	

	public String comparaPalavra(String e) {
		
		String novaString="";
		
		for(int i =0; i < frasesFortes.length; i++) {
			
			if(e.equals(frasesFortes[i])) {
				novaString = formatString(e);
			}
			
		}
		
		return novaString; 
	}
	

}
