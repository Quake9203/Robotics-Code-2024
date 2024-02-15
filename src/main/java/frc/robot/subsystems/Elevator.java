
// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import frc.robot.OI;
// import frc.robot.RobotMap;

// public class Elevator {

//     public static VictorSPX elevatorVictorMaster = new VictorSPX(RobotMap.elevatorVictorMasterCAN);

//     public static double getElevatorSpeed() {
//         double raw = 0.075;

//         if (OI.xbox.getXButton()) {
//             raw = -0.250;
//         } else if (OI.xbox.getYButton()) {
//             raw = 0.250;
//         } else {
//             raw = 0.075;
//         }

//         return raw;
//     }

// }
