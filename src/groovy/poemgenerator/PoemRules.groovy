package poemgenerator

	
class Rules {
	
		private ruleTypes
		private rules
		
		public Rules(){
			
				
			RulesFileParser rfp = new RulesFileParser()
			
			ruleTypes = rfp.ruleTypes
			
			rules = rfp.rules
			
		}
}
