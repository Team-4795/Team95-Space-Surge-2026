// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Arm.Arm;
import frc.robot.subsystems.Arm.ArmSim;
import frc.robot.subsystems.Drive.Drive;
import frc.robot.subsystems.Drive.DriveSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ArmSim m_arm = new ArmSim();
  private final DriveSim m_drive = new DriveSim();
  private boolean m_arcadeMode = false;
  //sim rn

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController = 
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  
    m_arm.setDefaultCommand(Commands.run(() -> m_arm.setArmSpeed(0), m_arm));
    
    m_operatorController.rightTrigger().whileTrue(Commands.run(() -> m_arm.setArmSpeed(9), m_arm));
    m_operatorController.leftTrigger().whileTrue(Commands.run(() -> m_arm.setArmSpeed(-9), m_arm));
  
  
  
      m_drive.setDefaultCommand(
        Commands.run(
            () -> m_drive.tankDrive(
                -m_driverController.getLeftY(),
                -m_driverController.getRightY()),
            m_drive));
     
      m_drive.setDefaultCommand(
        Commands.run( 
            ()->m_drive.arcadeDrive(
                -m_driverController.getLeftY(),
                -m_driverController.getRightX()),
            m_drive));
      
  m_driverController.y().onTrue(
    Commands.runOnce(()->m_arcadeMode = !m_arcadeMode ));
    
  }
  
    private Object m_setArmSpeed(int i) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'm_setArmSpeed'");
    }
  
    /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}