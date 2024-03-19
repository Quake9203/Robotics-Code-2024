package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Climb {
    public static WPI_TalonSRX leftClaw = new WPI_TalonSRX(RobotMap.leftClawTalonCAN);
    public static WPI_TalonSRX rightClaw = new WPI_TalonSRX(RobotMap.rightClawTalonCAN);

    public static void clawSetup() {
        leftClaw.configFactoryDefault();
        rightClaw.configFactoryDefault();
        
        leftClaw.configContinuousCurrentLimit(3);
        rightClaw.configContinuousCurrentLimit(3);
        rightClaw.follow(leftClaw);
        
    }

    public static double getClawSpeed() {
        if (OI.xbox.getBackButton()) {
            return 1;
        } else if (OI.xbox.getStartButton()) {
            return -1;
        } else {
            return 0;
        }
    }
}
