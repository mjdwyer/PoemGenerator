package poemgenerator
import poemgenerator.poem.Poem

class BuildPoemController {

    def index = {
	   redirect (action: MakePoem)
	}
	
	def MakePoem = {
		def poem = new Poem()
		
		def numLines = poem.noOfLines
		
		poem.BuildPoem()
		
	   [lines: poem.lines, lineNums: numLines]
	}
	
}
