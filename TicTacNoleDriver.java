/*
Amir Yousef
Project 1
COP3252 - Spring14
Class - TicTacNoleDriver.java
3/2/2014
*/

import java.awt.*;
import javax.swing.*;

public class TicTacNoleDriver
{

public static void main(String[] args)
{
// Create ticTacNoleFrame and ticTacNoleApplet 
TicTacNole ticTacNoleApplet = new TicTacNole();
JFrame ticTacNoleFrame = new JFrame("Tic Tac Nole");
ticTacNoleFrame.add(ticTacNoleApplet, BorderLayout.CENTER);
ticTacNoleFrame.setSize(1500,1500);
ticTacNoleFrame.setVisible(true);
}

}