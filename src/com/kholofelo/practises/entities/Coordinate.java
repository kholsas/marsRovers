package com.kholofelo.practises.entities;

public class Coordinate {

	private int x;
	private int y;
	private Heading heading;

	public Coordinate(int x, int y) {
		this(x, y, null);
	}

	public Coordinate(int x, int y, Heading heading) {
		super();
		this.x = x;
		this.y = y;
		this.heading = heading;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public String printCoordinates() {
		return this.x + " " + this.y;
	}

	public String printPosition() {
		return this.printCoordinates() + " " + this.heading.head;
	}

	public enum Heading {
		NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

		private final String head;
		private Heading newHeading;

		private Heading(String head) {
			this.head = head;
		}

		public Heading getNewHeading(final String direction) {
			if ("N".equals(this.head) && direction.equals("L")) {
				return Heading.WEST;
			} else if ("S".equals(this.head) && direction.equals("L")) {
				return Heading.EAST;
			} else if ("E".equals(this.head) && direction.equals("L")) {
				return Heading.NORTH;
			} else if ("W".equals(this.head) && direction.equals("L")) {
				return Heading.SOUTH;
			}
			// Right turn
			if ("N".equals(this.head) && direction.equals("R")) {
				return Heading.EAST;
			} else if ("S".equals(this.head) && direction.equals("R")) {
				return Heading.WEST;
			} else if ("E".equals(this.head) && direction.equals("R")) {
				return Heading.SOUTH;
			} else if ("W".equals(this.head) && direction.equals("R")) {
				return Heading.NORTH;
			}
			return null;
		}

		public String getHead() {
			return head;
		}
	}
}
