package poemgenerator

	
class Rules {
		
		def ruleType
		def rules
		private retString
		
		public Rules(final def ruleT){
			
		this.ruleType = ruleT
		
		RulesFileParser rfp = new RulesFileParser("rules.txt")
		
		retString = rfp.GetTypeRules(ruleType)
		
		if (retString != null){
			rules = retString.split(" ")
		}
		
		rules
		
		}
}
