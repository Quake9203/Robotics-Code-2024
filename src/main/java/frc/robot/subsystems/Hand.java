// // FOR THE CLAW

// package frc.robot.subsystems;

// import frc.robot.RobotMap;
// import frc.robot.OI;
// import edu.wpi.first.wpilibj.Servo;

// public class Hand {
//     public static Servo handTop = new Servo(RobotMap.handServoTopPWM);
//     public static Servo handBottom = new Servo(RobotMap.handServoBottomPWM);

//     public static double getHandPosition() {
//         double theta = 0.0;

//         if (OI.xbox.getAButton()) {
//             theta = 90.0;
//         } else {
//             theta = 0.0;
//         }

//         return theta;
//     }
// }
