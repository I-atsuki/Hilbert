package jp.ac.titech.itpro.sdl.hilbert;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HilbertTurtle extends Turtle {

    public HilbertTurtle(Drawer drawer) {
        super(drawer);
    }
    //ArrayList<Integer> blst;
    //ArrayList<Integer>


    public void draw(int order, double step, double turn) {

        ArrayList<Integer> lst = beforedraw(order,step,1);
        for(int i =0; i < lst.size() ; i++){
            switch (lst.get(i)){
                case 0:
                    forward(step);
                    break;
                case 1:
                    rotate(turn);
                    break;
                case -1:
                    rotate(-turn);
                    break;
                case 10:
                    turn = -turn;
                    break;
            }
        }
    }
    public ArrayList<Integer> beforedraw(int order,double step,int tu){
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if (order > 0) {
            lst.add(-1 *tu);
            lst.add(10);
            ArrayList<Integer> a = beforedraw(order - 1, step,tu);
            lst.addAll(a);
            lst.add(10);
            lst.add(0);
            lst.add(1*tu);
            lst.addAll(a);
            lst.add(0);
            lst.addAll(a);
            lst.add(1*tu);
            lst.add(0);
            lst.add(10);
            lst.addAll(a);
            lst.add(10);
            lst.add(-1*tu);
        }
        return lst;
    }



}

