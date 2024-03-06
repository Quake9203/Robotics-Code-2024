package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Climb {
    public static WPI_TalonSRX claw = new WPI_TalonSRX(RobotMap.clawTalonCAN);

    public static double getClawSpeed() {
        if (OI.xbox.getStartButton()) {
            return 1;
        } else if (OI.xbox.getBackButton()) {
            return -1;
        } else {
            return 0;
        }
    }
}
