package sharpen.util;


import java.io.IOException;
import java.io.InputStream;


public class ResourceLoader {

    public static String getStringContents(final Class<?> anchor, String resourceName) throws IOException {
        InputStream stream = anchor.getResourceAsStream(resourceName);
        if (null == stream) return null;
        try {
            return InputStreamUtility.readString(stream);
        } finally {
            stream.close();
        }
    }

    public static void resourceNotFound(String resourceName) {
        throw new IllegalArgumentException("Resource '" + resourceName + "' not found");
    }

}
