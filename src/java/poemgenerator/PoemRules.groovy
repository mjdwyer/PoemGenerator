package poemgenerator

	
class Rules {
		
		def ruleType
		def rules
		
		public Rules(final def ruleT){
			
		this.ruleType = ruleT
		
		RulesFileParser rfp = new RulesFileParser("rules.txt")
		
		rules = rfp.GetTypeRules(ruleType).split(" ")
		
		}
}
