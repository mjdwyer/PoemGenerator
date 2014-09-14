package poemgenerator


class RulesFileParser {
	
	def rules = []
	def ruleTypes = []

	public RulesFileParser(){
		
		def rulesStream
		def br
		def line
		def ruleTemp = []
		
		rulesStream = this.class.classLoader.getResourceAsStream("rules.txt")
		
		if (rulesStream)
		{
			br = new BufferedReader(new InputStreamReader(rulesStream));
			if (br)
			{
				while ((line = br.readLine()) != null) {
					ruleTemp = line.split(": ")
					ruleTypes.add("<" + ruleTemp[0] + ">")
					rules.add(ruleTemp[1])
				}
			}
	
		}
		
	}
}

