package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
// imports xbox controller. need change here for joystick
import edu.wpi.first.wpilibj.XboxController; 

public class OI {
    // initializing the xbox controller names xbox, 'XboxController(RobotMap.xboxUSB) maps to USB,0
    public static XboxController xbox = new XboxController(RobotMap.xboxUSB);  
    public static Joystick joycon = new Joystick(1);

    // deadzones provide a range of values rather than a bool. increase deadzone to decrease sensitivity
    private static double deadzoneXboxJoy = 0.1;
    private static double deadzoneXboxTrigger = 0.1;
    private static double deadzoneJoycon = 0.0;
    private static double deadzoneJoyconTwist = 0.0;
    // functions below allow for tweaking deadzones for other factors. X is horizontal and Y is Vert
    public static double GetXboxLeftJoyX() {
        return Math.abs(xbox.getLeftX()) < deadzoneXboxJoy ? 0.0 : xbox.getLeftX();
    }

    public static double GetXboxLeftJoyY() {
        return Math.abs(xbox.getLeftY()) < deadzoneXboxJoy ? 0.0 : xbox.getLeftY();
    }


    public static double GetXboxRightJoyX() {
        return Math.abs(xbox.getRightX()) < deadzoneXboxJoy ? 0.0 : xbox.getRightX();
    }

    public static double GetXboxRightJoyY() {
        return Math.abs(xbox.getRightY()) < deadzoneXboxJoy ? 0.0 : xbox.getRightY();
    }

    public static double GetXboxRightTrigger() {
        return Math.abs(xbox.getRightTriggerAxis()) < deadzoneXboxTrigger ? 0.0 : xbox.getRightTriggerAxis();
    }

    public static double GetXboxLeftTrigger() {
        return Math.abs(xbox.getLeftTriggerAxis()) < deadzoneXboxTrigger ? 0.0 : xbox.getLeftTriggerAxis();
    }

    public static double GetJoyconX() {
        return Math.abs(joycon.getX()) < deadzoneJoycon ? 0.0 : joycon.getX();
    }

    public static double GetJoyconY() {
        return Math.abs(joycon.getY()) < deadzoneJoycon ? 0.0 : joycon.getY();
    }

    public static double GetJoyconZ() {
        return Math.abs(joycon.getZ()) < deadzoneJoycon ? 0.0 : joycon.getZ();
    }

    public static double getJoyconTwist() {
        return Math.abs(joycon.getTwist()) < deadzoneJoyconTwist ? 0.0 : joycon.getTwist();
    }
}
