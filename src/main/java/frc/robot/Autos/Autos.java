package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Arm.ArmSim;
import frc.robot.subsystems.Drive.DriveSim;

public final class Autos
{
    private final DriveSim m_drive;
    private final ArmSim m_arm;

    public Autos(DriveSim drive, ArmSim arm)
    {
        m_drive = drive;
        m_arm = arm;
    }

    public Command getAutonomousCommand()
    {
        return Commands.sequence(
            Commands.runOnce(() -> m_arm.setArmSpeed(1), m_arm),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> m_arm.setArmSpeed(0), m_arm),
            Commands.runOnce(() -> m_drive.arcadeDrive(0.5, 0), m_drive),
            Commands.waitSeconds(3),
            Commands.runOnce(() -> m_drive.arcadeDrive(0, 0), m_drive)
        );
    }

    public static Autos Autos(DriveSim m_drive2, ArmSim m_arm2) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'Autos'");
    }
}