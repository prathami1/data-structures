import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class fedCensus 
{
    public static void main(String[] args) 
    {
        ArrayList<Citizen> citizens = readTextFile();
        frame();
        streetMap(citizens);
        frame();
        birthplaceMap(citizens);
        frame();
        motherTongueMap(citizens);
        frame();
        occupationMap(citizens);
        frame();
        genderMap(citizens);
        frame();
        rentMap(citizens);
        frame();
        jobRentCorrelationMap(citizens);
    }

    public static void frame() 
    { System.out.println("================================================================="); }

    public static void streetMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, TreeSet<Citizen>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getStreet() == null || citizen.getStreet().equals("."))
                continue;
            map.putIfAbsent(citizen.getStreet(), new TreeSet<>());
            map.get(citizen.getStreet()).add(citizen);
        }

        Iterator<String> streets = map.keySet().iterator();
        while (streets.hasNext()) 
        {
            String street = streets.next();
            System.out.println("Street: " + street);
            for (Citizen citizen : map.get(street))
                System.out.println("\t" + citizen);
        }
    }

    public static void birthplaceMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, PriorityQueue<Double>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getBirthplace() == null || citizen.getBirthplace().equals("."))
                continue;
            map.putIfAbsent(citizen.getBirthplace(), new PriorityQueue<>());
            map.get(citizen.getBirthplace()).add(citizen.getAge());
        }

        Iterator<String> birthplaces = map.keySet().iterator();
        while (birthplaces.hasNext()) 
        {
            String birthplace = birthplaces.next();
            System.out.println("Birthplace: " + birthplace);
            if (birthplace.equals("Pennsylvania"))
                System.out.println("\tThere were " + map.get(birthplace).size() + " people from " + birthplace);
            else 
            {
                System.out.print("[");
                PriorityQueue<Double> ages = map.get(birthplace);
                while (!ages.isEmpty()) 
                {
                    double age = ages.poll();
                    if (age >= 0) {
                        if (ages.peek() != null)
                            System.out.print(age + ", ");
                        else
                            System.out.print(age);
                    }
                }
                System.out.println("]");
            }
        }
    }

    public static void motherTongueMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getMotherTongue() == null || citizen.getMotherTongue().equals("."))
                continue;
            map.putIfAbsent(citizen.getMotherTongue(), new ArrayList<>());
            map.get(citizen.getMotherTongue()).add(citizen.getLastName() + ", " + citizen.getFirstName());
        }
        Iterator<String> motherTongues = map.keySet().iterator();
        while (motherTongues.hasNext()) 
        {
            String motherTongue = motherTongues.next();
            System.out.println("There " + ((map.get(motherTongue).size() != 1) ? "are " + map.get(motherTongue).size() + " people" : "is " + map.get(motherTongue).size() + " person") + " who speak " + motherTongue);
        }
    }

    public static void occupationMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, HashSet<String>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getOccupation() == null || citizen.getOccupation().equals("."))
                continue;
            map.putIfAbsent(citizen.getOccupation(), new HashSet<>());
            map.get(citizen.getOccupation()).add(citizen.getfatherBirthplace());
        }
        Iterator<String> occupations = map.keySet().iterator();
        while (occupations.hasNext()) 
        {
            String occupation = occupations.next();
            System.out.println(occupation + ":");
            HashSet<String> temp = map.get(occupation);
            Iterator<String> birthplaces = temp.iterator();
            while (birthplaces.hasNext()) {
                System.out.println("\t" + birthplaces.next());
            }
        }
    }

    public static void genderMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, HashSet<String>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getGender() == null)
                continue;
            map.putIfAbsent(citizen.getGender(), new HashSet<>());
            map.get(citizen.getGender()).add(citizen.getRemarks());
        }
        Iterator<String> genders = map.keySet().iterator();
        while (genders.hasNext()) 
        {
            String gender = genders.next();
            System.out.println(gender + ": ");
            HashSet<String> temp = map.get(gender);
            Iterator<String> remarks = temp.iterator();
            while (remarks.hasNext()) 
            { System.out.println("\t" + remarks.next()); }
        }
    }

    public static void rentMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, TreeSet<Double>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getRenting() == null)
                continue;
            map.putIfAbsent(citizen.getRenting(), new TreeSet<>());
            map.get(citizen.getRenting()).add(citizen.getPropertyValue());
        }
        Iterator<String> rents = map.keySet().iterator();
        while (rents.hasNext()) 
        {
            String rent = rents.next();
            System.out.println(rent + ":");
            TreeSet<Double> temp = map.get(rent);
            for (Double propertyValue : temp) 
                System.out.println("\t" + propertyValue);
        }
    }

    public static void jobRentCorrelationMap(ArrayList<Citizen> citizens) 
    {
        TreeMap<String, HashMap<String, HashSet<Double>>> map = new TreeMap<>();
        for (Citizen citizen : citizens) 
        {
            if (citizen.getOccupation() == null || citizen.getOccupation().equals(".") || citizen.getRenting() == null
                    || citizen.getPropertyValue() == -1)
                continue;
            map.putIfAbsent(citizen.getOccupation(), new HashMap<>());
            map.get(citizen.getOccupation()).putIfAbsent(citizen.getRenting(), new HashSet<>());
            map.get(citizen.getOccupation()).get(citizen.getRenting()).add(citizen.getPropertyValue());
        }
        System.out.println("Values:");
        for (String occupation : map.keySet()) 
        { System.out.println("\t" + occupation + ": " + map.get(occupation)); }
        TreeMap<String, HashMap<String, Double>> averages = new TreeMap<>();
        for (String occupation : map.keySet()) 
        {
            averages.put(occupation, new HashMap<>());
            for (String renting : map.get(occupation).keySet()) 
            {
                double sum = 0;
                for (Double propertyValue : map.get(occupation).get(renting))
                    sum += propertyValue;
                averages.get(occupation).put(renting, sum / map.get(occupation).get(renting).size());
            }
        }
        System.out.println("\nAverages:");
        for (String occupation : averages.keySet()) 
            System.out.println("\t" + occupation + ": " + averages.get(occupation));
    }

    public static ArrayList<Citizen> readTextFile() 
    {
        try 
        {
            List<String> allLines = Files.readAllLines(new File("fed.txt").toPath());

            ArrayList<Citizen> citizens = new ArrayList<>();
            for (String line : allLines) {
                line = line.replaceAll("\\*/12", "    ");
                line = line.replaceAll("\\*", " ");
                if (line.length() > 3 && line.substring(0, 3).matches("\\d+")) {
                    Citizen citizen = new Citizen(line.substring(71, 88).trim(), line.substring(55, 71).trim(),
                            line.substring(20, 36).trim(), line.substring(36, 45).trim(),
                            line.substring(88, 108).trim(), line.substring(108, 113).trim(),
                            line.substring(113, 121).trim(), line.substring(133, 138).trim(),
                            line.substring(143, 151).trim(), line.substring(151, 156).trim(),
                            line.substring(156, 162).trim(), line.substring(162, 167).trim(),
                            line.substring(167, 173).trim(), line.substring(173, 190).trim(),
                            line.substring(190, 207).trim(), line.substring(207, 224).trim(),
                            line.substring(224, 235).trim(), line.substring(235, 241).trim(),
                            line.substring(252, 274).trim(), line.substring(274, 303).trim(),
                            line.substring(342).trim());
                    citizens.add(citizen);
                }
            }
            return citizens;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static double toDouble(String s) 
    {
        s = s.replaceAll("\\$", "").replaceFirst(",", "");
        return Double.parseDouble(s);
    }

    public static double simplifyFraction(int whole, String frac) 
    {
        String[] parts = frac.split("/");
        return whole + (double) Integer.parseInt(parts[0]) / (double) Integer.parseInt(parts[1]);
    }

    public static double splitMixedNumber(String s) 
    {
        s = s.replaceAll("\\$", "");
        if (s.split(" ").length > 1)
            return simplifyFraction(Integer.parseInt(s.split(" ")[0]), s.split(" ")[1]);
        else
            return s.contains("/") ? simplifyFraction(0, s) : Double.parseDouble(s);
    }
}