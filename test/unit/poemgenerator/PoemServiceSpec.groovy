package poemgenerator

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PoemService)
class PoemServiceSpec extends Specification {

    def setup() {
		
    }

    def cleanup() {
    }

    void "test something"() {
		
		when:
		def rTypes = ["<POEM>", "<LINE>", "<ADJECTIVE>","<NOUN>", "<PRONOUN>", "<VERB>","<PREPOSITION>"]
		def rRules = [
			"<LINE> <LINE> <LINE> <LINE> <LINE>",
			"<NOUN>|<PREPOSITION>|<PRONOUN> \$LINEBREAK",
			"black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|\$END",
			"heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|tree|flower|field|meadow|pasture|harvest|water|father|mother|brother|sister <VERB>|<PREPOSITION>|\$END",
			"my|your|his|her <NOUN>|<ADJECTIVE>",
			"runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|\$END",
			"above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>"
			]
		def vRules = mockFor(Rules)
		vRules.setProperty ('ruleTypes', rTypes)
		vRules.setProperty ('rules', rRules)

		def testService = new PoemService() 
		testService.Rules = vRules.createMock()
		
		def lines = testService.getPoem()
		
		then:
		
		lines.size() == 5
		
		
    }
}
