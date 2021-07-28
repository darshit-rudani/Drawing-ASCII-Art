package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

public class Logic
        implements LogicInterface {

    public static final String TAG = Logic.class.getName();

    private OutputInterface mOut;

    public Logic(OutputInterface out){
        mOut = out;
    }


    public void process(int size) {
        int height = size * 2 + 1;
        int width = size * 2 + 2;
        int accumulator = -(size+1);

        for(int i=1;i<=height;i++){
            accumulator++;
            for (int j=1;j<=width;j++) {
                if((i == 1 || i == height) && (j == 1 || j == width))
                    mOut.print("+");
                else if((i == 1 || i == height) && !(j == 1 || j == width))
                    mOut.print("-");
                else if(!(i == 1 || i == height) && (j == 1 || j == width))
                    mOut.print("|");
                else {
                    drawDiamond(size, i, j, accumulator);
                }
            }
            mOut.print("\n");
        }
    }

    public void drawDiamond(int size, int i, int j, int accumulator){
        int diamondRowThickness;
        if (accumulator <= 0){
            diamondRowThickness = i*2-2;
        } else {
            diamondRowThickness = (i-accumulator*2)*2-2;
        }
        int diamondMidpoint = size + 1;
        int diamondBoundsLeft = diamondMidpoint - (diamondRowThickness/2-1);
        int diamondBoundsRight = diamondMidpoint + (diamondRowThickness/2);
        int frameTop = 1;
        int frameBottom = size * 2 + 1;

        if (j >= diamondBoundsLeft && j <= diamondBoundsRight) {
            if (j == diamondBoundsLeft || j == diamondBoundsRight) {
                if (i < diamondMidpoint && i > frameTop) {
                    if (j == diamondBoundsLeft) {
                        mOut.print("/");
                    } else {
                        mOut.print("\\");
                    }
                } else if (i == diamondMidpoint) {
                    if (j == diamondBoundsLeft) {
                        mOut.print("<");
                    } else {
                        mOut.print(">");
                    }
                } else if (i > diamondMidpoint && i < frameBottom) {
                    if (j == diamondBoundsLeft) {
                        mOut.print("\\");
                    } else {
                        mOut.print("/");
                    }
                }
            } else {
                if (i % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
        } else {
            mOut.print(" ");
        }
    }

}