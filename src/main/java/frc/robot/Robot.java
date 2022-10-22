package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {

  public XboxController controller;


  @Override
  public void robotInit() {
    Intake.getInstance().initHardware();
    OI.getInstance().setupControls();
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
  }



  @Override
  public void teleopPeriodic() {
    double joystickValue = controller.getLeftY();
    Intake.getInstance().falconSpeed(joystickValue);
    if (controller.getAButtonPressed())  {
      Intake.getInstance().intakeBackwardPress();
    }
    if (controller.getBButtonPressed())  {
      Intake.getInstance().intakeForwardPress();
    }
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
