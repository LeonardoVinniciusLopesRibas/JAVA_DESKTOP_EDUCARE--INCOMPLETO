package projeto.unipar.educarefrontend.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlConverterToJson {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static List<String> readSqlFile(String filePath) throws IOException {
        List<String> sqlStatements = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder statement = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (statement.length() > 0) {
                        sqlStatements.add(statement.toString().trim());
                        statement.setLength(0);
                    }
                } else {
                    statement.append(line).append(" ");
                }
            }
            if (statement.length() > 0) {
                sqlStatements.add(statement.toString().trim());
            }
        }
        return sqlStatements;
    }

    private static String convertSqlToJson(List<String> sqlStatements) {
        try {
            return mapper.writeValueAsString(sqlStatements);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
