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


public class DumpFar extends SequentialCommandGroup {

    public DumpFar() {
        addCommands(
            //Go forward
            new DriveToWall(),
            //Go right
            new DriveTimeRight(2),
            //Dump cells
            //new DumpLift(),

            //new DumpOpen(),

            //new DumpClose(),

            //new DumpDown(),

            new DriveTimeReverse(2)

        );

    }

}