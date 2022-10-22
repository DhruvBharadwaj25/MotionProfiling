package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;

public class Shooter {

    private static Shooter instance;
    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    WPI_TalonFX falconUp;
    WPI_TalonFX falconDown;
    WPI_TalonFX hood;

    public void initHardware() {
        falconUp = new WPI_TalonFX(0);
        falconDown = new WPI_TalonFX(1);
        hood = new WPI_TalonFX(2);
    }

    public void flywheelSpinSpeed(double speed) {
        if (speed < 0) {
            falconDown.set(0);
            falconUp.set(0);
        }
        else {
            falconUp.set(-speed);
            falconDown.set(speed);
        }
    }

    public void flywheelHoodUp() {
        hood.set(-0.3);
    }

    public void flywheelHoodDown() {
        hood.set(0.3);
    }
}
