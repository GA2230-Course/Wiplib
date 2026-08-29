package frc.robot;
import com.ctre.phoenix6.CANBus;


public class Ports {
    private static final CANBus RobotCANBus = new CANBus("rio");
    public static final class INTAKE_ROLLER_MASTER_MOTOR {
        private static final int id = 0;
        public static int id() {
            return id;
        }
        public static CANBus bus() {
            return RobotCANBus;
        }
    }
    public static final class INTAKE_FOUR_BAR_MOTOR {
        private static final int id = 1;
        public static int id() {
            return id;
        }
        public static CANBus bus() {
            return RobotCANBus;
        }
    }
}
