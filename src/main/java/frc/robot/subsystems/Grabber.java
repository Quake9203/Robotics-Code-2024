package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Grabber {
    public static WPI_TalonSRX grabberTalon = new WPI_TalonSRX(RobotMap.grabberTalonCAN);

    public static double getGrabberDirection() {

        if (OI.xbox.getRightBumper()) {
            return 1;
        } else if (OI.xbox.getLeftBumper()) {
            return -0.4;
        } else {
            return 0;
        }
    }
}
