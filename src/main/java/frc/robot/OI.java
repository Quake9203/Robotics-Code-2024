package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
// imports xbox controller. need change here for joystick
import edu.wpi.first.wpilibj.XboxController; 

public class OI {
    // initializing the xbox controller names xbox, 'XboxController(RobotMap.xboxUSB) maps to USB,0
    public static XboxController xbox = new XboxController(RobotMap.xboxUSB);  
    public static Joystick joystick = new Joystick(1);

    // deadzones provide a range of values rather than a bool. increase deadzone to decrease sensitivity
    private static double deadzoneJoy = 0.1;
    private static double deadzoneTrigger = 0.1;
    // functions below allow for tweaking deadzones for other factors. X is horizontal and Y is Vert
    public static double GetXboxLeftJoyX() {
        return Math.abs(xbox.getLeftX()) < deadzoneJoy ? 0.0 : xbox.getLeftX();
    }

    public static double GetXboxLeftJoyY() {
        return Math.abs(xbox.getLeftY()) < deadzoneJoy ? 0.0 : xbox.getLeftY();
    }


    public static double GetXboxRightJoyX() {
        return Math.abs(xbox.getRightX()) < deadzoneJoy ? 0.0 : xbox.getRightX();
    }

    public static double GetXboxRightJoyY() {
        return Math.abs(xbox.getRightY()) < deadzoneJoy ? 0.0 : xbox.getRightY();
    }

    public static double GetXboxRightTrigger() {
        return Math.abs(xbox.getRightTriggerAxis()) < deadzoneTrigger ? 0.0 : xbox.getRightTriggerAxis();
    }

    public static double GetXboxLeftTrigger() {
        return Math.abs(xbox.getLeftTriggerAxis()) < deadzoneTrigger ? 0.0 : xbox.getLeftTriggerAxis();
    }

    public static double GetJoyconX() {
        return joystick.getX();
    }

    public static double GetJoyconY() {
        return joystick.getY();
    }

    public static double GetJoyconZ() {
        return joystick.getZ();
    }
}
