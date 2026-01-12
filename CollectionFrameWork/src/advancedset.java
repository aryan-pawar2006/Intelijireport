import java.util.*;
import java.util.Scanner;

public class advancedset {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //create the set of roles in company and print the uique ones :
        List<String> roles=new ArrayList<>();
        for (int i=1;i<=4;i++)
        {
            System.out.println("enter the role of "+i+"th employ");
            roles.add(sc.nextLine());
        }
        Set<String> rolesset=new HashSet<>();
        rolesset.addAll(roles);
        System.out.println("the unique value of roles is :"+rolesset);

    }
}
