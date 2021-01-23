package SetsAndMaps_EXERCISE_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FixEmails_07 {

        private static final String[] FORBIDDEN_DOMAINS = {"us", "uk", "com"};

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            LinkedHashMap<String, String> emails = new LinkedHashMap<>();
            while (true) {
                String name = bufferedReader.readLine();
                if (name.endsWith("stop")) {
                    break;
                }
                String email = bufferedReader.readLine();
                if (!isValidEmail(email)) {
                    continue;
                }

                emails.put(name, email);
            }

            for (String name : emails.keySet()) {
                String email = emails.get(name);
                System.out.println(String.format("%s -> %s", name, email));
            }
        }

        private static boolean isValidEmail(String email) {
            for (int i = 0; i < FORBIDDEN_DOMAINS.length; i++) {
                if (email.endsWith(FORBIDDEN_DOMAINS[i])) {
                    return false;
                }
            }
            return true;
        }
    }