package com.rudra.inheritance;

public class box {
    double l ;
     double h;
     double w;

     box () {
         this.h = -1;
         this.l = -1;
         this.w = -1;
     }

          box (double side){
              this.l = side;
              this.h=side;
              this.w=side;
         }

    public box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

//    copy constructor
    box(box old){
         this.h= old.h;
         this.l= old.l;
         this.w= old.w;
    }
    public void information(){
        System.out.println("Running the box");
    }

}

