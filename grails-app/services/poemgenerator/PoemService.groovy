package poemgenerator

import grails.transaction.Transactional
import java.util.Random


@Transactional
class PoemService {
	
	def lines = []
	
	def line= ""
	
	Rules poemRules = new Rules("POEM")
	Rules lineRules = new Rules("LINE")
	Rules adjectiveRules = new Rules("ADJECTIVE")
	Rules nounRules = new Rules("NOUN")
	Rules pronounRules = new Rules("PRONOUN")
	Rules prepositionRules = new Rules("PREPOSITION")
	Rules verbRules = new Rules("VERB")
	
    def getPoem() {
		
		lines.clear()
		
		for(int i = 0; i < poemRules.rules.size(); i++){
			
			ProcessRule(lineRules)
		}

    }
	
	def private ProcessRule(Rules ruleObj){
		
		def ruleValue
		String ruleItem
		
		for(int i = 0; i < ruleObj.rules.size(); i++){
			
			ruleItem = ruleObj.rules[i]
			
			if (ruleItem.indexOf("|") > 0)
			{
				ruleValue = GetRandomValue(ruleItem)
			}
			else
			{
				ruleValue = ruleItem
			}
			
			if (ruleValue.indexOf("<") >= 0)
			{
				switch ( ruleValue ) {
				    case "<NOUN>":
				        ProcessRule(nounRules)
				        break
				
				    case "<ADJECTIVE>":
				        ProcessRule(adjectiveRules)
				        break
				
				    case "<PREPOSITION>":
				        ProcessRule(prepositionRules)
				        break
				
				    case "<PRONOUN>":
				        ProcessRule(pronounRules)
				        break
				
				    case "<VERB>":
				        ProcessRule(verbRules)
				        break
				
				    default:
				        ruleValue = "default"
				}
			}
			else if (ruleValue.indexOf("\$") >= 0) 
			{
				if (ruleValue == "\$LINEBREAK")
				{
					lines.add(line)
					line = ""
				}
			}
			else // this is a plain text word
			{
				line = line + " " + ruleValue
			}
		}
		
	}
	
	
	def private GetRandomValue(def strIn){
		
		def inArr = strIn.split("\\|")
		
		def retVal
		
		Random randValue = new Random()
		def typeRnum = randValue.nextInt(inArr.size())
		
		retVal = inArr[typeRnum]
		
	}
	
	
	
}
