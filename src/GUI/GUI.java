package GUI;

import Kristijonas_Projektas.DynamicArray;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import Kristijonas_Projektas.DynamicArrayPerformance;
import Kristijonas_Projektas.Darbininkas;


public class GUI extends JFrame implements Serializable, ActionListener {

    private static final int RECORDS_NUMBER = 15;
    
    ArrayList<Darbininkas> primaryData    = new ArrayList<>();
    DynamicArrayPerformance pagr = new DynamicArrayPerformance();


    JButton indexOf             =   new JButton("Index Of metodas");
    JButton Addmethod           =   new JButton("ADD metodas");
    JButton getMethod           =   new JButton("Get metodas");
    JButton removeAt            =   new JButton("removeAt metodas");
    JButton containsM           =   new JButton("contains Metodas");
    JButton containsBtn           =   new JButton("add su indexu Metodas");
    
    JPanel dataBlock        =  new JPanel();
    JPanel buttonsBlock     =  new JPanel();
    
    JTextArea leftTextarea          = new JTextArea(40,80);    
    JScrollPane addScrollForLeft    = new JScrollPane(leftTextarea);
    
    
    public GUI()
    {
        
        Container inside = getContentPane();  
        inside.setLayout(new BoxLayout(inside, BoxLayout.Y_AXIS));
        
        inside.add(dataBlock);
        inside.add(buttonsBlock);
        
        indexOf.addActionListener(this);
        Addmethod.addActionListener(this);
        getMethod.addActionListener(this);
        removeAt.addActionListener(this);
        containsM.addActionListener(this);
        containsBtn.addActionListener(this);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        arrangement();
        appereance();
        setVisible(true);    
        pack();
    }
    
    private void arrangement() {
        setLocation(0, 0);
   
        dataBlock.add(addScrollForLeft);    
        buttonsBlock.setLayout(new BoxLayout(buttonsBlock, BoxLayout.X_AXIS));      
        buttonsBlock.add(indexOf);
        buttonsBlock.add(Addmethod);
        buttonsBlock.setLayout(new BoxLayout(buttonsBlock, BoxLayout.X_AXIS)); 
        buttonsBlock.add(getMethod);
        buttonsBlock.add(removeAt);
        buttonsBlock.add(containsM);
        buttonsBlock.add(containsBtn);
    }

    private void appereance() {
        dataBlock.setBorder(new TitledBorder("DinamicArray Langas"));
     
        dataBlock.setBackground(Color.lightGray);
        buttonsBlock.setBackground(Color.lightGray);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object clickedBtn = e.getSource();
       if(clickedBtn == indexOf) {
           this.indexOf();
       }
       else if(clickedBtn == Addmethod) {
           this.Addmethod();
       }
       else if(clickedBtn == getMethod) {
           this.getMethod();
       }
       else if(clickedBtn == removeAt) {
           this.removeAt();
       }
       else if(clickedBtn == containsM) {
           this.containsM();
       }
       else if(clickedBtn == containsBtn) {
           this.containsBtn();
       }
    }
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        GUI gui = new GUI();
    }
    
    

    private void Addmethod() {
        
        primaryData.clear();

        leftTextarea.setText("");
        
        DynamicArrayPerformance speedTest = new DynamicArrayPerformance(); 
        speedTest.addAtComparison();
        this.reprintLeftTextArea();
        
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        leftTextarea.append("Add metodas DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.add(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.add(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList yra greitesnis tiek: " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
        
        
       
    }

    private void getMethod() {
        primaryData.clear();

        leftTextarea.setText("");
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        leftTextarea.append("Get metodas. DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.get(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }

        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.get(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
        
    }

    private void indexOf() {
        primaryData.clear();

        leftTextarea.setText("");
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        leftTextarea.append("Index of metodas. DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.indexOf(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.indexOf(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
        
        
    }

    private void removeAt() { 
        primaryData.clear();

        leftTextarea.setText("");
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        
        leftTextarea.append("RemoveAt metodas. DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.remove((Object)value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.remove((Object)value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList laikas per  " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
    }
    
    private void containsM() {
        primaryData.clear();

        leftTextarea.setText("");
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        
        leftTextarea.append("Contains metodas. DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.contains(value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.contains(value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList laikas per " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
        
    }
    
    private void containsBtn() {
        primaryData.clear();

        leftTextarea.setText("");
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        
        leftTextarea.append("Add su indexu metodas. DynamicArray vs ArrayList" + "\n");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                dynamicArray.add((i+j),value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            leftTextarea.append("DynamicArray laikas per " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    dynamicArrayTime + "\n" );
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                Integer value = i + j;
                arrayList.add((i+j),value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            leftTextarea.append("ArrayList laikas per " + (i + 1)*LOWER_ITERATIONS + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        
        if (dynamicArrayTime < arrayListTime){
            leftTextarea.append("Dynamic array yra greitesnis tiek: " + (arrayListTime - dynamicArrayTime)+ " ns" + "\n");
        } else {
            leftTextarea.append("Array list yra greitesnis tiek: " + (dynamicArrayTime - arrayListTime)+ " ns" + "\n");
        }
        
    }
    
    private void reprintLeftTextArea() {
        leftTextarea.setText("");
            for(int i = 0; i < primaryData.size(); i++) {
               leftTextarea.append(primaryData.get(i).toString());
            }
    }
    
    public DynamicArray<Integer> formIntegerDynamicArray(){
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                dynamicArray.add(i + j);
            }
        }
        return dynamicArray;
    }
    
    public ArrayList<Integer> formIntegerArrayList(){
        int UPPER_ITERATIONS = 10;
        int LOWER_ITERATIONS = 100;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < UPPER_ITERATIONS; i++){
            for (int j = 0; j < LOWER_ITERATIONS; j++){
                arrayList.add(i + j);
            }
        }
        return arrayList;
    }
    
    
}
    
