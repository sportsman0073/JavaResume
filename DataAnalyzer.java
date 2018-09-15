import javax.swing.*;
import java.awt.*;

public class DataAnalyzer {
    public static void main(String[] args){
        int num = 0;

        int again = 0;
        int dataSet = 0;
        do {
            do {
                num = Integer.parseInt(JOptionPane.showInputDialog(null, "How many observations do the data contain?", "Input", JOptionPane.QUESTION_MESSAGE));
            } while (num <= 0);
            double[] data = new double[num];
            for (int i = 0; i < num; i++) {
                data[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "please enter observation " + (i+1) + ":", "Input", JOptionPane.QUESTION_MESSAGE));
            }


            do {
//                JButton min = new JButton("Min");
//                JButton max = new JButton("Max");
//                JButton med = new JButton("Median");
//                JButton mean = new JButton("Mean");
//                JButton sum = new JButton("Sum");
//                JPanel panel = new JPanel();
//                panel.add(min);
//                panel.add(max);
//                panel.add(med);
//                panel.add(mean);
//                panel.add(sum);
                Object[] options = {(Object)"Min","Max","Median","Mean","Sum"};
                int choice = 0;
                double min = 0;
                double max = 0;
                double med = 0;
                double sum = 0;
                double mean = 0;
                double add = 0;
                choice = JOptionPane.showOptionDialog(null,"What do you want to know about the data?", "Data Analyzer",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
                if(choice==0){
                    for (int i = 0; i < data.length ; i++) {
                        if(data[0]<data[i]){
                            min = data[0];
                        }else{
                            min = data[i];
                        }
                    }
                    JOptionPane.showMessageDialog(null, "the min is "+String.format("%.2f",min), "Message",JOptionPane.INFORMATION_MESSAGE);

                }else if(choice==1){
                    for (int i = 0; i < data.length; i++) {
                        if(data[0]>data[i]){
                            max = data[0];
                        }else{
                            max = data[i];
                        }
                    }
                    JOptionPane.showMessageDialog(null, "the max is "+String.format("%.2f",max), "Message",JOptionPane.INFORMATION_MESSAGE);

                }else if(choice ==2){
                    for (int i = 0; i < data.length; i++) {
                        for (int j = i+1; j < data.length; j++) {
                            if (data[i] > data[j]&&i!=j){
                                double temp = data[j];
                                data[j] = data[i];
                                data[i] = temp;
                            }
                        }
                    }
                    if (data.length % 2 == 0){
                        med = ((data[data.length/2] + data[data.length/2 - 1])/2);
                    }else {
                        med = data[data.length / 2];
                    }
                    JOptionPane.showMessageDialog(null, "the median is "+String.format("%.2f",med), "Message",JOptionPane.INFORMATION_MESSAGE);


                }else if(choice ==3){
                    for (int i = 0; i < data.length; i++) {
                        add += data[i];
                    }
                    mean = add/data.length;
                    JOptionPane.showMessageDialog(null, "the mean is "+String.format("%.2f",mean), "Message",JOptionPane.INFORMATION_MESSAGE);

                }else if(choice==4){
                    for (int i = 0; i < data.length; i++) {
                        sum += data[i];
                    }
                    JOptionPane.showMessageDialog(null, "the sum is "+String.format("%.2f",sum), "Message",JOptionPane.INFORMATION_MESSAGE);

                }

                if (JOptionPane.showConfirmDialog(null, "Do you want to analyse this data set again?", "Data Analyzer", JOptionPane.YES_NO_OPTION) == 0) {
                    again = 0;
                } else {
                    again = 1;
                }
            } while (again == 0);
            if (JOptionPane.showConfirmDialog(null, "Do you want to analyse another data set?", "Data Analyzer", JOptionPane.YES_NO_OPTION) == 0) {
                dataSet = 0;
            } else {
                dataSet = 1;
            }
        }while(dataSet == 0);
        JOptionPane.showMessageDialog(null, "Thanks for using Data Analyzer!", "Message",JOptionPane.INFORMATION_MESSAGE);
    }

}
