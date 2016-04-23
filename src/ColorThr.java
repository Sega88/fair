
 import java.io.*;

 // класс-поток для генерации цвета фейерверка
 class ColorThr extends Thread
 {
 PipedOutputStream out;
 ColorThr(PipedOutputStream out)
 {
 this.out=out;
 }

 public void run()
 {
 while (true)
 {
 try
 {
 // генерация компонентов цвета и отправка
 // их через канал вывода потоку рисования
 // фейерверка
 out.write(100+(int)(Math.random()*155));
 out.write(100+(int)(Math.random()*155));
 out.write(100+(int)(Math.random()*155));
 }
 catch(IOException ex)
 {}
 try
 {
 // задается пауза до генерации
 // следующего цвета
 sleep((int)(Math.random()*10000));
 }
 catch(InterruptedException e)
 {}
 }
 }
 }
