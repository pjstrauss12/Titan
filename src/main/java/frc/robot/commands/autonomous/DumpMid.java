package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTimeReverse;
import frc.robot.commands.DriveTimeRight;
import frc.robot.commands.DriveToWall;
import frc.robot.commands.DumpClose;
import frc.robot.commands.DumpLift;
import frc.robot.commands.DumpToggle;
import frc.robot.commands.DumpOpen;
import frc.robot.commands.DumpDown;

public class DumpMid extends SequentialCommandGroup {

    public DumpMid() {
        addCommands(
            //Drive to wall
            new DriveToWall(),
            //Drive right
            new DriveTimeRight(1),
            //Dump cells

            //new DumpLift(),
    
            //new DumpOpen(),
            
            //new DumpClose(),

            //new DumpDown(),
    
            new DriveTimeReverse(1)
    
            
        );

    }
}