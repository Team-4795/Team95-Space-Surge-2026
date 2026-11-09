package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final PWMSparkMax m_armMotor = new PWMSparkMax(2);

    public Arm() {
        // Initialize the arm motor if needed
    
    }

    public void setArmSpeed(double speed) {
        m_armMotor.set(speed);
    }

    public void stopArm() {
        m_armMotor.set(0.0);
    }

    @Override
    public void periodic() {
    }

    public static Object setVoltage(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVoltage'");
    }
    
}
