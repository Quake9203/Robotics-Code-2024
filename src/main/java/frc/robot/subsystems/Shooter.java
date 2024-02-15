
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Shooter {
    private static double deadzone = 0.5;

    public static WPI_TalonSRX shooterTalonPrimary = new WPI_TalonSRX(RobotMap.shooterTalonPrimaryCAN);
    public static WPI_TalonSRX shooterTalonSecondary = new WPI_TalonSRX(RobotMap.shooterTalonSecondaryCAN);

    public static double getShooterSpeed() {
        double raw = 0;

        if (Math.abs(OI.xbox.getRawAxis(3)) > deadzone) { // right trigger
            raw = -1;
        } else {
            raw = 0;
        }

        return raw;
    }

}
