package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestDataManager {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private TestDataManager() {
        // Utility class
    }

    public static String readTestDataFile(String relativePath) {
        String fullPath = "testdata/" + relativePath;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = TestDataManager.class.getClassLoader();
        }

        try (InputStream inputStream = classLoader.getResourceAsStream(fullPath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Test data file not found: " + fullPath);
            }
            byte[] bytes = readAllBytes(inputStream);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read test data file: " + fullPath, e);
        }
    }

    public static <T> T readTestDataAsObject(String relativePath, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(readTestDataFile(relativePath), clazz);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to deserialize test data file: " + relativePath, e);
        }
    }

    private static byte[] readAllBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }
}
