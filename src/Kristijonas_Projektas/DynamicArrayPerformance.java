
package Kristijonas_Projektas;

import java.util.ArrayList;

/**
 *
 * Kristijonas_Projektas
 */
public class DynamicArrayPerformance {
    
    private static final int iteracijos1 = 10;
    private static final int iteracijos2 = 100;
    
    public DynamicArrayPerformance(){
        this.addComparison();
        this.getComparison();
        this.indexOfComparison();
        this.removeComparison();
        this.containsComparison();
        this.addAtComparison();
    }
    
    public void addComparison(){
        System.out.println("Add method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                dynamicArray.add(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                arrayList.add(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    public void printConclusions(double dynamicArrayTime, double arrayListTime){
        if (dynamicArrayTime < arrayListTime){
            System.out.println("Dynamic array yra greitesnis tiek: " + (dynamicArrayTime/arrayListTime)+ " kartu" + "\n");
        } else {
            System.out.println("Array list yra greitesnis tiek: " + (arrayListTime/dynamicArrayTime)+ " kartu" + "\n");
        }
        System.out.println();
    }
    
    public DynamicArray<Integer> formIntegerDynamicArray(){
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < iteracijos1; i++){
            for (int j = 0; j < iteracijos2; j++){
                dynamicArray.add(i + j);
            }
        }
        return dynamicArray;
    }
    
    public ArrayList<Integer> formIntegerArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < iteracijos1; i++){
            for (int j = 0; j < iteracijos2; j++){
                arrayList.add(i + j);
            }
        }
        return arrayList;
    }
    
    public void getComparison(){
        System.out.println("Get method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                dynamicArray.get(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                arrayList.get(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    public void indexOfComparison(){
        System.out.println("Index of method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                dynamicArray.indexOf(i + j);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                arrayList.indexOf(i + j);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    public void removeComparison(){
        System.out.println("RemoveAt method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                dynamicArray.remove((Object)value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                arrayList.remove((Object)value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    public void containsComparison(){
        System.out.println("Contains method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                dynamicArray.contains(value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                arrayList.contains(value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
    public void addAtComparison(){
        System.out.println("Add with index method. DynamicArray vs ArrayList");
        DynamicArray<Integer> dynamicArray = this.formIntegerDynamicArray();
        double dynamicArrayTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                dynamicArray.add((i+j),value);
            }
            dynamicArrayTime += (System.nanoTime() - startTime); 
            System.out.println("DynamicArray laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    dynamicArrayTime + "\n");
        }
        ///
        ArrayList<Integer> arrayList = this.formIntegerArrayList();
        double arrayListTime = 0;
        for (int i = 0; i < iteracijos1; i++){
            double startTime = System.nanoTime();
            for (int j = 0; j < iteracijos2; j++){
                Integer value = i + j;
                arrayList.add((i+j),value);
            }
            arrayListTime += (System.nanoTime() - startTime); 
            System.out.println("ArrayList laikas per  " + (i + 1)*iteracijos2 + " iteraciju yra " + 
                    arrayListTime + "\n");
        }
        this.printConclusions(dynamicArrayTime, arrayListTime);
    }
    
}
