package poemgenerator

class BuildPoemController {
	
	def PoemService
	
    def index = {
		
	   redirect (action: MakePoem)
	}
	
	def MakePoem = {

		def lines = PoemService.getPoem()
		
		[lines: lines]
	}
	

	
}
