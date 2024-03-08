/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// This is THE code that MAIN calls when running the robot!! Everything you want has to go here at some point


package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.subsystems.*;

 
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

// This initializes our robot as a timed robot, which means that all functions run on timedeltas
 public class Robot extends TimedRobot {
 /** 
 * two private static strings below determine what auton code is run, default and center are now initialized as options for auton,
 * this is determined in robot init
 */
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "Center";
  private String m_autoSelected;
  // below configures options for dashboard
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // if we want to know the time between events, this initializes that timer, can be reset and called
  Timer autoTimer = new Timer();
  Timer shooterTimer = new Timer();
  // initializes gyroscope (ADX... is the kind we have)
  ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  // initializes accelerometer within Rio
  BuiltInAccelerometer accel = new BuiltInAccelerometer();
  double oldGyro = 0;

  @Override
  /** USE WITH CAUTION
  * this is used for anything you want to run when robot is disabled 
  * current code completely brakes the wheels (for balancing)
  */
  public void disabledPeriodic() {
    // activate active braking
    Grabber.grabberTalon.set(0);
    TankDrive.drive.tankDrive(0, 0);
  }

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    gyro.reset();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("Center", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    CameraServer.startAutomaticCapture();
    frc.robot.subsystems.TankDrive.DrivetrainSetup();
    Shooter.shooterTalonPrimary.configFactoryDefault();
    Shooter.shooterTalonSecondary.configFactoryDefault();
    Shooter.shooterTalonPrimary.configContinuousCurrentLimit(35); // hopefully this will help us get more power from the shooter
    Shooter.shooterTalonSecondary.configContinuousCurrentLimit(35);
    Climb.claw.configFactoryDefault();
    Climb.claw.configContinuousCurrentLimit(3);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // DriverStation.reportError(String.valueOf(gyro.getRate()), false);
    // collects gyro information for dashboard
    SmartDashboard.putNumber("Gyro", accel.getY());
    SmartDashboard.putNumber("Yaw", gyro.getAngle());
  }

  
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */

  // INIT AUTON MODE
  
  @Override
  public void autonomousInit() {
    gyro.reset();
    autoTimer.reset();
   // below selects default or center
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    autoTimer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  
// AUTON MODE RUNNING
  @Override
  public void autonomousPeriodic() {
   // use autoSelected
    switch (m_autoSelected) {
      case kCustomAuto:
//         // Put custom auto code here
//         final double matchTime1 = autoTimer.get();
//         double leftAutoSpeedClimb = 0.6695;
//         double rightAutoSpeedClimb = -0.65; // a constant speed diff between right and left motors
        
//         double leftAutoSpeed1 = 0.515;
//         double rightAutoSpeed1 = -0.5; // a constant speed diff between right and left motors
//         double yaw = gyro.getAngle();
//         double cmdYaw = yaw * 0.05;

// // Gyro balancing code. Feedback loop. A is a parameter of the feedback
//         if (matchTime1 <= 1.9) {
//           TankDrive.drive.tankDrive(leftAutoSpeedClimb - cmdYaw, rightAutoSpeedClimb - cmdYaw);
//         } else if (matchTime1 <= 4.3) {
//           TankDrive.drive.tankDrive(leftAutoSpeed1 - cmdYaw, rightAutoSpeed1 - cmdYaw);
//         } else {
//           double a = 0.85;
//           if (matchTime1 >= 8.5) {
//             a = 0.88;
//           }
//           double ay = oldGyro * a + accel.getY() * (1 - a);

//           oldGyro = ay;
//           double cmd = -ay * 2.7;
//           double limit = 0.55;
//           if (matchTime1 >= 9) {
//             limit = 0.3;
//           }
          
//           if (cmd > limit) {
//             cmd = limit;
//           } else if (cmd < -limit) {
//             cmd = -limit;
//           }
//           TankDrive.drive.tankDrive(cmd, -cmd);
//         }
//         break;
      case kDefaultAuto:
      default:
      final double matchTime1 = autoTimer.get();
      if (matchTime1 <= 1) {
        Shooter.shooterTalonPrimary.set(ControlMode.PercentOutput, 1);
      } else if (matchTime1 <= 1.5) {
        Shooter.shooterTalonPrimary.set(ControlMode.PercentOutput, 1);
        Shooter.shooterTalonSecondary.set(ControlMode.PercentOutput, 1); 
      } else if (matchTime1 <= 5.5) {
        Shooter.shooterTalonPrimary.set(ControlMode.PercentOutput, 0);
        Shooter.shooterTalonSecondary.set(ControlMode.PercentOutput, 0);
        TankDrive.drive.tankDrive(-0.4, 0.415);
      }
        // // Put default auto code here
        // final double matchTime = autoTimer.get();
        // double leftAutoSpeed = 0.515;
        // double rightAutoSpeed = -0.4875; // a constant speed diff between right and left motors
        // double yaw1 = gyro.getAngle();
        // double cmdYaw1 = yaw1 * 0.05;
        
        // if (matchTime <= 8.2) {
        //   TankDrive.drive.tankDrive(leftAutoSpeed - cmdYaw1, rightAutoSpeed - cmdYaw1);
        //   // if (matchTime <= 1.5) {
        //   // frc.robot.subsystems.Elevator.elevatorVictorMaster.set(ControlMode.PercentOutput, 0.3);
        //   // } else {
        //   // frc.robot.subsystems.Elevator.elevatorVictorMaster.set(ControlMode.PercentOutput, 0.075);
        //   // }
        // }
        // // frc.robot.subsystems.Lift.liftVictorMaster.set(ControlMode.PercentOutput, 0.75);
        // // frc.robot.subsystems.Shooter.shooterVictorSPX.set(ControlMode.PercentOutput, -1);
        // // frc.robot.subsystems.Shooter.shooterVictorMaster.set(ControlMode.PercentOutput, -1);
        // break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  
  // RUNS TELEOP MODE
  /**
   * ALL code commented out is for various hardwares
   * TANK is what needs to change for Arcade
   */
   
  public void teleopPeriodic() {
   
    TankDrive.drive.tankDrive(TankDrive.getLeftDriveSpeed(), TankDrive.getRightDriveSpeed());
    
    Shooter.shooterTalonPrimary.set(TalonSRXControlMode.PercentOutput, Shooter.getShooterSpeed());
    if (Shooter.getShooterSpeed() > 0) {
      if (shooterTimer.get() > 0) {
        if(shooterTimer.get() > 1.5 ) {
          Shooter.shooterTalonSecondary.set(TalonSRXControlMode.PercentOutput, Shooter.getShooterSpeed());
        }
      } else {
        shooterTimer.restart();
      }
      System.out.println(shooterTimer.get());
    } else if (Shooter.getShooterSpeed() < 0) {
      Shooter.shooterTalonSecondary.set(TalonSRXControlMode.PercentOutput, Shooter.getShooterSpeed());
    } else {
      Shooter.shooterTalonSecondary.set(TalonSRXControlMode.PercentOutput, 0);
      shooterTimer.reset();
    }

    Grabber.grabberTalon.set(TalonSRXControlMode.PercentOutput, Grabber.getGrabberDirection());
    Climb.claw.set(TalonSRXControlMode.PercentOutput, Climb.getClawSpeed());

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override

  // testPeriod is what runs when you hit Test on the dash
  
  public void testPeriodic() {
    // frc.robot.subsystems.Arm.armVictorSPX.set(ControlMode.PercentOutput, Arm.getArmExtension());
  }
}
