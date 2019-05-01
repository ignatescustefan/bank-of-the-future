#include <LiquidCrystal_I2C.h>
#include <Keypad.h>

//void(* MCU_reset)(void)=0;
LiquidCrystal_I2C lcd(0x27, 20, 4);
const byte ROWS = 4; //four rows
const byte COLS = 3; //three columns
char keys[ROWS][COLS] = {
  {'1','2','3'},
  {'4','5','6'},
  {'7','8','9'},
  {'*','0','#'}
};
byte rowPins[ROWS] = {D4,1, 3, D6}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {D5, D3, 13}; //connect to the column pinouts of the keypad

/////////////////////////////
//D4=R1
//1=R2
//3=R3
//D6=R4
//D5=C1
//D3=C2
//13=C3
/////////////////////////////

short int State=-1;
unsigned short int Ci=0;
unsigned short int Cj=0;

short int PIN[]={1,2,3,4};
short int PIN_from_user[]={-1,-1,-1,-1};
unsigned int PIN_index=0;
unsigned short int PIN_attempts=3;
bool PIN_good=true;

void LCD_print(unsigned short int CI,unsigned short int CJ,String msg)
{
  Ci=CI;
  Cj=CJ;
  lcd.setCursor(Ci,Cj);
  lcd.print(msg);
}

void Execute_State_0()
{
  State=0;
  
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(0, 1);
  lcd.clear();
  LCD_print(6,1,"RIPBank");
  LCD_print(7,2,"TOKEN");
  delay(2000);
  Execute_State_1();
}

void Execute_State_1()
{
  State=1;
  int cnt=0;
  lcd.clear();
  delay(100);
  LCD_print(2,0,"Se conecteaza la");
  LCD_print(8,1,"WiFi");
  while(cnt<8)
  {
    LCD_print(6+cnt,2,".");
    ++cnt;
    delay(250);
  }
  delay(250);
  Execute_State_3(); 
}

void Execute_State_3()
{
  State=3;
  lcd.clear();
  LCD_print(6,0,"Conectat");
  LCD_print(9,1,"la");
  LCD_print(7,2,"Wifi!!");
  delay(1500);
  Execute_State_4();
}

void Execute_State_4()
{
  State=4;
  int cnt=0;
  lcd.clear();
  delay(150);
  LCD_print(2,0,"Se conecteaza la");
  LCD_print(7,1,"Server");
  
  while(cnt<8)
  {
    LCD_print(6+cnt,2,".");
    ++cnt;
    delay(250);
  }
  delay(250);
  Execute_State_6(); 
}

void Execute_State_6()
{
  State=6;
  lcd.clear();
  LCD_print(6,0,"Conectat");
  LCD_print(9,1,"la");
  LCD_print(6,2,"Server!!");
  delay(1500);
  Execute_State_7();
}

void Execute_State_7()
{
  State=7;
  int cnt=0;
  lcd.clear();
  delay(150);
  LCD_print(9,0,"Se");
  LCD_print(4,1,"actualizeaza");
  while(cnt<8)
  {
    LCD_print(6+cnt,2,".");
    ++cnt;
    delay(250);
  }
  delay(250);
  Execute_State_9(); 
}

void Execute_State_9()
{
  State=9;
  lcd.clear();
  LCD_print(5,0,"Actualizat");
  LCD_print(9,1,"cu");
  LCD_print(6,2,"succes!!");
  delay(1500);
  Execute_State_10();
}

void Execute_State_10()
{
  State=10;
  lcd.clear();
  LCD_print(3,0,"Alege optiune:");
  LCD_print(1,1,"1 Autentificare");
  LCD_print(1,2,"2     Despre");
  LCD_print(1,3,"3     Iesire"); 
}

void Execute_State_11()
{
  State=11;
  lcd.clear();
  LCD_print(1,0,"Despre dispozitiv:");
  LCD_print(3,1,"RIPBankC Token");
  LCD_print(5,2,"v0.3 alpha");
  delay(2500);
  Execute_State_10();
}

void Execute_State_12()
{
  State=12;
  lcd.clear();
  LCD_print(1,0,"Introdu codul PIN:");
  String att="";
  att+=(char)(PIN_attempts+'0');
  att+=" incercari ramase:";  
  LCD_print(0,1,att);
  PIN_index=0;
  PIN_from_user[0]=-1;
  PIN_from_user[1]=-1;
  PIN_from_user[2]=-1;
  PIN_from_user[3]=-1;
  Ci=8;
  Cj=2;
}

void Execute_State_14()
{
  State=14;
  lcd.clear();
  LCD_print(4,1,"PIN CORECT!!");
  delay(2000);
  Execute_State_15();
}

