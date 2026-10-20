package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
    private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);

    private final DifferentialDrive m_robotDrive;

    public Drive() {
        m_rightMotor.setInverted(true);

        m_robotDrive = new DifferentialDrive(
            m_leftMotor::set,
            m_rightMotor::set
        );
    }

    public void arcadeDrive(double speed, double rotation) {
        m_robotDrive.arcadeDrive(speed, rotation);
    }
}