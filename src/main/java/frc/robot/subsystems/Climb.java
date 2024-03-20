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

    public static int latentClawSpeed = 0;

    public static double getClawSpeed() {
        if (OI.xbox.getPOV() > -0.5 && OI.xbox.getPOV() < 10) {
            latentClawSpeed = 0;
            return -1;
        } else if (OI.xbox.getPOV() > 175 && OI.xbox.getPOV() < 185) {
            latentClawSpeed = 0;
            return 1;
        } else if (OI.xbox.getYButtonPressed()) {
            latentClawSpeed = -1;
            return -1;
        } else if (OI.xbox.getAButtonPressed()) {
            latentClawSpeed = 1;
            return 1;
        } else if (OI.xbox.getXButtonPressed()) {
            latentClawSpeed = 0;
            return 0;
        } else {
            return latentClawSpeed;
        }
    }
}
