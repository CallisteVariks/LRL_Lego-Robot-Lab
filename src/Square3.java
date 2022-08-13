import lejos.nxt.*;

public class Square3
{

   public static void main(String[] args)
   {
      // declaring and initializing the variables
      int pwrleft = 75;
      int pwrright = 75;
      MotorPort motorL = MotorPort.B;
      MotorPort motorR = MotorPort.A;
      double rWheel = 2.9;
      double dWheels = 11.2;
      double cWheel = 2* Math.PI * rWheel; 
      double cmInTacho = 360/cWheel;
      double halfRotation = dWheels/2 * Math.PI * 2 / 2 ;  
      double rightAngle= (halfRotation * cmInTacho)/2;
      
      //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount();
      
      //LCD clearing and "press to start"
      LCD.drawString("Press to start", 0, 0);
      Button.waitForAnyPress();
      LCD.clear();
      
      //moving forward 90 cm
      while (motorL.getTachoCount() < 90*cmInTacho) {
         while(motorL.getTachoCount() < 90*cmInTacho)
         {
           if ((motorL.getTachoCount() < 90*cmInTacho) && 
                 (motorR.getTachoCount() < 90*cmInTacho))
           { motorL.controlMotor(pwrleft, 1);
           motorR.controlMotor(pwrright, 1);}
           else
           {  motorR.controlMotor(0, 3);
           motorL.controlMotor(0, 3);}
         }
          motorL.controlMotor(pwrleft, 1);
          motorR.controlMotor (pwrright, 1);
      }
      
    //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount();
      
      // turning 90 deg counter-clockwise
      while (motorR.getTachoCount() < rightAngle){
         motorR.controlMotor(pwrright, 1);
         motorL.controlMotor(pwrleft, 2);
      }
      
    //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount(); 
      
      //moving forward 60 cm forward
      
      while (motorR.getTachoCount() < 60*cmInTacho ) {
         while(motorL.getTachoCount() < 60*cmInTacho)
         {
           if ((motorL.getTachoCount() < 60*cmInTacho) && 
                 (motorR.getTachoCount() < 60*cmInTacho))
           { motorL.controlMotor(pwrleft, 1);
           motorR.controlMotor(pwrright, 1);}
           else
           {  motorR.controlMotor(0, 3);
           motorL.controlMotor(0, 3);}
         }
         motorR.controlMotor(pwrright, 1);
         motorL.controlMotor(pwrleft, 1);
          
      }
    //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount(); 
      
   // turning 90 deg counter-clockwise
      while (motorR.getTachoCount() < rightAngle){
         motorR.controlMotor(pwrright, 1);
         motorL.controlMotor(pwrleft, 2);
      }
      
    //reseting the tacho-counter
      MotorPort.B.resetTachoCount();
      MotorPort.A.resetTachoCount(); 
      
   
 //moving forward 90 cm
   while (motorL.getTachoCount() < 90*cmInTacho) {
      while(motorL.getTachoCount() < 90*cmInTacho)
      {
        if ((motorL.getTachoCount() < 90*cmInTacho) && 
              (motorR.getTachoCount() < 90*cmInTacho))
        { motorL.controlMotor(pwrleft, 1);
        motorR.controlMotor(pwrright, 1);}
        else
        {  motorR.controlMotor(0, 3);
        motorL.controlMotor(0, 3);}
      }
         motorL.controlMotor(pwrleft, 1);
       motorR.controlMotor (pwrright, 1);
   }
   
 //reseting the tacho-counter
   MotorPort.B.resetTachoCount();
   MotorPort.A.resetTachoCount();
   
   // turning 90 deg counter-clockwise
   while (motorR.getTachoCount() < rightAngle){
      motorR.controlMotor(pwrright, 1);
      motorL.controlMotor(pwrleft, 2);
   }
   
 //reseting the tacho-counter
   MotorPort.B.resetTachoCount();
   MotorPort.A.resetTachoCount(); 
   
   //moving forward 60 cm forward
   
   while (motorR.getTachoCount() < 60*cmInTacho ) {
      while(motorL.getTachoCount() < 60*cmInTacho)
      {
        if ((motorL.getTachoCount() < 60*cmInTacho) && 
              (motorR.getTachoCount() < 60*cmInTacho))
        { motorL.controlMotor(pwrleft, 1);
        motorR.controlMotor(pwrright, 1);}
        else
        {  motorR.controlMotor(0, 3);
        motorL.controlMotor(0, 3);}
      }
      
      motorR.controlMotor(pwrright, 1);
      motorL.controlMotor(pwrleft, 1);
       
   }
}
}
