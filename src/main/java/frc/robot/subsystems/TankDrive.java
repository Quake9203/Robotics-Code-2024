
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.RobotMap;

public class TankDrive {
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

      rightTalonLeader.setInverted(false);
      rightTalonFollower.setInverted(InvertType.FollowMaster);
      
      leftTalonLeader.setInverted(false);
      leftTalonFollower.setInverted(InvertType.FollowMaster);

  }

  public static DifferentialDrive drive = new DifferentialDrive(leftTalonLeader, rightTalonLeader);

  public static double getLeftDriveSpeed() {
      double raw = 0;
// getrawbutton(1) is checking for A button pressed for Turbo
      if (OI.xbox.getRawButton(1)) {
        raw = Math.signum(OI.GetXboxLeftJoyY()) * Math.pow(OI.GetXboxLeftJoyY(), 2);
      } else {
        raw = Math.signum(OI.GetXboxLeftJoyY()) * Math.pow(OI.GetXboxLeftJoyY(), 2) * 0.9; 
      }

      return -raw;
    }
    public static double getRightDriveSpeed() {
      double raw = 0;

      if (OI.xbox.getRawButton(1)) {
        raw = Math.signum(OI.GetXboxRightJoyY()) * Math.pow(OI.GetXboxRightJoyY(), 2);
      } else {
        raw = Math.signum(OI.GetXboxRightJoyY()) * Math.pow(OI.GetXboxRightJoyY(), 2) * 0.9;
      }

      return raw;
    }


}
