import java.awt.*;
import java.io.*;

// класс-поток для рисования фейерверка
class ZalpThr extends Thread
{
    int M=300,N=300;
    int zx,zy;
    int zd;
    boolean znew=true;
    int r,g,b;
    PipedInputStream in=null;
    Graphics gr;

    ZalpThr(PipedInputStream in,Graphics gr)
    {
        this.in=in;
        this.gr=gr;
    }
    public void run()
    {
        while (true)
        {
            if (znew)
            {
                zx=(int)(Math.random()*M);
                zy=(int)(Math.random()*N);
                zd=0;
                znew=false;
                // проверяем наличие данных в потоке ввода
                // если они там есть, то считываем их
                try
                {
                    if (in.available()>0)
                        r=in.read();
                    if (in.available()>0)
                        g=in.read();
                    if (in.available()>0)
                        b=in.read();
                }
                catch(IOException ex)
                {
                    System.out.println("Exception!!!");
                }
            }
            else
            {
                zd+=10;
                if(zd>=M)
                    znew=true;
            }
            paint();
            try
            {
                sleep(50);
            }
            catch(InterruptedException e)
            {
            }

        }
    }

    public void paint()
    {
        int x,y;
        int d;
        Color col=new Color(r,g,b);
        gr.setColor(col);
        gr.clearRect(0,0,M,N);
        if (zd==0)
        {
            gr.fillOval(zx,zy,10,10);
        }
        else if (zd<=M/2)
        {
            double dvaPI=2*Math.PI;
            double step=dvaPI/100;
            for (double i=0; i<dvaPI; i+=step)
            {
                d=zd/2+(int)(Math.random()*zd/2);
                x=zx+(int)(d*Math.cos(i));
                y=zy-(int)(d*Math.sin(i));
                gr.fillOval(x,y,5,5);
            }
        }
    }
}