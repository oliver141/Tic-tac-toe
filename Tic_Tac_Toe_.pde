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
  void draw() {
    strokeWeight(8);
    if (pl == 1) {
      //Xcolour
      stroke(255, 230, 0);
      //creating the x
      line(width/42.6+x, height/42.6+y, width/3.87+x, height/3.87+y);
      line(width/42.6+x, height/3.87+y, width/3.87+x, height/42.6+y);
    } else if (pl == 0) {
      //Ocolour
      stroke(40, 14, 156);
      noFill();
      //creating ellipse 
      ellipse(width/7.1+x, height/7.1+y, width/4.26, height/4.26);
    }
    
    
    
    
    
    
  }
  void mousePressed(){
    if( over() && pl == 2 ){
      pl = turn;
      turn++;
      turn%=2;
    }
  }
  
  
  
  
  boolean over(){
    return(mouseX > x && mouseX < x + width/3.5 && mouseY > y && mouseY < y + height/3.5);
  }
}

Cell[] cells = new Cell[9];
int moves = 9;
float adjx, adjy;
boolean win = false;
int m;
int turn;





void setup() {
 
  size(620, 620);
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
  cells[0] = new Cell(adjx+(width/12.8), adjy+(height/12.8), 0);
  cells[1] = new Cell(adjx+(width/3.5+width/12.8), adjy+(height/12.8), 1);
  cells[2] = new Cell(adjx+(width-width/2.5+(width/12.8)/2), adjy+(height/12.8), 2);
  cells[3] = new Cell(adjx+(width/12.8), adjy+(height/3.5+height/12.8), 3);
  cells[4] = new Cell(adjx+(width/3.5+width/12.8), adjy+(height/3.5+height/12.8), 4);
  cells[5] = new Cell(adjx+(width-width/2.5+(width/12.8)/2), adjy+(height/3.5+height/12.8), 5);
  cells[6] = new Cell(adjx+(width/12.8), adjy+(height-height/2.5+(height/12.8)/2), 6);
  cells[7] = new Cell(adjx+(width/3.5+width/12.8), adjy+(height-height/2.5+(height/12.8)/2), 7);
  cells[8] = new Cell(adjx+(width-width/2.5+(width/12.8)/2), adjy+(height-height/2.5+(height/12.8)/2), 8);
}





void draw() {
  background(0);
  draw_board();
  for(int i=0;i<cells.length;cells[i++].draw());
}

void draw_board(){
  stroke(200);
  strokeWeight(8);
  line(adjx+(width/12.8), adjy+(height/3.5+height/12.8), adjx+(width-width/12.8), adjy+(height/3.5+height/12.8));
  line(adjx+(width/12.8), adjy+(height-height/2.5+(height/12.8)/2), adjx+(width-width/12.8), adjy+(height-height/2.5+(height/12.8)/2));
  line(adjx+(width/3.5+width/12.8), adjy+(height-height/12.8), adjx+(width/3.5+width/12.8), adjy+(height/12.8));
  line(adjx+(width-width/2.5+(width/12.8)/2), adjy+(height-height/12.8), adjx+(width-width/2.5+(width/12.8)/2), adjy+(height/12.8));
  stroke(150);
  //Text at bottom
  text("Escape to Exit", adjx+(width/2-35), adjy+(height-height/128));
}






void mousePressed() {
  for(int i=0;i<cells.length;cells[i++].mousePressed());
}
