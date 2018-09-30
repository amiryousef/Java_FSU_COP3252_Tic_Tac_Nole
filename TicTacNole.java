/*
Amir Yousef
Project 1
COP3252 - Spring14
Class - TicTacNole.java
3/2/2014
*/

// Packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// Create TicTacNole class 
public class TicTacNole extends JApplet 
{

// Declarations
private String player = "FSU";
private JLabel transaction  = new JLabel("FSU's turn");
private Click[][] array =  new Click[3][3];

// Constructor
public TicTacNole() 
{
// Create a Panel 
JPanel ticTacNolePanel = new JPanel(new GridLayout(3, 3, 0, 0));
for (int i = 0; i < 3; i++)
for (int j = 0; j < 3; j++)
ticTacNolePanel.add(array[i][j] = new Click());
// Create border title and status label
ticTacNolePanel.setBorder(new TitledBorder(new LineBorder(Color.gray, 30), "FSU"));
transaction .setBorder(new TitledBorder(new LineBorder(Color.gray,30), "By Amir Yousef"));
add(ticTacNolePanel, BorderLayout.CENTER);
add(transaction , BorderLayout.SOUTH);
}

// Create class Click 
public class Click extends JPanel 
{
private String input = " ";
// Constructor
public Click() 
{
// Create border and mouse listener
setBorder(new LineBorder(Color.gray,30));  
addMouseListener(new MouseListener());   
}
// Check availabaility
public boolean available() 
{
for (int i = 0; i < 3; i++)
for (int j = 0; j < 3; j++)
if (array[i][j].returnPlayerInput() == " ")
return false;
return true;
}

// Get player input method
public String returnPlayerInput() 
{
return input;
}

// Set player input method
public void setPlayerInput(String token) 
{
input = token;
repaint();
}

// Color player input 
protected void paintComponent(Graphics g) 
{
super.paintComponent(g);
if (input == "FSU") 
{
this.setBackground(Color.WHITE);
g.setColor(Color.RED);
g.setFont(new Font("FSU", Font.BOLD, 180));
g.drawString("FSU",40, 180);
}
else if (input == "USF") 
{
this.setBackground(Color.WHITE);
g.setColor(Color.GREEN);
g.setFont(new Font("USF", Font.BOLD,180));
g.drawString( "USF",40, 180);
}
}

// Check the winner
public boolean winner(String input) 
{
// Check horizontaly 
for (int i = 0; i < 3; i++)
if ((array[i][0].returnPlayerInput() == input) && (array[i][1].returnPlayerInput() == input) && (array[i][2].returnPlayerInput() == input)) 
{
return true;
}
// Check parallel
for (int j = 0; j < 3; j++)
if ((array[0][j].returnPlayerInput() ==  input) && (array[1][j].returnPlayerInput() == input) && (array[2][j].returnPlayerInput() == input)) 
{
return true;
}
// Check diagonal
if ((array[0][0].returnPlayerInput() == input) && (array[1][1].returnPlayerInput() == input) && (array[2][2].returnPlayerInput() == input)) 
{
return true;
}
// Check diagonal
if ((array[0][2].returnPlayerInput() == input) && (array[1][1].returnPlayerInput() == input) && (array[2][0].returnPlayerInput() == input)) 
{
return true;
}
return false;
}

// Create MouseListener class
private class MouseListener extends MouseAdapter 
{
// Create mouse array method
public void mouseClicked(MouseEvent e) 
{
// Check the availability and the turn
if (input == " " && player != " ") 
{
setPlayerInput(player); 
// Check the status
if (winner(player)) 
{
// Display the winner
transaction .setText(player + " Is The Winner ... Game Over");
player = " "; 
}
else if (available()) 
{
// Display no winner
transaction .setText("No Winner ... Game Over");
player = " "; 
}
else 
{
// Display the player's turn
player = (player == "FSU") ? "USF": "FSU"; 
transaction .setText(player + "'s Turn");  
}
}
}
}

}

}
