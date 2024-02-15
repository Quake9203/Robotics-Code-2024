
// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import frc.robot.OI;
// import frc.robot.RobotMap;

// public class Lift {

//     public static VictorSPX liftVictorMaster = new VictorSPX(RobotMap.liftVictorMasterCAN);
//        private static boolean toggleLift = false;
//        private static boolean toggleLiftBack = false;

        

//     public static double getLiftSpeed() {
//         double raw = 0;

//         if (OI.xbox.getRawButtonPressed(6)) { // what button
//             toggleLift = !toggleLift;
//             toggleLiftBack = false;
//         } else {
//             if (OI.xbox.getRawButtonPressed(5)){ // what button
//             toggleLift = false;
//             toggleLiftBack = !toggleLiftBack;
//             } else {
//                 if (OI.xbox.getRawButtonPressed(3)){ // what button
//                     toggleLift = false;
//                     toggleLiftBack = false;
//                 }
//             }
//         }

//         if (toggleLift) {
//             raw = 0.85;
//         } else {
//             if (OI.xbox.getRawButton(5))
//             raw = -0.85;
//             else {
//             raw = 0;
//             }
//         }

//         return raw;
//     }

// }
