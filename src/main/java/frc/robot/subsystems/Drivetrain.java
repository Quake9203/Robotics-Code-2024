
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Drivetrain {
public static WPI_TalonSRX rightTalonLeader = new WPI_TalonSRX(RobotMap.rightTalonLeaderCAN);
public static WPI_TalonSRX rightTalonFollower = new WPI_TalonSRX(RobotMap.rightTalonFollowerCAN);

public static WPI_TalonSRX leftTalonLeader = new WPI_TalonSRX(RobotMap.leftTalonLeaderCAN);
public static WPI_TalonSRX leftTalonFollower = new WPI_TalonSRX(RobotMap.leftTalonFollowerCAN);

public static void DrivetrainSetup() {
    rightTalonLeader.configFactoryDefault();
    rightTalonFollower.configFactoryDefault();
    leftTalonLeader.configFactoryDefault();
    leftTalonFollower.configFactoryDefault();


    rightTalonFollower.follow(rightTalonLeader);
    leftTalonFollower.follow(leftTalonLeader);

    rightTalonLeader.setInverted(true);
    rightTalonFollower.setInverted(InvertType.FollowMaster);
    leftTalonLeader.setInverted(true);
    leftTalonFollower.setInverted(InvertType.FollowMaster);

}

public static DifferentialDrive drive = new DifferentialDrive(leftTalonLeader, rightTalonLeader);

public static double getDriveSpeed() {
    double raw = 0;

    if (OI.xbox.getRawButton(1)) {
        raw = OI.GetXboxLeftJoyY();
    } else {
        raw = OI.GetXboxLeftJoyY()* 0.75;
    }

    return raw;
}


public static double getDriveRotation() {
    double raw = 0;

    if (OI.xbox.getRawButton(1)) {
        raw = OI.GetXboxLeftJoyX();
    } else {
        raw = OI.GetXboxLeftJoyX()* 0.5;
    }

    return raw;
}
}
