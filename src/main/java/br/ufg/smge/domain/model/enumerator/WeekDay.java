package br.ufg.smge.domain.model.enumerator;

public enum WeekDay {
	MONDAY("Segunda-feira"), TUESDAY("Terça-feira"), WEDNESDAY("Quarta-feira"), THURSDAY("Quinta-feira"), FRIDAY(
			"Sexta-feira");

	private final String name;

	WeekDay(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
