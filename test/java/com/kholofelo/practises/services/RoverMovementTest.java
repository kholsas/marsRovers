package com.kholofelo.practises.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.kholofelo.practises.entities.Coordinate;
import com.kholofelo.practises.exceptions.InvalidInstruction;

@RunWith(JUnit4.class)
public class RoverMovementTest {

    private RoverMovement movement;

    @Before
    public void setUp() throws Exception {
        movement = new RoverMovement();
    }

    @Test
    public void testDefinePlateuCoordinates() {
        movement.setPlateuCoordinates(6, 5);
        assertEquals("6 5", movement.getPlateuCoordinates().printCoordinates());
    }

    @Test
    public void testNorthTurnLeft() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.NORTH);
        movement.execInstruction("L");
        assertEquals("1 2 W", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testNorthTurnRight() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.NORTH);
        movement.execInstruction("R");
        assertEquals("1 2 E", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testEastTurnLeft() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.EAST);
        movement.execInstruction("L");
        assertEquals("1 2 N", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testEastTurnRight() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.EAST);
        movement.execInstruction("R");
        assertEquals("1 2 S", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testSouthTurnRight() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.SOUTH);
        movement.execInstruction("R");
        assertEquals("1 2 W", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testSouthTurnLeft() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.SOUTH);
        movement.execInstruction("L");
        assertEquals("1 2 E", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testWestTurnLeft() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.WEST);
        movement.execInstruction("L");
        assertEquals("1 2 S", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testWestTurnRight() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.WEST);
        movement.execInstruction("R");
        assertEquals("1 2 N", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testWestTurnRight1() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.NORTH);
        movement.execInstruction("LMLMLMLMM");
        assertEquals("3 3 E", movement.getRoverPosition().printPosition());
        /**
         * LMLMLMLMM
         */
    }

    @Test
    public void testWestTurnRightAndMove() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.WEST);
        movement.execInstruction("RM");
        assertEquals("1 3 N", movement.getRoverPosition().printPosition());
    }

    @Test
    public void testWestTurnRightMoveTurnLeftMoveMove() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.SOUTH);
        movement.execInstruction("RMLMM");
        assertEquals("0 0 S", movement.getRoverPosition().printPosition());
    }

    @Test(expected = InvalidInstruction.class)
    public void testInvalidMove() {
        movement.setPlateuCoordinates(5, 5);
        movement.setRoverPosition(1, 2, Coordinate.Heading.SOUTH);
        movement.execInstruction("RMLMMD");
        assertEquals("0 0 S", movement.getRoverPosition().printPosition());
    }

}
