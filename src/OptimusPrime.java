import lejos.nxt.*;

public class OptimusPrime
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   LightSensor light = new LightSensor(SensorPort.S2);
   int pwr = 90;
   
   public void forward(int distance)
   {
      distance = distance * 18;
      while (ML.getTachoCount() < distance)
      {
         MR.controlMotor(pwr, 1);
         ML.controlMotor(pwr, 1);
      }
   }
   
   public void forward()
   {
      MR.controlMotor(pwr, 1);
      ML.controlMotor(pwr, 1);
   }
   
   public void backward(int distance)
   {
      distance = distance * 18;
      distance = -distance;
      while (ML.getTachoCount() > distance)
      {
         MR.controlMotor(0, 3);
         ML.controlMotor(0, 3);
      }
   }
   
   public void backward()
   {
      MR.controlMotor(pwr, 2);
      ML.controlMotor(pwr, 2);
   }
   
   public void stop()
   {
      MR.controlMotor(0, 3);
      ML.controlMotor(0, 3);
   }
   
   public void spinning(int taco)
   {
      ML.resetTachoCount();
      MR.resetTachoCount();
      
      while(MR.getTachoCount() < taco)
      {
         MR.controlMotor(pwr, 1);
         ML.controlMotor(pwr, 2);
      }
   }
      
   public int cmToTacos(int cm)
   {
      int dist = cm * 18;
      return dist;
   }
   
   public void followLine()
   {
      boolean flag = true;
      while (flag)
      {
         MR.resetTachoCount();
         while (light.getLightValue() != 0)
         {
            MR.controlMotor(pwr, 2);
            ML.controlMotor(pwr, 1);
         }
      }
   }
   
   public void resetCount()
   {
      MR.resetTachoCount();
      ML.resetTachoCount(); 
   }
   
}
