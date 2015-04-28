package org.xiwc.semantic.entity;

public enum Sex {

	BOY(1), GIRL(2);

	private int value;

	private Sex(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}