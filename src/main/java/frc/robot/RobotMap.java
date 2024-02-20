/**
* THIS IS WHERE WE MAP OUT MOTOR CONTROLS!
*/

package frc.robot;

public class RobotMap {

    /*
    Check CAN locations using Phoenix Tuner CAN Devices utility (app on laptop)
    PWM locations (including servos) determined by location number on RoboRIO 
    */ 

    //Drivetrain
    public static int rightTalonLeaderCAN = 1;
    public static int rightTalonFollowerCAN = 2;
    public static int leftTalonLeaderCAN = 3;
    public static int leftTalonFollowerCAN = 4;

    //new 2020
    // public static int elevatorVictorMasterCAN = 8; //brake mode
    // public static int shooterVictorMasterCAN = 6;
    // public static int shooterVictorSPXCAN = 8;
    // public static int liftVictorMasterCAN = 7; //brake mode

    // new 2023
    // public static int handServoTopPWM = 9;
    // public static int handServoBottomPWM = 8;
    // public static int armVictorCAN = 7;

    // new 2024
    public static int shooterTalonPrimaryCAN = 6;
    public static int shooterTalonSecondaryCAN = 5;
    public static int __extraMotor__ = 7;


// below has always been zero, regardless of what else is plugged in
    public static int xboxUSB = 0;
    public static int joystickUSB = 1;

}
