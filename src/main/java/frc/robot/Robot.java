/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;

  public static RobotContainer container; 

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  
    container = new RobotContainer();
    new Thread(() -> {
      UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
      camera1.setResolution(640, 480);

      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);

      Mat source = new Mat();
      Mat output = new Mat();

      while(!Thread.interrupted()) {
        if (cvSink.grabFrame(source) == 0) {
          continue;
        }
        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
        outputStream.putFrame(output);
      }
    }).start();
   
  }
/**
 * THIS IS JUST FOR A TEST DELETE THIS METHOD
 * @return
 */
  public String getColor(){
    Color reading = RobotContainer.spinnymcSpinSpinnerson.colorSensor.getColor();
    double blue = reading.blue;
    double red = reading.red;
    double green = reading.green;
    String colorInfo;
    if (blue<0.15 && red>0.3 && green>0.5){
      colorInfo = "Y";
    }
    else if (blue>red && blue>0.3 && green<0.5){
      colorInfo = "B";
    }
    else if (red>blue && red>0.3 && green<0.5){
      colorInfo = "R";
    }
    else if (green>blue && green>red){
      colorInfo = "G";
    }
    else {
      colorInfo = "?";
    }
    return colorInfo;
  }
 
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    SmartDashboard.putString("color", getColor());
    SmartDashboard.putNumber("red", RobotContainer.spinnymcSpinSpinnerson.colorSensor.getRed());
    SmartDashboard.putNumber("green", RobotContainer.spinnymcSpinSpinnerson.colorSensor.getGreen());
    SmartDashboard.putNumber("blue", RobotContainer.spinnymcSpinSpinnerson.colorSensor.getBlue());

    SmartDashboard.putNumber("Elevator Encoder", RobotContainer.climbymcClimbClimberson.encoder.get());

    if(RobotContainer.drivymcDriveDriverson.rightDistanceSensor.isRangeValid()){
      SmartDashboard.putNumber("Right Dist", RobotContainer.drivymcDriveDriverson.rightDistanceSensor.getRange());
    }
    SmartDashboard.putNumber("Left Dist", RobotContainer.drivymcDriveDriverson.leftDistanceSensor.getRange());
    
  }
 
  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = container.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
   
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
