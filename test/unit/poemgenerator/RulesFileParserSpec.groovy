package poemgenerator

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class RulesFileParserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test handles valid rule file"() {
		
		when:
		def retString
		
		RulesFileParser rfp = new RulesFileParser("rules.txt")
		
		retString = rfp.GetTypeRules("POEM")
		
		then:
		retString.size() > 0

    }
	void "test handles invalid rule file"() {
		
		when:
		def retString
		
		RulesFileParser rfp = new RulesFileParser("blah.txt")
		
		retString = rfp.GetTypeRules("POEM")
		
		then:
		retString == null

	}

}
