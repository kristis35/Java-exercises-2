
package Kristijonas_Projektas;

import Kristijonas_Projektas.DynamicArray;
import Kristijonas_Projektas.Darbininkas;
import java.util.Collection;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mantas.damijonaitis
 */
public class DynamicArrayTest {
    
    public DynamicArrayTest() {
        this.testAdd_GenericType();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd_GenericType() {
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        int initialNullAmount = studentArray.amountOfNulls();
        Darbininkas initialStudent = new Darbininkas("Bla", "Bla", "Bla", "Bla", "Bla");
        studentArray.add(initialStudent);
        int nullAmountAfterStudentInsertion = studentArray.amountOfNulls();
        boolean firstStudentInserted = studentArray.contains(initialStudent);
        for (int i = 0; i < 7; i++){
            Darbininkas student = new Darbininkas(i+"",i+"",i+"",i+"",i+"");
            studentArray.add(student);
        }
        boolean allElementsInserted = true;
        for (int i = 0; i < 7; i++){
            Darbininkas studentFromArray = studentArray.get(i + 1);
            Darbininkas student = new Darbininkas(i+"",i+"",i+"",i+"",i+"");
            allElementsInserted = student.compareTo(studentFromArray) == 0;
        }
        int nullAmountAfterListInsertion = studentArray.amountOfNulls();
        Assert.assertEquals(10, initialNullAmount);
        Assert.assertEquals(9, nullAmountAfterStudentInsertion);
        Assert.assertTrue(firstStudentInserted);
        Assert.assertEquals(2, nullAmountAfterListInsertion);
        Assert.assertTrue(allElementsInserted);
    }

    @Test
    public void testAdd_int_GenericType() {
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        Darbininkas firstStudent = new Darbininkas("first","first","first","first","first");
        Darbininkas secondStudent = new Darbininkas("second","second","second","second","second");
        Darbininkas thirdStudent = new Darbininkas("third","third","third","third","third");
        
        studentArray.add(firstStudent);
        studentArray.add(secondStudent);
        studentArray.add(0, thirdStudent);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        
        Assert.assertTrue(studentArray.get(0).compareTo(thirdStudent) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(firstStudent) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(secondStudent) == 0);
        
    }

    @Test
    public void testAddAll_Collection() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        DynamicArray<Darbininkas> secondArray = new DynamicArray<>();
        secondArray.add(fourth);
        secondArray.add(fifth);
        secondArray.add(sixth);
        
        studentArray.addAll(secondArray);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        Assert.assertNotNull(studentArray.get(3));
        Assert.assertNotNull(studentArray.get(4));
        Assert.assertNotNull(studentArray.get(5));
        
        Assert.assertTrue(studentArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(third) == 0);
        Assert.assertTrue(studentArray.get(3).compareTo(fourth) == 0);
        Assert.assertTrue(studentArray.get(4).compareTo(fifth) == 0);
        Assert.assertTrue(studentArray.get(5).compareTo(sixth) == 0);
        
    }

    @Test
    public void testAddAll_int_Collection() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        DynamicArray<Darbininkas> secondArray = new DynamicArray<>();
        secondArray.add(fourth);
        secondArray.add(fifth);
        secondArray.add(sixth);
        
        studentArray.addAll(0, secondArray);
        
        Assert.assertNotNull(studentArray.get(0));
        Assert.assertNotNull(studentArray.get(1));
        Assert.assertNotNull(studentArray.get(2));
        Assert.assertNotNull(studentArray.get(3));
        Assert.assertNotNull(studentArray.get(4));
        Assert.assertNotNull(studentArray.get(5));
        
