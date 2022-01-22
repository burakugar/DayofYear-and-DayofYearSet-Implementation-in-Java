import java.io.*;
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
/**
 * DayofYearSet class: Holds DayofYear objects in an array
 * size is the number of elements in the array
 * objects is the static int that counts the total number of DayofYear objects alive
 */
public class DayofYearSet {
    private DayofYear set[];
    private int size;
    private static int objects = 0;

    public DayofYear[] getSet() {
        return set;
    }

    public void setSet(DayofYear[] set) {
        this.set = set;
    }

    /**
     * This overridden equals method returns true if the given object's day and month's are the same
     * @param obj is the Object class(Classic Base class of every class)
     * @return true if day and month's are the same
     */

    public boolean equals(DayofYearSet obj) {
        int k = 0;
        if (obj.size() != size) return false;
        else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (compare(this.set[i], obj.set[j])) {
                        k++;
                        break;
                    }
                }
            }
            if (k == size) {
                return true;
            } else return false;
        }
    }
    /**
     * This method orders the sets in the DayofYearset class in terms of month and date order
     */
    public void order() {
        int n = size;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (set[j].getMonth() > set[j + 1].getMonth()) {
                    // swap arr[j+1] and arr[j]
                    int temp_month = set[j].getMonth();
                    int temp_date = set[j].getDay();
                    set[j].setMonth(set[j + 1].getMonth());
                    set[j].setDay(set[j + 1].getDay());
                    set[j + 1].setMonth(temp_month);
                    set[j + 1].setDay(temp_date);
                }
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (set[j].getMonth() == set[j + 1].getMonth()) {
                    if (set[j].getDay() > set[j + 1].getDay()) {
                        // swap arr[j+1] and arr[j]
                        int temp_date = set[j].getDay();
                        ;
                        set[j].setDay(set[j + 1].getDay());
                        set[j + 1].setDay(temp_date);
                    }
                }
    }
    /**
     * This overridden equals method returns true if the given object's day and month's are the same
     * @param list is the Dayofyear Arraylist
     * @param day is one of the days
     * @return true if the list includes the given day
     */

    public boolean doesInclude( ArrayList<DayofYear> list,DayofYear day){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMonth()==day.getMonth() && list.get(i).getDay()==day.getDay()){
                return true;
            }
        }
        return false;
    }
    /**
     * This class creates an arraylist to store union set elements
     * Combines two DayofYearSet object's sets
     * @param obj is the one DayofYearSet object
     * @return Arraylist of DayofYear objects
     */
    public ArrayList<DayofYear> union(DayofYearSet obj) {
        obj.order();
        this.order();
        ArrayList<DayofYear> list = new ArrayList<DayofYear>();
        for (int i = 0; i < obj.size; i++) {
            for (int j = 0; j < size; j++) {
                if (!compare(set[j], obj.set[i])) {
                    list.add(obj.set[i]);
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj.size; j++) {
                if (compare(set[i], obj.set[j])== false && !doesInclude(list,set[i])) {
                    list.add(set[i]);
                    break;
                }
            }
        }
        return list;
    }
    /**
     * This class creates an arraylist to store difference of the set elements
     * Takes the difference of two DayofYearSet object's sets
     * @param obj is the one DayofYearSet object
     * @return Arraylist of DayofYear objects
     */
    public ArrayList<DayofYear> difference(DayofYearSet obj) {
        obj.order();
        this.order();
        int flag = 0;
        ArrayList<DayofYear> list = new ArrayList<DayofYear>();
        for (int i = 0; i < obj.size; i++) {
            for (int j = 0; j < size; j++) {
                if (compare(set[j], obj.set[i])) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                list.add(obj.set[i]);
            }
            flag = 0;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < obj.size; j++) {
                if (compare(set[i], obj.set[j])) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                list.add(set[i]);
            }
            flag = 0;
        }
        return list;
    }
    /**
     * This is the getter function for objects static int
     * @return the number of DayofYear elements alive
     */
    public static int getObjects() {
        return objects;
    }
    /**
     * This is the setter function for objects static int
     */
    public static void setObjects(int objects) {
        DayofYearSet.objects = objects;
    }
    /**
     * This function creates an arraylist to store complement of two set elements
     * Then it constructs a new Dayofyear ArrayList by giving this arraylist as input parameter
     * @return the complement arrayList
     */
    public ArrayList<DayofYear> complement()
        { ArrayList<DayofYear> int_Array1 = new ArrayList<DayofYear>(31);
            for (int i = 1; i < 32; i++) {
                DayofYear day = new DayofYear(i, 1);
                int_Array1.add(day);
            }
            ;
        ArrayList<DayofYear> int_Array2 = new ArrayList<DayofYear>(29);
        for (int i = 1; i < 30; i++) {
            DayofYear day = new DayofYear(i, 2);
            int_Array2.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array3 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 3);
            int_Array3.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array4 = new ArrayList<DayofYear>(30);
        for (int i = 1; i < 31; i++) {
            DayofYear day = new DayofYear(i, 4);
            int_Array4.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array5 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 5);
            int_Array5.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array7 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 7);
            int_Array7.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array8 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 8);
            int_Array8.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array6 = new ArrayList<DayofYear>(30);
        for (int i = 1; i < 31; i++) {
            DayofYear day = new DayofYear(i, 6);
            int_Array6.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array9 = new ArrayList<DayofYear>(30);
        for (int i = 1; i < 31; i++) {
            DayofYear day = new DayofYear(i, 9);
            int_Array9.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array10 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 10);
            int_Array10.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array11 = new ArrayList<DayofYear>(30);
        for (int i = 1; i < 31; i++) {
            DayofYear day = new DayofYear(i, 11);
            int_Array11.add(day);
        }
        ;
        ArrayList<DayofYear> int_Array12 = new ArrayList<DayofYear>(31);
        for (int i = 1; i < 32; i++) {
            DayofYear day = new DayofYear(i, 12);
            int_Array12.add(day);
        }
        ;
        ArrayList<DayofYear> year_set = new ArrayList<>(365);
        int month1 = 31;
        int month2 = 29;
        int month3 = 31;
        int month4 = 30;
        int month5 = 31;
        int month6 = 30;
        int month7 = 31;
        int month8 = 31;
        int month9 = 30;
        int month10 = 31;
        int month11 = 30;
        int month12 = 31;
        this.order();
        int flag = 0;
        System.out.println(int_Array1.size());
        for (int i = 0; i < size; i++) {
            if (set[i].getMonth() == 1) {
                for (int j = 0; j < int_Array1.size(); j++) {
                    if (set[i].getDay() == int_Array1.get(j).getDay()) {
                        int_Array1.remove(j);
                        month1--;
                    }
                }
            } else if (set[i].getMonth() == 2) {
                for (int j = 0; j < int_Array2.size(); j++) {
                    if (set[i].getDay() == int_Array2.get(j).getDay()) {
                        int_Array2.remove(j);
                        month2--;
                    }
                }
            } else if (set[i].getMonth() == 3) {
                for (int j = 0; j < int_Array3.size(); j++) {
                    if (set[i].getDay() == int_Array3.get(j).getDay()) {
                        int_Array3.remove(j);
                        month3--;
                    }
                }
            } else if (set[i].getMonth() == 4) {
                for (int j = 0; j < int_Array4.size(); j++) {
                    if (set[i].getDay() == int_Array4.get(j).getDay()) {
                        int_Array4.remove(j);
                        month4--;
                    }
                }
            } else if (set[i].getMonth() == 5) {
                for (int j = 0; j < int_Array5.size(); j++) {
                    if (set[i].getDay() == int_Array5.get(j).getDay()) {
                        int_Array5.remove(j);
                        month5--;
                    }
                }
            } else if (set[i].getMonth() == 6) {
                for (int j = 0; j < int_Array6.size(); j++) {
                    if (set[i].getDay() == int_Array6.get(j).getDay()) {
                        int_Array6.remove(j);
                        month6--;
                    }
                }
            } else if (set[i].getMonth() == 7) {
                for (int j = 0; j < int_Array7.size(); j++) {
                    if (set[i].getDay() == int_Array7.get(j).getDay()) {
                        int_Array7.remove(j);
                        month7--;
                    }
                }
            } else if (set[i].getMonth() == 8) {
                for (int j = 0; j < int_Array8.size(); j++) {
                    if (set[i].getDay() == int_Array8.get(j).getDay()) {
                        int_Array8.remove(j);
                        month8--;
                    }
                }
            } else if (set[i].getMonth() == 9) {
                for (int j = 0; j < int_Array9.size(); j++) {
                    if (set[i].getDay() == int_Array9.get(j).getDay()) {
                        int_Array9.remove(j);
                        month9--;
                    }
                }
            } else if (set[i].getMonth() == 10) {
                for (int j = 0; j < int_Array10.size(); j++) {
                    if (set[i].getDay() == int_Array10.get(j).getDay()) {
                        int_Array10.remove(j);
                        month10--;
                    }
                }
            } else if (set[i].getMonth() == 11) {
                for (int j = 0; j < int_Array11.size(); j++) {
                    if (set[i].getDay() == int_Array11.get(j).getDay()) {
                        int_Array11.remove(j);
                        month11--;
                    }
                }
            } else if (set[i].getMonth() == 12) {
                for (int j = 0; j < int_Array12.size(); j++) {
                    if (set[i].getDay() == int_Array12.get(j).getDay()) {
                        int_Array12.remove(j);
                        month12--;
                    }
                }
            }

        }

        int capacity = month1 + month2 + month3 + month4 + month5 + month6 + month7 + month8 + month9 + month10 + month11 + month12;
        ArrayList<DayofYear> list = new ArrayList<DayofYear>(capacity);
        int k = 0;
            System.out.println(month1);
        for (int j = 0; j < month1; j++) {
            list.add(k, int_Array1.get(j));
            k++;
        }
        for (int j = 0; j < month2; j++) {
            list.add(k, int_Array2.get(j));
            k++;
        }
        for (int j = 0; j < month3; j++) {
            list.add(k, int_Array3.get(j));
            k++;
        }
        for (int j = 0; j < month4; j++) {
            list.add(k, int_Array4.get(j));
            k++;
        }
        for (int j = 0; j < month5; j++) {
            list.add(k, int_Array5.get(j));
            k++;
        }
        for (int j = 0; j < month6; j++) {
            list.add(k, int_Array6.get(j));
            k++;
        }
        for (int j = 0; j < month7; j++) {
            list.add(k, int_Array7.get(j));
            k++;
        }
        for (int j = 0; j < month8; j++) {
            list.add(k, int_Array8.get(j));
            k++;
        }
        for (int j = 0; j < month9; j++) {
            list.add(k, int_Array9.get(j));
            k++;
        }
        for (int j = 0; j < month10; j++) {
            list.add(k, int_Array10.get(j));
            k++;
        }
        for (int j = 0; j < month11; j++) {
            list.add(k, int_Array11.get(j));
            k++;
        }
        for (int j = 0; j < month12; j++) {
            list.add(k, int_Array12.get(j));
            k++;
        }

        return list;
    }
    /**
     * This function creates an arraylist to store intersection of two set elements
     * Then it constructs a new Dayofyear ArrayList by giving this arraylist as input parameter
     * @return the intersection arrayList
     */
    public ArrayList<DayofYear> intersection(DayofYearSet obj) {
        obj.order();
        this.order();
        ArrayList<DayofYear> list = new ArrayList<DayofYear>();
        for (int i = 0; i < obj.size; i++) {
            for (int j = 0; j < size; j++) {
                if (compare(set[j], obj.set[i])) {
                    list.add(set[j]);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * No parameter constructor of DayofYearSet. It initializes size=0 and the set
     */
    public DayofYearSet() {
        this.size = 0;
        this.set = new DayofYear[0];
    }
    /**
     * Arraylist constructor of DayofYearSet
     * It initializes the size with given size
     * Then copies all the DayofYear objects in the given arraylist
     * @param set consist of DayofYear objects
     * @param size is the size of the array
     */
    public DayofYearSet(ArrayList<DayofYear> set, int size) {
        this.set = new DayofYear[size];
        for (int i = 0; i < set.size(); i++) {
            this.set[i] = set.get(i);
        }
        objects += size;
        this.size = size;
    }
    /**
     * This function compares two dayofyear objects
     * @param obj is one of the day belongs to Dayofyear class
     * @param obj1 is one of the day belongs to Dayofyear class
     * @return a boolean if two objects are same
     */
    protected boolean compare(DayofYear obj, DayofYear obj1) {
        if (obj.getMonth() == obj1.getMonth() && obj.getDay() == obj1.getDay())
            return true;
        else
            return false;
    }
    /**
     * It first checks whether the given DayofYear object exists or not in the set
     * It adds given DayofYear object to the lastIndex of DayofYear[] array of this class
     * @param obj is the given DayofYear object
     */
    public void add(DayofYear obj) { // adds a new DayofYear object to the set
        for (int i = 0; i < size(); i++) {
            if (compare(obj, set[i]) == true) {
                System.out.println("Element is already in the set!");
                System.exit(1);
            }
        }
        Arrays.copyOf(set, set.length + 1); // creating a new set with size +1
        set[size() + 1] = obj;
        size += 1;
        objects++;
    }
    /**
     * It first checks whether the given DayofYear object exists or not in the set
     * This method removes the given element in the DayofYearSet class
     * @param obj is given DayofYear object
     */
    public void remove(DayofYear obj) { // removes a new DayofYear object to the set
        int flag = 0;
        for (int i = 0; i < size(); i++) {
            if (compare(obj, set[i]) == true) {
                flag = i;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Element is not found in the set!");
            System.exit(1);
        }
        DayofYear[] set_new = new DayofYear[size - 1];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (i != flag) {
                set_new[k] = set[i];
                k++;
            }
        }
        size -= 1;
        objects--;
    }
    /**
     * Returns the size of the array in the DayofYearSet
     * @return size of the array
     */
    public int size() {
        return size;
    }
    /**
     * @return number of alive objects of dayofyear objects
     */
    public int numberofAlive() {
        return objects;
    }

    /**
     * Implements the file I/O operations
     */
    public void writeFile() {
        try {
            FileWriter writer= new FileWriter("deneme.txt");
            writer.write("Elements in the sets are: ");
            for(int i=0;i<size;i++){
                writer.write("Date: " + set[i].getDay()+ "Month: " + set[i].getMonth() + "\n");
            }
            System.out.println("Successfully wrote to the file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * DayofYear inner class
     */
    static public class DayofYear {
        private int day;
        private int month;
        /**
         * That constructor initializes DayofYear class with given day and month
         * If the day and month is invalid, it terminates the program
         * @param day is day
         * @param month is month
         */
        public DayofYear(int day, int month) {
            if (month == 1 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 2 && day > 0 && day <= 29) {
                this.day = day;
                this.month = month;
            } else if (month == 3 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 4 && day > 0 && day <= 30) {
                this.day = day;
                this.month = month;
            } else if (month == 5 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 6 && day > 0 && day <= 30) {
                this.day = day;
                this.month = month;
            } else if (month == 7 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 8 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 9 && day > 0 && day <= 30) {
                this.day = day;
                this.month = month;
            } else if (month == 10 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else if (month == 11 && day > 0 && day <= 30) {
                this.day = day;
                this.month = month;

            } else if (month == 12 && day > 0 && day <= 31) {
                this.day = day;
                this.month = month;
            } else {
                System.out.println("Entered date is invalid, terminating! ");
                System.exit(1);
            }
        }

        /**
         * Getter for day in dayofyear object
         * @return the day of the dayofyear object
         */
        public int getDay() {
            return day;
        }
        /**
         * Setter for day in dayofyear object
         */
        public void setDay(int day) {
            this.day = day;
        }
        /**
         * Getter for month in dayofyear object
         * @return the month of the dayofyear object
         */
        public int getMonth() {
            return month;
        }
        /**
         * Setter for month in dayofyear object
         */
        public void setMonth(int month) {
            this.month = month;
        }
        /**
         * This overridden method creates the properties of the class and returns them as a String object
         * @return string value of DayofYear class
         */
        @Override
        public String toString() {
            return "month: " + month + " " + "date: " + day;
        }
    }
}

