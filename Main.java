import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating new days with DayofYear constructor!\n");
        ArrayList<DayofYearSet.DayofYear> set= new ArrayList<DayofYearSet.DayofYear>(12);
        System.out.println("Testing add functions");
        DayofYearSet.DayofYear day= new DayofYearSet.DayofYear(2,3);
        set.add(day);
        day= new DayofYearSet.DayofYear(4,2);
        set.add(day);
        day= new DayofYearSet.DayofYear(2,9);
        set.add(day);
        day= new DayofYearSet.DayofYear(1,1);
        set.add(day);
        day= new DayofYearSet.DayofYear(9,1);
        set.add(day);
        day= new DayofYearSet.DayofYear(9,11);
        set.add(day);
        day= new DayofYearSet.DayofYear(5,3);
        set.add(day);
        day= new DayofYearSet.DayofYear(6,3);
        set.add(day);
        day= new DayofYearSet.DayofYear(1,3);
        set.add(day);
        System.out.println("Set is filled in the main \n");
        System.out.println("Now new dayofyearSet object is created with size 10 \n");
        DayofYearSet dayofyear= new DayofYearSet(set,9);
        System.out.println("Tested the constructor of DayofyearSet \n");
        ArrayList<DayofYearSet.DayofYear> set1= new ArrayList<DayofYearSet.DayofYear>(12);
        dayofyear.order();
        day= new DayofYearSet.DayofYear(2,3);
        set1.add(day);
        day= new DayofYearSet.DayofYear(4,2);
        set1.add(day);
        day= new DayofYearSet.DayofYear(2,9);
        set1.add(day);
        day= new DayofYearSet.DayofYear(1,1);
        set1.add(day);
        day= new DayofYearSet.DayofYear(9,1);
        set1.add(day);
        day= new DayofYearSet.DayofYear(9,11);
        set1.add(day);
        day= new DayofYearSet.DayofYear(5,4);
        set1.add(day);
        day= new DayofYearSet.DayofYear(6,1);
        set1.add(day);
        day= new DayofYearSet.DayofYear(1,3);
        set1.add(day);
        DayofYearSet dayofyear1= new DayofYearSet(set1,9);
        System.out.println("Testing order functions: \n");
        dayofyear.order();
        dayofyear1.order();
        System.out.println("After order, Dayofyear1 objects");
        for(int i=0;i<9;i++){
            System.out.println(dayofyear1.getSet()[i]);
        }
        System.out.println("After order, Dayofyear objects");
        for(int i=0;i<9;i++){
            System.out.println(dayofyear1.getSet()[i]);
        }
        System.out.println("Testing size function!");
        System.out.println("Size of dayofyear is");
        System.out.println(dayofyear.size());
        System.out.println("Size of dayofyear1 is");
        System.out.println(dayofyear1.size());
        System.out.println("Testing union function");
        ArrayList<DayofYearSet.DayofYear> union_Set= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size()+dayofyear.size());
        union_Set= dayofyear.union(dayofyear1);
        for(int i=0;i<union_Set.size();i++){
            System.out.println(union_Set.get(i));
        }
        DayofYearSet temp_day2= new DayofYearSet(union_Set,union_Set.size());
        ArrayList<DayofYearSet.DayofYear> complement_set= new ArrayList<DayofYearSet.DayofYear>(dayofyear.size());
        ArrayList<DayofYearSet.DayofYear> complement_set1= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size());
        ArrayList<DayofYearSet.DayofYear> complement_set2= new ArrayList<DayofYearSet.DayofYear>(365-union_Set.size());

        DayofYearSet temp_day= new DayofYearSet(dayofyear.complement(),dayofyear.complement().size());
        System.out.println("Testing complement method for dayofyear");
        for(int i=0;i<temp_day.size();i++)
            System.out.println(temp_day.getSet()[i]);
        DayofYearSet temp_day1= new DayofYearSet(dayofyear1.complement(),dayofyear1.complement().size());
        System.out.println("Testing complement method for dayofyear1");
        for(int i=0;i<temp_day1.size();i++)
            System.out.println(temp_day1.getSet()[i]);
        System.out.println("Intersection of dayofyear and dayofyear1 object: \n");
        for(int i=0;i<temp_day.intersection(temp_day1).size();i++){
            System.out.println(temp_day.intersection(temp_day1).get(i));
        }
        System.out.println("Testing equals function:");
        if(dayofyear.equals(dayofyear1)){
            System.out.println("Sets are same!");
        }
        else{
            System.out.println("Sets are not same");
        }
        if(temp_day2.complement().size()==temp_day.intersection(temp_day1).size()){
            System.out.println("De Morgan Test 1 is passed!");
        }
        System.out.println(temp_day.size());
        System.out.println("Writing to file!");
        dayofyear.writeFile();
        /********************************/

        System.out.println("Creating new days with DayofYear constructor!\n");
        ArrayList<DayofYearSet.DayofYear> set2= new ArrayList<DayofYearSet.DayofYear>(3);
        System.out.println("Testing add functions");
        day= new DayofYearSet.DayofYear(1,3);
        set2.add(day);
        day= new DayofYearSet.DayofYear(4,2);
        set2.add(day);
        System.out.println("Set is filled in the main \n");
        System.out.println("Now new dayofyearSet object is created with size 2 \n");
        DayofYearSet dayofyear2= new DayofYearSet(set2,2);
        System.out.println("Tested the constructor of DayofyearSet \n");
        ArrayList<DayofYearSet.DayofYear> set3= new ArrayList<DayofYearSet.DayofYear>(3);
        dayofyear2.order();
        day= new DayofYearSet.DayofYear(6,7);
        set3.add(day);
        day= new DayofYearSet.DayofYear(9,10);
        set3.add(day);

        DayofYearSet dayofyear3= new DayofYearSet(set3,2);
        System.out.println("Testing order functions: \n");
        dayofyear2.order();
        dayofyear3.order();
        System.out.println("After order, Dayofyear2 objects");
        for(int i=0;i<2;i++){
            System.out.println(dayofyear2.getSet()[i]);
        }
        System.out.println("After order, Dayofyear3 objects");
        for(int i=0;i<2;i++){
            System.out.println(dayofyear3.getSet()[i]);
        }
        System.out.println("Testing size function!");
        System.out.println("Size of dayofyear2 is");
        System.out.println(dayofyear2.size());
        System.out.println("Size of dayofyear3 is");
        System.out.println(dayofyear3.size());
        System.out.println("Testing union function");
        ArrayList<DayofYearSet.DayofYear> union_Set2= new ArrayList<DayofYearSet.DayofYear>(dayofyear2.size()+dayofyear3.size());
        union_Set2= dayofyear2.union(dayofyear3);
        for(int i=0;i<union_Set2.size();i++){
            System.out.println(union_Set2.get(i));
        }
        DayofYearSet temp_day6= new DayofYearSet(union_Set2,union_Set2.size());
        ArrayList<DayofYearSet.DayofYear> complement_set3= new ArrayList<DayofYearSet.DayofYear>(dayofyear2.size());
        ArrayList<DayofYearSet.DayofYear> complement_set4= new ArrayList<DayofYearSet.DayofYear>(dayofyear3.size());
        ArrayList<DayofYearSet.DayofYear> complement_set5= new ArrayList<DayofYearSet.DayofYear>(365-union_Set2.size());

        DayofYearSet temp_day4= new DayofYearSet(dayofyear2.complement(),dayofyear2.complement().size());
        System.out.println("Testing complement method for dayofyear");
        for(int i=0;i<temp_day4.size();i++)
            System.out.println(temp_day4.getSet()[i]);
        DayofYearSet temp_day5= new DayofYearSet(dayofyear1.complement(),dayofyear1.complement().size());
        System.out.println("Testing complement method for dayofyear1");
        for(int i=0;i<temp_day5.size();i++)
            System.out.println(temp_day5.getSet()[i]);
        System.out.println("Intersection of dayofyear and dayofyear1 object: \n");
        for(int i=0;i<temp_day4.intersection(temp_day5).size();i++){
            System.out.println(temp_day4.intersection(temp_day5).get(i));
        }
        System.out.println("Testing equals function:");
        if(dayofyear2.equals(dayofyear3)){
            System.out.println("Sets are same!");
        }
        else{
            System.out.println("Sets are not same");
        }
        if(temp_day6.complement().size()==temp_day4.intersection(temp_day5).size()){
            System.out.println("De Morgan Test 2 is passed!");
        }
        /*************************************************/
        set= new ArrayList<DayofYearSet.DayofYear>(2);
        day= new DayofYearSet.DayofYear(4,6);
        set.add(day);
        dayofyear= new DayofYearSet(set,1);
        set1= new ArrayList<DayofYearSet.DayofYear>(2);
        dayofyear.order();
        day= new DayofYearSet.DayofYear(8,9);
        set1.add(day);
        dayofyear1= new DayofYearSet(set1,1);
        dayofyear.order();
        dayofyear1.order();

        union_Set= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size()+dayofyear.size());
        union_Set= dayofyear.union(dayofyear1);
        temp_day2= new DayofYearSet(union_Set,union_Set.size());
        complement_set= new ArrayList<DayofYearSet.DayofYear>(dayofyear.size());
        complement_set1= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size());
        complement_set2= new ArrayList<DayofYearSet.DayofYear>(365-union_Set.size());
        temp_day= new DayofYearSet(dayofyear.complement(),dayofyear.complement().size());
        temp_day1= new DayofYearSet(dayofyear1.complement(),dayofyear1.complement().size());
        System.out.println("Left side of the equality in de morgan: ");
        System.out.println(temp_day2.complement());
        System.out.println("Right side of the equality in de morgan: ");
        System.out.println(temp_day.intersection(temp_day1));
        if(temp_day2.complement().size()==temp_day.intersection(temp_day1).size()){
            System.out.println("De Morgan Test 3 is passed!");
        }
        /**************************************************************/
        set= new ArrayList<DayofYearSet.DayofYear>(2);
        day= new DayofYearSet.DayofYear(4,6);
        set.add(day);
        day= new DayofYearSet.DayofYear(7,8);
        set.add(day);
        dayofyear= new DayofYearSet(set,2);
        set1= new ArrayList<DayofYearSet.DayofYear>(2);
        dayofyear.order();
        day= new DayofYearSet.DayofYear(8,9);
        set1.add(day);
        day= new DayofYearSet.DayofYear(1,3);
        set1.add(day);
        dayofyear1= new DayofYearSet(set1,2);
        dayofyear.order();
        dayofyear1.order();
        union_Set= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size()+dayofyear.size());
        union_Set= dayofyear.union(dayofyear1);
        temp_day2= new DayofYearSet(union_Set,union_Set.size());
        complement_set= new ArrayList<DayofYearSet.DayofYear>(dayofyear.size());
        complement_set1= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size());
        complement_set2= new ArrayList<DayofYearSet.DayofYear>(365-union_Set.size());
        temp_day= new DayofYearSet(dayofyear.complement(),dayofyear.complement().size());
        temp_day1= new DayofYearSet(dayofyear1.complement(),dayofyear1.complement().size());
        System.out.println("Left side of the equality in de morgan: ");
        System.out.println(temp_day2.complement());
        System.out.println("Right side of the equality in de morgan: ");
        System.out.println(temp_day.intersection(temp_day1));
        if(temp_day2.complement().size()==temp_day.intersection(temp_day1).size()){
            System.out.println("De Morgan Test 4 is passed!");
        }
        /*******************************************************/
        set= new ArrayList<DayofYearSet.DayofYear>(4);
        day= new DayofYearSet.DayofYear(4,6);
        set.add(day);
        day= new DayofYearSet.DayofYear(7,8);
        set.add(day);
        day= new DayofYearSet.DayofYear(1,8);
        set.add(day);
        day= new DayofYearSet.DayofYear(4,10);
        set.add(day);
        dayofyear= new DayofYearSet(set,4);
        set1= new ArrayList<DayofYearSet.DayofYear>(4);
        dayofyear.order();
        day= new DayofYearSet.DayofYear(8,9);
        set1.add(day);
        day= new DayofYearSet.DayofYear(1,3);
        set1.add(day);
        day= new DayofYearSet.DayofYear(4,3);
        set1.add(day);
        day= new DayofYearSet.DayofYear(11,3);
        set1.add(day);
        dayofyear1= new DayofYearSet(set1,4);
        dayofyear.order();
        dayofyear1.order();
        union_Set= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size()+dayofyear.size());
        union_Set= dayofyear.union(dayofyear1);
        temp_day2= new DayofYearSet(union_Set,union_Set.size());
        complement_set= new ArrayList<DayofYearSet.DayofYear>(dayofyear.size());
        complement_set1= new ArrayList<DayofYearSet.DayofYear>(dayofyear1.size());
        complement_set2= new ArrayList<DayofYearSet.DayofYear>(365-union_Set.size());
        temp_day= new DayofYearSet(dayofyear.complement(),dayofyear.complement().size());
        temp_day1= new DayofYearSet(dayofyear1.complement(),dayofyear1.complement().size());
        System.out.println("Left side of the equality in de morgan: ");
        System.out.println(temp_day2.complement());
        System.out.println("Right side of the equality in de morgan: ");
        System.out.println(temp_day.intersection(temp_day1));
        if(temp_day2.complement().size()==temp_day.intersection(temp_day1).size()){
            System.out.println("De Morgan Test 5 is passed!");
        }

    }
}
