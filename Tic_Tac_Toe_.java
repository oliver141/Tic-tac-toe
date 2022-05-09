import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Tic_Tac_Toe_ extends PApplet {

//tictactoegame 
class Cell {
  float x;
  float y; 
  int pl = 2;
  int count;
  Cell(float xpos, float ypos, int num) {
    x = xpos;
    y = ypos;
    count = num;
    
    
    
    
  }
  public void draw() {
    strokeWeight(8);
    if (pl == 1) {
      //Xcolour
      stroke(255, 230, 0);
      //creating the x
      line(width/42.6f+x, height/42.6f+y, width/3.87f+x, height/3.87f+y);
      line(width/42.6f+x, height/3.87f+y, width/3.87f+x, height/42.6f+y);
    } else if (pl == 0) {
      //Ocolour
      stroke(40, 14, 156);
      noFill();
      //creating ellipse 
      ellipse(width/7.1f+x, height/7.1f+y, width/4.26f, height/4.26f);
    }
    
    
    
    
    
    
  }
  public void mousePressed(){
    if( over() && pl == 2 ){
      pl = turn;
      turn++;
      turn%=2;
    }
  }
  
  
  
  
  public boolean over(){
    return(mouseX > x && mouseX < x + width/3.5f && mouseY > y && mouseY < y + height/3.5f);
  }
}

Cell[] cells = new Cell[9];
int moves = 9;
float adjx, adjy;
boolean win = false;
int m;
int turn;





public void setup() {
 
  
  if (width >= height) {
    adjx = (width - height)/2;
    adjy = 0;
    width=height;
  } else {
    adjy = (height - width)/2;
    adjx = 0;
    height=width;
  }
  
  
  
  //Add cells
  cells[0] = new Cell(adjx+(width/12.8f), adjy+(height/12.8f), 0);
  cells[1] = new Cell(adjx+(width/3.5f+width/12.8f), adjy+(height/12.8f), 1);
  cells[2] = new Cell(adjx+(width-width/2.5f+(width/12.8f)/2), adjy+(height/12.8f), 2);
  cells[3] = new Cell(adjx+(width/12.8f), adjy+(height/3.5f+height/12.8f), 3);
  cells[4] = new Cell(adjx+(width/3.5f+width/12.8f), adjy+(height/3.5f+height/12.8f), 4);
  cells[5] = new Cell(adjx+(width-width/2.5f+(width/12.8f)/2), adjy+(height/3.5f+height/12.8f), 5);
  cells[6] = new Cell(adjx+(width/12.8f), adjy+(height-height/2.5f+(height/12.8f)/2), 6);
  cells[7] = new Cell(adjx+(width/3.5f+width/12.8f), adjy+(height-height/2.5f+(height/12.8f)/2), 7);
  cells[8] = new Cell(adjx+(width-width/2.5f+(width/12.8f)/2), adjy+(height-height/2.5f+(height/12.8f)/2), 8);
}





public void draw() {
  background(0);
  draw_board();
  for(int i=0;i<cells.length;cells[i++].draw());
}

public void draw_board(){
  stroke(200);
  strokeWeight(8);
  line(adjx+(width/12.8f), adjy+(height/3.5f+height/12.8f), adjx+(width-width/12.8f), adjy+(height/3.5f+height/12.8f));
  line(adjx+(width/12.8f), adjy+(height-height/2.5f+(height/12.8f)/2), adjx+(width-width/12.8f), adjy+(height-height/2.5f+(height/12.8f)/2));
  line(adjx+(width/3.5f+width/12.8f), adjy+(height-height/12.8f), adjx+(width/3.5f+width/12.8f), adjy+(height/12.8f));
  line(adjx+(width-width/2.5f+(width/12.8f)/2), adjy+(height-height/12.8f), adjx+(width-width/2.5f+(width/12.8f)/2), adjy+(height/12.8f));
  stroke(150);
  //Text at bottom
  text("Escape to Exit", adjx+(width/2-35), adjy+(height-height/128));
}






public void mousePressed() {
  for(int i=0;i<cells.length;cells[i++].mousePressed());
}
  public void settings() {  size(620, 620); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Tic_Tac_Toe_" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
