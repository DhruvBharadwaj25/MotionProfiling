package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;

public class Conveyor {

    DigitalInput beamBreaker;
    int numBalls;
    WPI_TalonFX conveyor_falcon;

    private static Conveyor instance;

    public static Conveyor getInstance() {
        if (instance == null) {
            instance = new Conveyor();
        }
        return instance;
    }

    public void initHardware() {
        conveyor_falcon = new WPI_TalonFX(3);
        beamBreaker = new DigitalInput(0);
        numBalls = 0;
    }

    public void numBallsConveyor() {
        if (!beamBreaker.get()) {
            numBalls += 1;
        }

        //compensates for deadzone
        if (OI.getInstance().getController().getRightY() > 0.1 && OI.getInstance().getController().getRightY() < -0.1) {
            numBalls = 0;
        }
    }

    public void conveyorForward(double val) {
        conveyor_falcon.set(val);
    }
}