package com.kholofelo.practises.services;

import com.kholofelo.practises.entities.Coordinate;
import com.kholofelo.practises.entities.Coordinate.Heading;
import com.kholofelo.practises.entities.Rover;
import com.kholofelo.practises.exceptions.InvalidInstruction;

public class RoverMovement {

    private Coordinate plateuCoordinates;
    private Rover rover;
    private final String RIGHT_TURN_INSTRUCTION = "R";
    private final String LEFT_TURN_INSTRUCTION = "L";
    private final String MOVE_INSTRUCTION = "M";

    public void setPlateuCoordinates(final int x, final int y) {
        plateuCoordinates = new Coordinate(x, y);
    }

    public Coordinate getPlateuCoordinates() {
        return plateuCoordinates;
    }

    public void setRoverPosition(int x, int y, Heading heading) {
        this.rover = new Rover(new Coordinate(x, y, heading));
    }

    public Coordinate getRoverPosition() {
        return this.rover.getCurrentPosition();
    }

    public void execInstruction(String instructionSet) {
        int index = 0;
        for (; index < instructionSet.length(); index++) {
            String specificInstruction = String.valueOf(instructionSet.charAt(index));
            performInstruction(specificInstruction);
        }

    }

    private void performInstruction(String specificInstruction) {
        specificInstruction = specificInstruction.toUpperCase();

        if (RIGHT_TURN_INSTRUCTION.equals(specificInstruction) || LEFT_TURN_INSTRUCTION.equals(specificInstruction)) {
            this.rover.getCurrentPosition().setHeading(this.rover.getCurrentPosition().getHeading().getNewHeading(specificInstruction));
        } else if (MOVE_INSTRUCTION.equals(specificInstruction)) {
            moveRover();
        } else {
            throw new InvalidInstruction("Instruction, " + specificInstruction + " is not recognised");
        }
    }

    private void moveRover() {
        final Coordinate currentPosition = this.rover.getCurrentPosition();

        if (currentPosition.getHeading().equals(Coordinate.Heading.NORTH)) {
            currentPosition.setY(currentPosition.getY() + 1);
        } else if (currentPosition.getHeading().equals(Coordinate.Heading.SOUTH)) {
            currentPosition.setY(currentPosition.getY() - 1);
        } else if (currentPosition.getHeading().equals(Coordinate.Heading.WEST)) {
            currentPosition.setX(currentPosition.getX() - 1);
        } else if (currentPosition.getHeading().equals(Coordinate.Heading.EAST)) {
            currentPosition.setX(currentPosition.getX() + 1);
        }
    }
}
