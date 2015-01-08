package romanos.stories;

import junit.framework.Assert;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;

import romanos.entities.domain.NumerosRomanos;

@Component
public class NumerosRomanosSteps {
	
	private NumerosRomanos numerosRomanos;
	
	@BeforeScenario
    public void beforeScenario() {
		this.numerosRomanos = null;
	}

	@Given("the [number] to translate")
	public void givenTheNumberToConvert(@Named("number") Integer number) {
		numerosRomanos = new NumerosRomanos(number);
	}
	
	@Then("the translation is [roman]")
	public void thenTheResultIs(@Named("roman") String roman) {
		Assert.assertEquals(roman, numerosRomanos.translate());
	}
}
