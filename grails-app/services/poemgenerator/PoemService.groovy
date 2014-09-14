package poemgenerator

import grails.transaction.Transactional
import java.util.Random


@Transactional
class PoemService {
	
	Rules theRules
	

	def getPoem() {
		
		def ruleItem
		def lines = []
		def line = ""
		
		theRules = new Rules()
		
		def poemIndex =  theRules.ruleTypes.findIndexOf { name -> name == "<POEM>"} 
		
		def poemRules = theRules.rules[poemIndex].split(" ")
		
		for(int i = 0; i < poemRules.size(); i++){
			
			ruleItem = poemRules[i]
			
			line = ProcessRule(ruleItem, line)
			
			lines.add(line)
			
			line= ""
		}
		
		lines

    }
	
	def private ProcessRule(ruleItem, line){
		
		def ruleValue
		def ruleIdx
		
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
			
			ruleIdx =  theRules.ruleTypes.findIndexOf { name -> name == ruleValue} 
			
			def rules = theRules.rules[ruleIdx].split(" ")
			
			for(int i = 0; i < rules.size(); i++){
				
				ruleItem = rules[i]
				
				line = ProcessRule(ruleItem, line)
		
			}
		}
		else if (ruleValue.indexOf("\$") >= 0) 
		{
			//just return - end of line
		}
		else // this is a plain text word
		{
			line = line + " " + ruleValue
		}
		
		line
		
	}
	
	
	def private GetRandomValue(def strIn){
		
		def inArr = strIn.split("\\|")
		
		def retVal
		
		Random randValue = new Random()
		def typeRnum = randValue.nextInt(inArr.size())
		
		retVal = inArr[typeRnum]
		
	}
	
	
	
}
