package frc.robot.Autos;

import org.littletonrobotics.junction.Logger;

import frc.robot.subsystems.Arm.ArmSim;
import frc.robot.subsystems.Drive.DriveSim;
import edu.wpi.first.wpilibj2.command.Command;

public class AutosSim {
    
    private final DriveSim m_drive;
    private final ArmSim m_arm;

    public AutosSim(DriveSim drive, ArmSim arm)
    {
        m_drive = drive;
        m_arm = arm;
    }

    public void runAutonomous()
    {
        Logger.recordOutput("Autos/Autonomous", true);
        m_arm.setArmSpeed(1);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        m_arm.setArmSpeed(0);
        m_drive.arcadeDrive(0.5, 0);
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        m_drive.arcadeDrive(0, 0);
        Logger.recordOutput("Autos/Autonomous", false);
    }
}
