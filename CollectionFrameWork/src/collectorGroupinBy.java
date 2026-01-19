import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class collectorGroupinBy {
    static class students{//we created class hear to store the student data .
        String name;
        String city;

        students(String name,String city)//hear we are ussing constructor to assign the values :
        {
            this.name=name;
            this.city=city;
        }
    }
    //create the class of employ:
    static class employ{
        String name;
        int salary;
        String department;

        employ(String name1,Integer salary,String department)
        {
            this.name=name1;
            this.salary=salary;
            this.department=department;

        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        //create the list and with the help of groupinby create the group of even and odd no:
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=4;i++){
            System.out.println("enter the "+i+"th number of list:");
            numbers.add(sc.nextInt());
        }
        Map<String,List<Integer>>result=numbers.stream()
                .collect(Collectors.groupingBy(
                        n-> n%2==0?"Even":"Odd"//hear we are checking each
                ));

        System.out.println("now with the help of groupinby even and odd nos:"+result);

        //create the list and group it as per their lenght :
        List<String> cities=new ArrayList<>();
        for(int i=1;i<=4;i++){
            System.out.println("enter the "+i+"th city name:");
            cities.add(sc.next());
        }
        Map<Integer,List<String>> resultstring=cities.stream()
                .collect(Collectors.groupingBy(
                        n-> n.length()
                ));

        System.out.println("the grouping on the basis of lenght of string:"+resultstring);

        //create the stream problem to group students from city and count them:
       List<students> students1=new ArrayList<>();
       students1.add(new students("aryan","karad"));
        students1.add(new students("atharv","karad"));
        students1.add(new students("darshan","thane"));
        students1.add(new students("vedant","banwadi"));

        Map<String,Long> citiescount=students1.stream()
                .collect(Collectors.groupingBy(
                        city-> city.city,
                        Collectors.counting()
                ));

        System.out.println("the counting of cities are :"+citiescount);

        //group the employes of department  with their salary:
        List<employ> datalist=new ArrayList<>();
        datalist.add(new employ("aryan",25000,"cse"));
        datalist.add(new employ("pranav",30000,"cse"));
        datalist.add(new employ("darshan",40000,"entc"));
        datalist.add(new employ("atharve",100000,"machenical"));

        Map<String,Long> result2=datalist.stream()
                .collect(Collectors.groupingBy(
                        m->m.department,
                        Collectors.summingLong(n->n.salary)
                ));

        System.out.println("data of grouped employes!"+result2);

    //create the group of first character of ele list and then with the help of group in by interface stores the longest string as value:
    List<String> list1=List.of(
            "aryan","pawar","atharve","manisha"
    );
    Map<Character, String> result3=list1.stream()
            .collect(Collectors.groupingBy(
                    charr->charr.charAt(0),
                    Collectors.collectingAndThen(
                    Collectors.maxBy(
                            Comparator.comparing(String::length)//hear we are comparing lenght of list of group of perticular character:
                    ),
                    Optional::get
                    )
            ));

    System.out.println("result of map with the grouping :"+result3);

    //with the help of partitioning partition the numbers in list in true and false  group:
        List<Integer> marks=new ArrayList<>();
        for (int i=1;i<=4;i++)
        {
            System.out.println("enter the marks of "+i+"th student!");
            marks.add(sc.nextInt());
        }
        Map<Boolean,List<Integer>> partitionn=marks.stream()//partitioning only store key value in booolean formate:
                .collect(Collectors.partitioningBy(
                        n-> n%2==0
                ));
        System.out.println("the partioned result is:"+partitionn);
}
}

