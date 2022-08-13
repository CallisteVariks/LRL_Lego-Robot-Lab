import lejos.nxt.*;

public class Warehouse
{
   public static void main(String[] args)
   {

      OptimusPrime optimus = new OptimusPrime();

      LightSensor light = new LightSensor(SensorPort.S1);
      MotorPort MR = MotorPort.A;
      MotorPort ML = MotorPort.B;

      LCD.clear();
      LCD.drawString("Black", 0, 2);
      Button.waitForAnyPress();
      light.calibrateLow();
      LCD.clear();
      
      LCD.drawString("White", 1, 2);
      Button.waitForAnyPress();
      light.calibrateHigh();
      LCD.clear();
      
      Button.waitForAnyPress();
      
      MR.resetTachoCount();
      ML.resetTachoCount();
      
      while (!(Button.ESCAPE.isDown()))
      {
         MR.resetTachoCount();
         ML.resetTachoCount();
         
         while (light.getLightValue() < 20)
         {
            optimus.forward();
         }
         
         optimus.stop();
         MR.resetTachoCount();
         ML.resetTachoCount();
         
      }
      
   }
}
