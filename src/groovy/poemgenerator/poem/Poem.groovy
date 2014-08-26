package poemgenerator.poem


import java.util.Random

class Poem {
	
	def lines = []
	
	def noOfLines = 5
	
	def BuildPoem()
	{
		for (int i = 0; i < noOfLines; i++) {
			
			def line = new Line()
			
			lines.add(line.BuildLine())
			
		}
	}
	
}

class Line {
	
	Random rand = new Random()
	
	private allowableTypes = ["NOUN", "PREPOSITION", "PRONOUN"]
	
	private rnum = rand.nextInt(allowableTypes.size())
	
	def retString
	
	def BuildLine(){
		
		if (allowableTypes[rnum] == "NOUN"){
			def noun = new Noun()
			retString = noun.BuildNoun()
		}
		else if (allowableTypes[rnum] == "PREPOSITION"){
			def preposition = new Preposition()
			retString = preposition.BuildPreposition()
		}
		else if (allowableTypes[rnum] == "PRONOUN"){
			def pronoun = new Pronoun()
			retString =  pronoun.BuildPronoun()
		}
		
	}
}

class Noun {
	
	private Random randType = new Random()
	private Random randWord = new Random()
	
	private allowableWords = ["heart", "sun", "moon", "thunder",
		 "fire", "time", "wind", "sea", "river", "flavor","wave",
		 "willow", "rain", "tree", "flower","field","meadow",
		 "pasture","harvest","water","father","mother", "brother", "sister"]
	
	private allowableTypes = ["VERB", "PREPOSITION", "END"]
	
	private typeRnum = randType.nextInt(allowableTypes.size())
	private wordRnum = randWord.nextInt(allowableWords.size())
	
	def retString
	
	def BuildNoun(){
		
		retString = allowableWords[wordRnum]  + " "
		
		if (allowableTypes[typeRnum] == "VERB"){
			def verb = new Verb()
			retString = retString + " " + verb.BuildVerb()
		}
		else if (allowableTypes[typeRnum] == "PREPOSITION"){
			def preposition = new Preposition()
			retString = retString + " " + preposition.BuildPreposition()
		}
		else if (allowableTypes[typeRnum] == "END"){
			retString
		}

	}

	
}

class Verb{
	private Random randType = new Random()
	private Random randWord = new Random()
	
	private allowableWords = ["runs", "walks", "stands", "climbs",
		 "crawls", "flows", "flies", "transcends", "ascends", "descends","sinks"]
		
	private allowableTypes = ["PREPOSITION", "PRONOUN", "END"]
	
	private typeRnum = randType.nextInt(allowableTypes.size())
	private wordRnum = randWord.nextInt(allowableWords.size())
	
	def retString
	
	def BuildVerb(){
		
		retString = allowableWords[wordRnum] + " "
		
		if (allowableTypes[typeRnum] == "PREPOSITION"){
			def preposition = new Preposition()
			retString = retString + " " + preposition.BuildPreposition()
		}
		else if (allowableTypes[typeRnum] == "PRONOUN"){
			def pronoun = new Pronoun()
			retString =  retString + " "  + pronoun.BuildPronoun()
		}
		else if (allowableTypes[typeRnum] == "END"){
			retString
		}


	}

}

class Preposition{
	private Random randType = new Random()
	private Random randWord = new Random()
	
	private allowableWords = ["above", "across", "against", "along",
		 "among", "around", "before", "behind", "beneath", "beside","between",
		 "beyond", "during", "inside", "onto", "outside", "under","underneath",
		 "upon", "with", "without", "through"]
		
	private allowableTypes = ["NOUN", "PRONOUN", "ADJECTIVE"]
	
	private typeRnum = randType.nextInt(allowableTypes.size())
	private wordRnum = randWord.nextInt(allowableWords.size())
	
	def retString

	def BuildPreposition(){
		retString = allowableWords[wordRnum] + " "
		
		if (allowableTypes[typeRnum] == "NOUN"){
			def noun = new Noun()
			retString = retString + " " +  noun.BuildNoun()
		}
		else if (allowableTypes[typeRnum] == "PRONOUN"){
			def pronoun = new Pronoun()
			retString =  retString + " " + pronoun.BuildPronoun()
		}
		else if (allowableTypes[typeRnum] == "ADJECTIVE"){
			def adjective = new Adjective()
			retString =  retString + " " + adjective.BuildAdjective()
		}
		
	}
}

class Pronoun{
	private Random randType = new Random()
	private Random randWord = new Random()
	
	private allowableWords = ["my", "your", "his", "her"]
		
	private allowableTypes = ["NOUN", "ADJECTIVE"]
	
	private typeRnum = randType.nextInt(allowableTypes.size())
	private wordRnum = randWord.nextInt(allowableWords.size())
	
	def retString

	def BuildPronoun(){
		retString = allowableWords[wordRnum] + " "

				
		if (allowableTypes[typeRnum] == "NOUN"){
			def noun = new Noun()
			retString = retString + " " + noun.BuildNoun()
		}
		else  if (allowableTypes[typeRnum] == "ADJECTIVE"){
			def adjective = new Adjective()
			retString =  retString + " " + adjective.BuildAdjective()
		}
		
	}
}

class Adjective{
	private Random randType = new Random()
	private Random randWord = new Random()
	
	private allowableWords = ["black", "white", "dark", "light",
								"bright", "murky", "muddy", "clear"]
		
	private allowableTypes = ["NOUN", "ADJECTIVE"]
	
	private typeRnum = randType.nextInt(allowableTypes.size())
	private wordRnum = randWord.nextInt(allowableWords.size())
	
	def retString

	def BuildAdjective(){
		
		retString = allowableWords[wordRnum]
		
		if (allowableTypes[typeRnum] == "NOUN"){
			def noun = new Noun()
			retString = retString  + " " + noun.BuildNoun()
		}
		else if (allowableTypes[typeRnum] == "ADJECTIVE"){
			def adjective = new Adjective()
			retString =  retString  + " " +  adjective.BuildAdjective()
		}
	}
}

