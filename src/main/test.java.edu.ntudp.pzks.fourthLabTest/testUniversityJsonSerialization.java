import edu.ntudp.fit.silakov.lab4.JsonManager;
import edu.ntudp.fit.silakov.lab4.models.University;
import org.junit.Assert;
import org.junit.Test;

public class testUniversityJsonSerialization {
    @Test
    public void testUniversityJsonSerialization() {
        UniversityCreator universityCreate = new UniversityCreator();
        JsonManager jsonManager = new JsonManager();
        University oldUniversity = universityCreate.createTypicalUniversity();
        jsonManager.writeToJsonFile("university.json", oldUniversity);
        University newUniversity = jsonManager.readFromJsonFile("university.json");
        Assert.assertEquals(oldUniversity, newUniversity);
    }
}