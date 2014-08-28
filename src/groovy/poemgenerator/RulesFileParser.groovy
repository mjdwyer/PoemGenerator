package poemgenerator


class RulesFileParser {
	
	private InputStream rulesStream
	private BufferedReader br

	public RulesFileParser(String inFileName){
		
		rulesStream = this.class.classLoader.getResourceAsStream(inFileName)
		
		
		br = new BufferedReader(new InputStreamReader(rulesStream));
		
		
	}
	

	public GetTypeRules(String ruleType){
		
		String line;
		def lineArray
		def rulesArray
		def rulesString
		def rules
	
		while ((line = br.readLine()) != null) {
			if (line.substring(0, ruleType.size()) == ruleType){
				lineArray = line.split(": ")
				rulesString = lineArray[1]
				break
			}
		}
		
		rulesString
		
	}


	
}
