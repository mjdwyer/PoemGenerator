package poemgenerator

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class RulesSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid poem rule type creation"() {
		
		when:
		Rules poemRules = new Rules("POEM")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid line rule type creation"() {
		
		when:
		Rules poemRules = new Rules("LINE")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid noun rule type creation"() {
		
		when:
		Rules poemRules = new Rules("NOUN")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid pronoun rule type creation"() {
		
		when:
		Rules poemRules = new Rules("PRONOUN")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid adjective rule type creation"() {
		
		when:
		Rules poemRules = new Rules("ADJECTIVE")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid preposition rule type creation"() {
		
		when:
		Rules poemRules = new Rules("PREPOSITION")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test valid verb rule type creation"() {
		
		when:
		Rules poemRules = new Rules("VERB")
		
		then:
		poemRules.rules.size() > 0 
		
		
    }
	
    void "test invalid valid rule type creation"() {
		
		when:
		Rules poemRules = new Rules("BLAH")
		
		then:
		poemRules.rules == null
		
		
    }
}
