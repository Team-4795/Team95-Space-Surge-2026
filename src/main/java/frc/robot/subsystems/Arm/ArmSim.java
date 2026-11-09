package frc.robot.subsystems.Arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSim extends SubsystemBase {
    DCMotorSim armSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(0.5, 0.1), DCMotor.getAndymark9015(1));
        
    public void setArmSpeed(double v){
        armSim.setInputVoltage(v);
        }

    @Override
    public void periodic() {
        armSim.update(.02);
    
        Logger.recordOutput( "Arm/Pose", armSim.getAngularPositionRotations());
        Logger.recordOutput("Arm/Current",armSim.getCurrentDrawAmps());
        Logger.recordOutput("Arm/Voltage",armSim.getInputVoltage());
        Logger.recordOutput("Arm/Velocity",armSim.getAngularVelocityRPM());
    }

}