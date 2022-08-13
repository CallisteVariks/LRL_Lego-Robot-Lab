
import lejos.nxt.*;

public class Square
{
   public static void main(String[] args) throws InterruptedException
   {
      // TODO Auto-generated method stub

      // Declaring variables
      int pwrleft; // Power to left motor
      int pwrright; // Power to right motor
      MotorPort motorleft; // Object representing left motor
      MotorPort motorright; // Object representing right motor
      LightSensor light; // Object representing light sensor

      // Initializing variables
      pwrleft = 75;
      pwrright = 75;
      motorleft = MotorPort.B;
      motorright = MotorPort.C;
      light = new LightSensor(SensorPort.S1);

      // Prepare sensors
      light.setFloodlight(true);
      MotorPort.B.resetTachoCount();
      MotorPort.C.resetTachoCount();

      // Write a message, wait for response, clear message again
      LCD.clear();
      LCD.drawString("Press any key", 0, 0);
      Button.waitForAnyPress();
      LCD.clear();

      // Turn off LED in light sensor
      light.setFloodlight(false);

      // Start both motors
      motorleft.controlMotor(pwrleft, 1); // 1=start
      motorright.controlMotor(pwrright, 1);

      // Wait three seconds
      Thread.sleep(3000);

      motorleft.controlMotor(0, 3);
      motorright.controlMotor(95, 1);
      Thread.sleep(2000);

      motorleft.controlMotor(0, 3);
      motorright.controlMotor(95, 1);
      Thread.sleep(500);

      motorleft.controlMotor(0, 3);
      motorright.controlMotor(95, 1);

      Thread.sleep(2000);

      motorleft.controlMotor(0, 3);
      motorright.controlMotor(95, 1);

      Thread.sleep(500);
   }
}
