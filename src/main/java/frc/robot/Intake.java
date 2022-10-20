package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
    private static Intake instance;
    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }

    WPI_TalonFX falcon;
    XboxController controller;


    private DoubleSolenoid one;

    public void initHardware() {
        one = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
        falcon = new WPI_TalonFX(0);
        controller = new XboxController(0);
    }

    public void FalconSpeed() {
        double joystickValue = controller.getLeftY();
        if (joystickValue < 0){
            falcon.set(0);
        }
        else {
            falcon.set(joystickValue);
        }
    }

    public void intakeForwardPress() {
        one.set(DoubleSolenoid.Value.kForward);
    }

    public void intakeBackwardPress() {
        one.set(DoubleSolenoid.Value.kReverse);
    }




}
