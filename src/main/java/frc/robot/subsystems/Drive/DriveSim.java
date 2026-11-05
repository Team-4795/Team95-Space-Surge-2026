package frc.robot.subsystems.Drive;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSim extends SubsystemBase {
    private DifferentialDrivetrainSim drive = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kSingleCIMPerSide, KitbotGearing.k10p71,
    KitbotWheelSize.kSixInch, null);
    private DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.5);

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.setInputs(leftSpeed*5, rightSpeed*5);
    }

    public void arcadeDrive(double speed, double rotation) {
        drive.setInputs(speed*5 + rotation*5, speed*5 - rotation*5);
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(new ChassisSpeeds(speed*5, 0, rotation*10));
        drive.setInputs(wheelSpeeds.leftMetersPerSecond, wheelSpeeds.rightMetersPerSecond);
    }

    @Override
    public void periodic() {
        drive.update(0.02);
    
        Logger.recordOutput( "Drive/Pose", drive.getPose());
        Logger.recordOutput("Drive/Current",drive.getCurrentDrawAmps());
    }
}
