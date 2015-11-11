//package csm10j.lab11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
/**
 *
 * @author Michelle
 */
public class Program extends JFrame
{
    private final JTextField[] gradesArray = new JTextField[4];
    private final JTextField[] weightArray = new JTextField[4];
    private final JTextField totalWeightBox = new JTextField();
    private final JButton calculateButton = new JButton("Calculate");
    private final JLabel gradePercentLabel = new JLabel("Grade %");
    private final JLabel weightLabel = new JLabel("Weight");
    private final GridLayout theGrid = new GridLayout(6,2);
    
    public static void main(String[] args) 
    {
      Program p = new Program();
      p.setup();
      p.setSize(400, 600);
      p.setVisible(true);
    }
    public void setup()
    {
      Container pane = getContentPane();
      pane.setLayout(theGrid);
      
      pane.add(gradePercentLabel);
      pane.add(weightLabel);
      
      for (int i = 0; i < gradesArray.length; i++)
      {
          gradesArray[i] = new JTextField(200);
          weightArray[i] = new JTextField(200);
          pane.add(gradesArray[i]);
          pane.add(weightArray[i]);
      }
      
      pane.add(calculateButton);
      pane.add(totalWeightBox);
      calculateButton.addActionListener(new CalculateButtonListener());
    }
    
    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ape)
        { 
            Double totalWeight = 0.00;
        
        try
        {
           for (int i = 0; i < gradesArray.length; i++)
                totalWeight += (Double.parseDouble(gradesArray[i].getText()) * Double.parseDouble(weightArray[i].getText()));
                
           DecimalFormat df = new DecimalFormat("#.00");
           totalWeightBox.setText(df.format(totalWeight));
           
        }
        catch (Exception ex)
         {
             totalWeightBox.setText("N/A");
         }
            
        }
        
    }
}
