
 import java.io.*;

 // �����-����� ��� ��������� ����� ����������
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
 // ��������� ����������� ����� � ��������
 // �� ����� ����� ������ ������ ���������
 // ����������
 out.write(100+(int)(Math.random()*155));
 out.write(100+(int)(Math.random()*155));
 out.write(100+(int)(Math.random()*155));
 }
 catch(IOException ex)
 {}
 try
 {
 // �������� ����� �� ���������
 // ���������� �����
 sleep((int)(Math.random()*10000));
 }
 catch(InterruptedException e)
 {}
 }
 }
 }
