import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.Scanner;

public class advancemap {
    static void main() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter any statement or sentence !");
//        String sentence = sc.nextLine();
//        Map<String, Integer> frequency = new HashMap<>();
//        String[] words = sentence.split(" ");
//        Iterator<String> it = Arrays.stream(words).iterator();
//        while (it.hasNext()) {
//            String value = it.next();
//            if (frequency.containsKey(value)) {
//                frequency.put(value, frequency.get(value)+1);
//            } else {
//                frequency.put(value, 1);
//            }
//        }
//        System.out.println("the frequency of every word in sentence is :" + frequency);
//
//        //create the map with userid and  their username :
//        Map<String, Integer> userinfo = new HashMap<>();
//        for (int i = 1; i <= 3; i++) {
//            System.out.println("enter the information of " + i + "th student!");
//
//            System.out.println("enter the user name :");
//            String name = sc.next();
//            System.out.println("enter the userid of user:");
//            int id = sc.nextInt();
//
//            userinfo.put(name, id);
//        }
//        System.out.println("enter the user name that you wanted to find :");
//        String found = sc.next();
//        boolean foundresult = false;
//        Iterator<String> itname = userinfo.keySet().iterator();
//        while (itname.hasNext()) {
//            String valuename = itname.next();
//            if (userinfo.containsKey(found)) {
//                System.out.println("we found the user and their user id is :" + userinfo.get(found));
//                foundresult = true;
//                break;
//            }
//        }
//        if (!foundresult) {
//            System.out.println("the user name not found in map!");
//        }

//        //track the students with their grouping :
//        Map<String, List<String>> group = new HashMap<>();
//        for (int i = 1; i <= 3; i++) {
//            System.out.println("enter the info of group " + i + "th person:");
//            System.out.println("enter the group of students:");
//            String Group = sc.next();
//            System.out.println("enter the students that w'll going to include in that group!");
//            List<String> students = new ArrayList<>();
//            for (int j = 1; j <= 3; j++) {
//                System.out.println("enter the student name !");
//                students.add(sc.next());
//            }
//
//            group.put(Group, students);
//        }
//        System.out.println("the group of students is:"+group);

        //hear we are making array and checking the frequency of no :
        String[] users={
                "aryan","atharve","rohan","darshan","aryan"
        };
        Map<String,Integer> countuser=new HashMap<>();
        Iterator<String> ituser= Arrays.stream(users).iterator();
        while(ituser.hasNext())
        {
            String user= ituser.next();
                countuser.put(user, countuser.getOrDefault(user,0)+1);
        }
        System.out.println("the frequency of user logedin:");
        for (Map.Entry<String,Integer> entry: countuser.entrySet())
        {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

    }
}

