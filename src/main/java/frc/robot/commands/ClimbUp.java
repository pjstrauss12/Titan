/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ClimbUp extends CommandBase {

  private SpeedController winch = RobotContainer.climbymcClimbClimberson.winchMotors;

  public ClimbUp() {
    // Use requires() here to declare subsystem dependencies

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    
  }

  
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    winch.set(0.8);  
        
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interupted) {
    winch.set(0);
 }

}

