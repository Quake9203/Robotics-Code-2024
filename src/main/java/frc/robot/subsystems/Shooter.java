
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Shooter {
    private static double deadzone = 0.5;

    public static WPI_TalonSRX shooterTalonPrimary = new WPI_TalonSRX(RobotMap.shooterTalonPrimaryCAN);
    public static WPI_TalonSRX shooterTalonSecondary = new WPI_TalonSRX(RobotMap.shooterTalonSecondaryCAN);
    public static WPI_TalonSRX shooterTalonTertiary = new WPI_TalonSRX(RobotMap.shooterTalonTertiaryCAN);

    public static void shooterSetup() {
        Shooter.shooterTalonPrimary.configFactoryDefault();
        Shooter.shooterTalonSecondary.configFactoryDefault();
        Shooter.shooterTalonTertiary.configFactoryDefault();
        Shooter.shooterTalonPrimary.configContinuousCurrentLimit(35); // hopefully this will help us get more power from the shooter
        Shooter.shooterTalonSecondary.configContinuousCurrentLimit(35);
        Shooter.shooterTalonTertiary.configContinuousCurrentLimit(35);

        shooterTalonTertiary.follow(shooterTalonPrimary);
        shooterTalonTertiary.setInverted(true);
    }

    public static double getShooterSpeed() {
        double raw = 0;

        if (Math.abs(OI.GetXboxRightTrigger()) > deadzone) { // right trigger
            raw = 1;
        } else if (Math.abs(OI.GetXboxLeftTrigger()) > deadzone) {
            raw = -0.4;
        } else {
            raw = 0;
        }

        return raw;
    }

}
