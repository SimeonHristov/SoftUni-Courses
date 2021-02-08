package _11_DefiningClasses_LAB.P03_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        ClientRepository clientRepository = new ClientRepository();

        while (!line.equals("End")) {
            String[] commands = line.split("\\s+");

            switch (commands[0]) {
                case "Create":
                    clientRepository.create();
                    break;
                case "Deposit":
                    clientRepository.deposit(new int[]{Integer.parseInt(commands[1]), Integer.parseInt(commands[2])});
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commands[1]);
                    clientRepository.setInterest(interest);
                    break;
                case "GetInterest":
                    clientRepository.getInterest(new int[]{Integer.parseInt(commands[1]), Integer.parseInt(commands[2])});
                    break;
            }

            line = bufferedReader.readLine();
        }
    }
}