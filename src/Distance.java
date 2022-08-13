import lejos.nxt.*;


public class Distance
{

   public static void main(String[] args) throws InterruptedException
   {
      int pwrleft;
      int pwrright;
      MotorPort motorleft;
      MotorPort motorright;
      
      pwrleft = 75;
      pwrright = 75;
      motorleft = MotorPort.B;
      motorright = MotorPort.C;
      
      UltrasonicSensor ultrasonic;
      ultrasonic = new UltrasonicSensor(SensorPort.S1);
      
      LCD.clear();
      LCD.drawString("Press any key", 0, 0);
      
      int tacho = 1;
      double pi = 3.14;
      double wheeldistance = 50.0; 
      double wheeldiameter = wheeldistance / 2.0;
      
      boolean now = false;
      
      while(!now)
         {
         if (motorleft.getTachoCount() < tacho * 90)
         {
            motorleft.controlMotor(pwrleft, 1);
         }
         else 
         {
            motorleft.controlMotor(0,  3);
         }
         
         if (motorright.getTachoCount() < tacho * 60)
         {
            motorright.controlMotor(pwrleft, 1);
         }
         
         LCD.clear();
         LCD.drawString("Distance: " + ultrasonic.getDistance(), 0, 0);
         }
      
      
   }
}