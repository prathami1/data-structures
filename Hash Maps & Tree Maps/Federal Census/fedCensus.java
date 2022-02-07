import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fedCensus 
{
    public fedCensus()
    {
        // String is streetname, arraylist is filled with citizens.

        File name = new File("fed.txt");
        try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text, output = "";
			while((text=input.readLine())!= null)
			{
				String[] pieces = text.split("");
				output += text;
                String firstName = text.substring(71,88).trim();
                String lastName = text.substring(55,71).trim();
                String streetName = text.substring(20,36).trim();
                String streetNumber = text.substring(36,45).trim();
                String relation = text.substring(88,108).trim();
                String rentOwn = text.substring(108,113).trim();
                String valueProp = text.substring(113,121).trim();
                String gender = text.substring(133,134).trim();
                String age = text.substring(143,151).trim();
                String maritalStatus = text.substring(151,156).trim();
                String ageFirstMarriage = text.substring(156,162).trim();
                String attendSchool = text.substring(162,167).trim();
                String canRead = text.substring(167,173).trim();
                String birthplace = text.substring(173,190).trim();
                String fathersBirthplace = text.substring(190,207).trim();
                String mothersBirthplace = text.substring(207,224).trim();
                String mothertongue = text.substring(224,235).trim();
                String yearImmigrated = text.substring(235,241).trim();
                String occupation = text.substring(252,274).trim();
                String industry = text.substring(274,303).trim();
                String transcibedRemarks = text.substring(342).trim();
                System.out.println(firstName);
			}
			input.close();
		}
		catch (IOException io)
		{ System.err.println("File does not exist"); }
    }

    public TreeMap sortCitizensByStreet(String input)
    {
        TreeMap<String, ArrayList<String>> streetMap = new TreeMap<>();
        
        return streetMap;
    }

    public static void main(String[] args)
    { fedCensus app = new fedCensus(); }
}