package com.kholofelo.practises.entities;

public class Rover {

	private Coordinate initCoordinates;
	private Coordinate currentPosition;

	public Rover(Coordinate initCoordinates) {
		super();
		this.initCoordinates = initCoordinates;
		this.currentPosition = initCoordinates;
	}

	public Coordinate getInitCoordinates() {
		return initCoordinates;
	}

	public void setInitCoordinates(Coordinate initCoordinates) {
		this.initCoordinates = initCoordinates;
	}

	public Coordinate getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Coordinate finalCordiCoordinates) {
		this.currentPosition = finalCordiCoordinates;
	}

}
