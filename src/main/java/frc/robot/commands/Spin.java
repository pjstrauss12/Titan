/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ButtWheel;
import frc.robot.Robot;



/**
 * An example command that uses an example subsystem.
 */
public class Spin extends CommandBase {

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Spin() {
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.container.spinnymcSpinSpinnerson);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.container.spinnymcSpinSpinnerson.buttMotorGroup.set(0.5);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.container.spinnymcSpinSpinnerson.buttMotorGroup.set(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.container.spinnymcSpinSpinnerson.buttMotorGroup.get() > 0.;
  }
}