        Assert.assertTrue(studentArray.get(0).compareTo(fourth) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(fifth) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(sixth) == 0);
        Assert.assertTrue(studentArray.get(3).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(4).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(5).compareTo(third) == 0);
        
    }

    @Test
    public void testClear() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        studentArray.clear();
        Assert.assertEquals(0, studentArray.size());
        Assert.assertEquals(10, studentArray.amountOfNulls());
    }

    @Test
    public void testContains() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertTrue(studentArray.contains(first));
        Assert.assertTrue(studentArray.contains(second));
        Assert.assertTrue(studentArray.contains(third));
        Assert.assertFalse(studentArray.contains(fourth));
    }

    @Test
    public void testEnsureCapacity() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        int nullAmount = studentArray.amountOfNulls();
        
        Assert.assertEquals(nullAmount, 7);
        
        studentArray.ensureCapacity(100);
        
        int nullAmountAfterEnsurance = studentArray.amountOfNulls();
        
        Assert.assertEquals(97, nullAmountAfterEnsurance);
        
    }

    @Test
    public void testGet() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertTrue(studentArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(studentArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(studentArray.get(2).compareTo(third) == 0);
        
    }

    @Test
    public void testIndexOf() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Assert.assertEquals(0, studentArray.indexOf(first));
        Assert.assertEquals(1, studentArray.indexOf(second));
        Assert.assertEquals(2, studentArray.indexOf(third));
        
    }

    @Test
    public void testIsEmpty() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        Assert.assertTrue(studentArray.isEmpty());
        studentArray.add(first);
        Assert.assertFalse(studentArray.isEmpty());
        studentArray.remove(first);
        Assert.assertTrue(studentArray.isEmpty());
    }

    @Test
    public void testIterator() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> studentArray = new DynamicArray<>();
        studentArray.add(first);
        studentArray.add(second);
        studentArray.add(third);
        
        Iterator<Darbininkas> studentArrayIterator = studentArray.iterator();
        
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(first) == 0);
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(second) == 0);
        Assert.assertTrue(studentArrayIterator.hasNext());
        Assert.assertTrue(studentArrayIterator.next().compareTo(third) == 0);
        Assert.assertFalse(studentArrayIterator.hasNext());
    }

    @Test
    public void testLastIndexOf() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas sameAsSecond = new Darbininkas("2","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(sameAsSecond);
        dynamicArray.add(fifth);
        
        Assert.assertEquals(3, dynamicArray.lastIndexOf(second));
        Assert.assertEquals(3, dynamicArray.lastIndexOf(sameAsSecond));
        Assert.assertEquals(4, dynamicArray.lastIndexOf(fifth));
        
    }

    @Test
    public void testRemove_int() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        Darbininkas seventh = new Darbininkas("7","1","1","1","1");
        Darbininkas eighth = new Darbininkas("8","1","1","1","1");
        Darbininkas ninth = new Darbininkas("9","1","1","1","1");
        Darbininkas tenth = new Darbininkas("10","1","1","1","1");
        Darbininkas eleventh = new Darbininkas("11","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        dynamicArray.add(seventh);
        dynamicArray.add(eighth);
        dynamicArray.add(ninth);
        dynamicArray.add(tenth);
        dynamicArray.add(eleventh);
        Assert.assertEquals(9, dynamicArray.amountOfNulls());
        
        dynamicArray.remove(0);
        Assert.assertEquals(9, dynamicArray.amountOfNulls());
        dynamicArray.remove(0);
        Assert.assertEquals(0, dynamicArray.amountOfNulls());
        
        
    }

    @Test
    public void testRemove_Object() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        
        Assert.assertTrue(dynamicArray.contains(first));
        dynamicArray.remove(first);
        Assert.assertFalse(dynamicArray.contains(first));
        
        Assert.assertTrue(dynamicArray.contains(second));
        dynamicArray.remove(second);
        Assert.assertFalse(dynamicArray.contains(second));
        
        Assert.assertTrue(dynamicArray.contains(third));
        dynamicArray.remove(third);
        Assert.assertFalse(dynamicArray.contains(third));
        
        Assert.assertTrue(dynamicArray.isEmpty());
        
    }

    @Test
    public void testRemoveAll() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        DynamicArray<Darbininkas> dynamicArrayToRemove = new DynamicArray<>();
        dynamicArrayToRemove.add(fourth);
        dynamicArrayToRemove.add(fifth);
        dynamicArrayToRemove.add(sixth);
        
        Assert.assertTrue(dynamicArray.contains(fourth));
        Assert.assertTrue(dynamicArray.contains(fifth));
        Assert.assertTrue(dynamicArray.contains(sixth));
        
        dynamicArray.removeAll(dynamicArrayToRemove);
        
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertFalse(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testRemoveRange() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        dynamicArray.removeRange(2, 4);
        
        Assert.assertTrue(dynamicArray.contains(first));
        Assert.assertTrue(dynamicArray.contains(second));
        Assert.assertFalse(dynamicArray.contains(third));
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertTrue(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testRetainAll() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        DynamicArray<Darbininkas> arrayToRetain = new DynamicArray<>();
        arrayToRetain.add(first);
        arrayToRetain.add(second);
        arrayToRetain.add(third);
        
        dynamicArray.retainAll(arrayToRetain);
        
        Assert.assertTrue(dynamicArray.contains(first));
        Assert.assertTrue(dynamicArray.contains(second));
        Assert.assertTrue(dynamicArray.contains(third));
        Assert.assertFalse(dynamicArray.contains(fourth));
        Assert.assertFalse(dynamicArray.contains(fifth));
        Assert.assertFalse(dynamicArray.contains(sixth));
        
    }

    @Test
    public void testSet() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        
        Assert.assertTrue(dynamicArray.get(0).compareTo(first) == 0);
        Assert.assertTrue(dynamicArray.get(1).compareTo(second) == 0);
        Assert.assertTrue(dynamicArray.get(2).compareTo(third) == 0);
        
        dynamicArray.set(0, third);
        dynamicArray.set(1, first);
        dynamicArray.set(2, second);
        
        Assert.assertTrue(dynamicArray.get(0).compareTo(third) == 0);
        Assert.assertTrue(dynamicArray.get(1).compareTo(first) == 0);
        Assert.assertTrue(dynamicArray.get(2).compareTo(second) == 0);
        
    }

    @Test
    public void testSize() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        Assert.assertEquals(0, dynamicArray.size());
        dynamicArray.add(first);
        Assert.assertEquals(1, dynamicArray.size());
        dynamicArray.add(second);
        Assert.assertEquals(2, dynamicArray.size());
        dynamicArray.add(third);
        Assert.assertEquals(3, dynamicArray.size());
    }

    @Test
    public void testToArray_0args() {
    }

    @Test
    public void testTrimToSize() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        dynamicArray.add(fifth);
        dynamicArray.add(sixth);
        
        Assert.assertEquals(4, dynamicArray.amountOfNulls());
        
        dynamicArray.trimToSize();
        
        Assert.assertEquals(0, dynamicArray.amountOfNulls());
        
    }

    @Test
    public void testContainsAll() {
        Darbininkas first = new Darbininkas("1","1","1","1","1");
        Darbininkas second = new Darbininkas("2","1","1","1","1");
        Darbininkas third = new Darbininkas("3","1","1","1","1");
        Darbininkas fourth = new Darbininkas("4","1","1","1","1");
        Darbininkas fifth = new Darbininkas("5","1","1","1","1");
        Darbininkas sixth = new Darbininkas("6","1","1","1","1");
        
        DynamicArray<Darbininkas> dynamicArray = new DynamicArray<>();
        dynamicArray.add(first);
        dynamicArray.add(second);
        dynamicArray.add(third);
        dynamicArray.add(fourth);
        
        DynamicArray<Darbininkas> dynamicArrayToCompare = new DynamicArray<>();
        dynamicArrayToCompare.add(first);
        dynamicArrayToCompare.add(second);
        
        Assert.assertTrue(dynamicArray.containsAll(dynamicArrayToCompare));
        
        dynamicArrayToCompare.add(fifth);
        
        Assert.assertFalse(dynamicArray.contains(dynamicArrayToCompare));
        
    }
    
}
