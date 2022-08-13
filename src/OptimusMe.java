import lejos.nxt.*;

public class OptimusMe
{
   MotorPort ML = MotorPort.B;
   MotorPort MR = MotorPort.A;
   UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
   TouchSensor touch = new TouchSensor(SensorPort.S4);
   
   public void forward(int distance)
   {
      distance = distance * 18;
      while (ML.getTachoCount() < distance)
      {
         MR.controlMotor(100, 1);
         ML.controlMotor(100, 1);
      }
   }
   
   public void forward()
   {
      MR.controlMotor(90, 1);
      ML.controlMotor(90, 1);
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
      MR.controlMotor(90, 2);
      ML.controlMotor(90, 2);
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
         MR.controlMotor(90, 1);
         ML.controlMotor(90, 2);
      }
   }
   
   public int cmToTacos(int cm)
   {
      int dist = cm * 18;
      return dist;
   }
   
   
}