void Execute_State_19()
{
  State=19;
  lcd.clear();
  LCD_print(4,1,"PIN GRESIT!!");
  delay(2000);
}

void Execute_State_13()
{
  State=13;
  lcd.clear();
  LCD_print(1,0,"Ati introdus PINUL");
  LCD_print(2,1,"GRESIT de 3 ori!!");
  LCD_print(1,2,"Dispozitivul se va");
  LCD_print(5,3,"inchide!!!");
  delay(4000);
  Execute_State_18();
}

void Execute_State_15()
{
  State=15;
  int cnt=0;
  lcd.clear();
  delay(150);
  LCD_print(2,0,"Se trimit datele");
  LCD_print(2,1,"de autentificare");
  while(cnt<8)
  {
    LCD_print(5+cnt,2,".");
    ++cnt;
    delay(250);
  }
  delay(250);
  Execute_State_17();
}

void Execute_State_17()
  {
    State=17;
    lcd.clear();
    LCD_print(3,0,"Datele au fost");
    LCD_print(1,1,"trimise cu succes!");
    delay(2500);
    Execute_State_18();
  }

void Execute_State_18()
{
    State=18;
    lcd.clear();
    LCD_print(3,1,"Se inchide....");
    delay(1500);
    lcd.clear();
    lcd.noBacklight();
}

void Execute_State_2()
  {
    State=2;
    lcd.clear();
    LCD_print(1,1,"Conectare la Wifi");
    LCD_print(5,2,"NEREUSITA!");
    delay(2500);
    Execute_State_10();
  }

void Execute_State_5()
  {
    State=5;
    lcd.clear();
    LCD_print(0,1,"Conectare la Srerver");
    LCD_print(5,2,"NEREUSITA!");
    delay(2500);
    Execute_State_10();
  }

void Execute_State_8()
  {
    State=8;
    lcd.clear();
    LCD_print(4,1,"Actualizare");
    LCD_print(5,2,"NEREUSITA!");   
    delay(2500);
    Execute_State_10();
  }

void Execute_State_16()
  {
    State=16;
    lcd.clear();
    LCD_print(1,1,"Trimiterea datelor");
    LCD_print(5,2,"NEREUSITA!");
    delay(2500);
    Execute_State_10();
  }

//String kcharr="";
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS );

void keypadEvent(KeypadEvent key)
{
  int j=0;
  String str="";
  
  switch (keypad.getState())
  {
    case PRESSED:

      if(key=='*')
      {
        if(State!=12)
        {
          Execute_State_0();
        }
        else
        {
          Execute_State_12();
        }
      }

      
      if(key=='9' and State!=12)
      {
        ESP.reset();
      }

      if(State==12)
      {
       switch(key)
       {
          case '0':
          case '1':
          case '2':
          case '3':
          case '4':
          case '5':
          case '6':
          case '7':
          case '8':
          case '9':
            if(PIN_index<4)
            {
              str="";
              str+=key;
              LCD_print(8+PIN_index,Cj,str);
              delay(400);
              LCD_print(8+PIN_index,Cj,"*");
              PIN_from_user[PIN_index]=key-'0';
              PIN_index++;
            }
            break;
          case '#':
            for(j=0;j<4;++j)
            {
              if(PIN[j]!=PIN_from_user[j])
              {
                PIN_good=false;
              }
            }
            if(PIN_good==true)
            {
              Execute_State_14();
            }
            else
            {
              Execute_State_19();
              PIN_attempts--;
              if(PIN_attempts>0)
              {
                PIN_good=true;
                Execute_State_12();
              }
              else
              {
                Execute_State_13();
              }
            }
            break;
        }
      }
      
      if(State==10)
      {
        switch(key)
        {
          case '1':
            if(PIN_attempts>0)
            {
              Execute_State_12();
            }
            else
            {
              Execute_State_13();
            }
            break;
          case '2':
            Execute_State_11();
            break;
          case '3':
            Execute_State_18();
            break;
          case '4':
            Execute_State_2();
            break;
          case '5':
            Execute_State_5();
            break;
          case '6':
            Execute_State_8();
            break;
          case '7':
            Execute_State_16();
            break;
          case '8':
            PIN_attempts=3;
            break;
          case '9':
            ESP.reset();
            break;
        }
      }

    delay(100);
    break;
    
    case RELEASED:
      
    break;
    
    case HOLD:
      
    break;
  }
}


void setup()
{
  lcd.begin(20,4);
  lcd.init();
  lcd.clear();
  lcd.noBacklight();
  
  keypad.addEventListener(keypadEvent);  // Add an event listener.
  keypad.setHoldTime(100);               // Default is 1000mS
  keypad.setDebounceTime(50); 
  //Serial.begin(9600);
}

void loop()
{
  char key = keypad.getKey();
}
