
//awt allows us to ask questions of the OS
import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI extends JFrame {

    public static void main(String[] args) {
        new GUI();
    }

    public GUI(){
        JFrame frame = this;
        this.setSize(750,750);
//      this.setLocationRelativeTo(null);
//      create new instance of the toolkit
        Toolkit tk = Toolkit.getDefaultToolkit();
//      get the current screen size that we are working from
        Dimension dim = tk.getScreenSize();
//      centers the window
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
//      set the position of the window
        this.setLocation(xPos,yPos);
//      prevent the resizing of the window
//      cleanup on close(red close button pressed)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      set the title of the window
        this.setTitle("Grid");

//      create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));


        //create panel for text input
        JPanel buttonPanel = new JPanel();
        //create the submit button and add it to the text panel
        JButton generateButton = new JButton("Generate");
        buttonPanel.add(generateButton);

        //add the text panel to the main panel
        mainPanel.add(buttonPanel);


//      listen for submit button clicked
//      add panel to the frame
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              grab the text field contents
//              check if the string is not valid
                int n = generateRandomValue();
                int maxRows = n;
                int maxColumns = n;
                //check if the user already pressed the submit button so we dont keep adding grids to the layout
                if(mainPanel.getComponentCount()>1){
                    //the user already added a grid so delete the grid and revalidate
                    Component[] comp = mainPanel.getComponents();
                    mainPanel.remove(comp[1]);
                    frame.revalidate();
                }
                //create the grid of numbers
                //create panel for grid
                JPanel gridPanel = new JPanel();
                //set the grid layout for the grid panel using the converted input
                gridPanel.setLayout(new GridLayout(maxRows,maxColumns,0,0));
                //add labels
                for(int i = 0;i<maxRows;++i){
                    for(int j = 0;j<maxColumns;++j){
                        //TODO: generate the valid grid number
                        //create a label and add it to the layout
                        JLabel label = new JLabel("1",SwingConstants.CENTER);
                        //set the border for each cell
                        label.setBorder(BorderFactory.createLineBorder(Color.black));
                        //add the label to the grid
                        gridPanel.add(label);
                    }
                }
                mainPanel.add(gridPanel);
                frame.revalidate();
            }
        });
        this.add(mainPanel);
        System.out.println(mainPanel.getComponentCount());


//      show the window
        this.setVisible(true);
    }
    public static int generateRandomValue(){
        int[] array = new int[4];
        array[0] = 5;
        array[1] = 7;
        array[2] = 9;
        array[3] = 11;
        int rand = (int)(Math.random()*4);
        return array[rand];

    }
    //get the grid number depending on the current row and column
    public static int generateGridNumber(int currentRow, int currentColumn){
        return 0;
    }
    public static int[][] create2DArray(int rows, int columns){
        int[][] array = new int[rows][columns];
        //TODO: implement array with generated grid numbers
        for(int i = 0; i<rows;++i){
            for(int j = 0;j<columns;++j){
                array[i][j] = generateGridNumber(i,j);
            }
        }
        //set the goal cell to 0
        array[rows-1][columns-1]=0;
        return array;
    }
}
