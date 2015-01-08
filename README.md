BDD com JBehave

Realização de teste unitário com o framework JBehave que suporta Behaviour-Driven Development (BDD).
A vantagem de utilização deste, é que a escrita do teste fica bem mais simples e muito mais expressivo, tão expressivo ao ponto de fazer com que pessoas, que não são da áreas de testes mas conhecem muito bem as regras de negócio, possam escrever o comportamento que esperam da aplicação.

Nesse pequeno exemplo foi utilizado o problema da tradução de números decimais para números romanos.
O conhecedor das regras de negócio escreve o comportamento que ele espera:

```
NumerosRomanos.story
Narrative:
In order to put a number in decimal format
As a curiosity person
I want to know the number representation in roman format

Scenario:  The numbers to translate to roman
Given the [number] to translate
Then the translation is [roman]

Examples:
|number|roman|
|1|I|
|3|III|
|5|V|
|6|VI|
|7|VII|
|10|X|
|30|XXX|
|300|CCC|
|2015|MMXV|
|3000|MMM|
```

E o desenvolvedor cria o teste baseado nesses compontamentos esperados:

```java
NumerosRomanosSteps.java
public class NumerosRomanosSteps {
	
	private NumerosRomanos numerosRomanos;
	
	@BeforeScenario
    public void beforeScenario() {
		this.numerosRomanos = null;
	}

	@Given("the [number] to translate")
	public void givenTheNumberToTranslate(@Named("number") Integer number) {
		numerosRomanos = new NumerosRomanos(number);
	}
	
	@Then("the translation is [roman]")
	public void thenTheTranslationIs(@Named("roman") String roman) {
		Assert.assertEquals(roman, numerosRomanos.translate());
	}
}
```
Outra grande vantagem que podemos perceber é que a classe de teste não é preenchida com vários casos de testes duplicados com apenas a modificação de váriáveis.
