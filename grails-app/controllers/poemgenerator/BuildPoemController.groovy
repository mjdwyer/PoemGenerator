package poemgenerator

class BuildPoemController {
	
	def poemSvc

    def index = {
		poemSvc = new PoemService()
		
	   redirect (action: MakePoem)
	}
	
	def MakePoem = {
	
		poemSvc.getPoem()
		
		[lines: poemSvc.lines]
	}
	

	
}
