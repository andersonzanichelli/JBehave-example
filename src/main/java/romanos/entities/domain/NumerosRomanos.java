package romanos.entities.domain;

import java.util.Arrays;

import javax.validation.constraints.Size;

public class NumerosRomanos {

	@Size(min = 1, max = 3999)
	private Integer number;
	private Integer[] decimals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	private String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public NumerosRomanos(Integer number) {
		this.number = number;
	}

	public String translate() {
		return searchTranslation(number, "", decimals, romans);
	}

	private String searchTranslation(Integer number, String roman, Integer[] decimalsRest, String[] romansRest) {
		if(decimalsRest.length > 0) {
			if(number < decimalsRest[0]) {
				return searchTranslation(number, roman, Arrays.copyOfRange(decimalsRest, 1, decimalsRest.length), Arrays.copyOfRange(romansRest, 1, romansRest.length));
			} else {
				return searchTranslation(number - decimalsRest[0], roman + romansRest[0], decimalsRest, romansRest);
			}
		} else {
			return roman;
		}
	}

}
