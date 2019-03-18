#include <LiquidCrystal_I2C.h>
#include <Keypad.h>

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

String kcharr="";
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS );

void keypadEvent(KeypadEvent key){
  switch (keypad.getState()){
    case PRESSED:
      if(key=='#')
      {
        lcd.clear();
      }
      else
      {
        lcd.clear();
        kcharr="";
        kcharr+=key;
        lcd.print(kcharr);
      }
      delay(100);
    break;
    case RELEASED:
      
    break;
    case HOLD:
      
    break;
  }
}


void setup(){
  lcd.begin(20,4);
  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(0, 1);
  
  keypad.addEventListener(keypadEvent);  // Add an event listener.
  keypad.setHoldTime(100);               // Default is 1000mS
  keypad.setDebounceTime(50); 
  //Serial.begin(9600);
}

void loop(){
  char key = keypad.getKey();
  
}
