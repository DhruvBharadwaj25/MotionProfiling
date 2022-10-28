package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {


  @Override
  public void robotInit() {
    Intake.getInstance().initHardware();
    OI.getInstance().setupControls();
    Shooter.getInstance().initHardware();
  }


  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
  }


  @Override
  public void autonomousPeriodic() {

  }


  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().schedule(new IntakeCommand());
    CommandScheduler.getInstance().schedule(new ShooterCommand());
  }



  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
