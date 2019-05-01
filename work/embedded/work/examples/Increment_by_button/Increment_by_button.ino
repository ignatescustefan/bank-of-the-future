
//int i=0;
//String cnt=""+i;
//void setup() {
//  
//  // put your setup code here, to run once:
//  Serial.begin(9600);
//  
//}
//
//void loop() 
//{
//  //i=0;
//  char b[3];
//  Serial.print("Raileanu suge pula de ");
//  cnt=""+i;
//  cnt.toCharArray(b,3);
//  Serial.print(i);
//  Serial.println(" de ori.");
//  i=i+1;
//  delay(750);
//}

#include <LiquidCrystal_I2C.h>
unsigned int i=0;
unsigned int j=0;
char ch=219;
const unsigned int interruptPin1=D3; //stanga
const unsigned int interruptPin2=D5; //dreapta
const unsigned int interruptPin3=D6; //sus
const unsigned int interruptPin4=D7; //jos
const unsigned int interruptPin5=; //reset : D4, 1/TX, 3/RX

String cnt="";
unsigned short int flag=0;

LiquidCrystal_I2C lcd(0x27, 20, 4);

void handleInterrupt1() {       //stanga
    
    if(flag==1)
    {
      lcd.clear();
      if(i>=1)
        i--;
      flag=0;  
    }
}

void handleInterrupt2() {       //dreapta
    if(flag==1)
    {
      lcd.clear();
      if(i<=18)
        i++;
      flag=0;  
    }
    
}

void handleInterrupt3() {        //sus
      if(flag==1)
    {
      lcd.clear();
      if(j>=1)
        j--;
      flag=0;  
    }
    
    
    
}

void handleInterrupt4() {       //jos
      if(flag==1)
    {
      lcd.clear();
      if(j<=2)
        j++;
      flag=0;  
    }
    
    
}

void handleInterrupt5() {       //reset
      if(flag==1)
    {
      lcd.clear();
      i=0;
      j=0;
      flag=0;  
    }
    
    
}

void setup() {
  Serial.begin(9600);
  cnt.concat(ch);
  pinMode(interruptPin1, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin1), handleInterrupt1, RISING);
  pinMode(interruptPin2, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin2), handleInterrupt2, RISING);
  pinMode(interruptPin3, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin3), handleInterrupt3, RISING);
  pinMode(interruptPin4, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin4), handleInterrupt4, RISING);
  pinMode(interruptPin5, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(interruptPin5), handleInterrupt5, FALLING);


  lcd.begin(20,4);
  lcd.init();

  lcd.backlight();
  lcd.setCursor(0, 0);
  i=0;
  j=0;
  lcd.print(cnt);
  
}

void loop() {
  
  //lcd.clear();
  //delay(250);
  if(flag==0)
  {
    delay(100);
    lcd.setCursor(i, j);
  lcd.print(cnt);
  flag=1;
  }
  

  //delay(500);
}
