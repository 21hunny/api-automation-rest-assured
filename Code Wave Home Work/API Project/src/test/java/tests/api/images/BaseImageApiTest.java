package tests.api.images;

import org.example.clients.ImageApiClient;
import org.testng.annotations.BeforeClass;

public class BaseImageApiTest {

    protected ImageApiClient imageApiClient;

    @BeforeClass
    public void setUp() {
        imageApiClient = new ImageApiClient();
    }
}