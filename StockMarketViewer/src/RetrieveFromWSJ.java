import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

// ========================================================================================= //
// ==========================            retrieve data            ========================== //
// ========================================================================================= //


class RetrieveFromWSJ {
    // ********************************************************************** //
    // ** Instant Field
    // ********************************************************************** //
    private String data;


    // ********************************************************************** //
    // ** Constructor
    // ********************************************************************** //
    RetrieveFromWSJ(String ticker, String start, String end) throws IOException {
        String url = "http://quotes.wsj.com/" + ticker +
                "/historical-prices/download?MOD_VIEW=page" +
                "&num_rows=80" +
                "&startDate=" + start +
                "&endDate=" + end;
        this.data = retrieve(url);
    }


    // ********************************************************************** //
    // ** Method for Retrieve from Web
    // ********************************************************************** //
    private static String retrieve(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        String redirect = connection.getHeaderField("Location");
        StringBuilder sb = new StringBuilder();
        if (redirect != null) {
            connection = new URL(redirect).openConnection();
        }

        try (InputStream in = connection.getInputStream();
             Scanner scanner = new Scanner(in)
        ) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    // ********************************************************************** //
    // ** Getter
    // ********************************************************************** //
    String getData() {
        return data;
    }
}
