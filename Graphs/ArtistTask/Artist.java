package ArtistTask;
public class Artist
{
    String name;
    int uniqueID;
    public Artist(String name)
    {
        this.name = name;
        this.uniqueID = name.hashCode();
    }
 
    public String getName()
    { return name; }
 
    public int getID()
    { return uniqueID; }
 
    public String toString()
    { return "Name: " + name + " Unique ID: " + String.valueOf(uniqueID); }
 
    public boolean equal(Artist obj)
    {
        if(obj == null || getClass() != obj.getClass())
        { return false; }
        return true;
    }
}
