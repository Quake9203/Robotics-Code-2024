// package frc.robot.subsystems;

// import frc.robot.OI;
// import frc.robot.RobotMap;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// public class Arm {
//     public static VictorSPX armVictorSPX = new VictorSPX(RobotMap.armVictorCAN);

//     public static double getArmExtension() {
//         double speed = 0.0;

//         // if ((OI.GetXboxLeftTrigger() > 0) && (OI.GetXboxRightTrigger() > 0)) {
//         //     speed = 0.0;
//         // } else 
//         if (OI.GetXboxRightTrigger() > 0) {
//             speed = OI.GetXboxRightTrigger() * 0.45;
//         } else if (OI.GetXboxLeftTrigger() > 0) {
//             speed = OI.GetXboxLeftTrigger() * -0.45;
//         } else {
//             speed = 0.0;
//         }

//         return speed;
//     }
// }
