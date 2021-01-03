package com.company.FinalExamPrep04April2020;

import java.util.*;

public class FinalExamRetake15Aug2020ThePianist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Piece> allPieces = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");

            String name = line[0];
            String composer = line[1];
            String key = line[2];

            Piece p = new Piece(name, composer, key);
            allPieces.put(name, p);
        }

        String line = scanner.nextLine();
        while (!line.equals("Stop")) {
            String[] tokens = line.split("\\|");
            String command = tokens[0];
            String name = tokens[1];


            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if(allPieces.containsKey(name)) {
                        System.out.printf("%s is already in the collection!%n",name);
                    } else {
                        Piece p = new Piece(name,composer,key);
                        allPieces.put(name,p);
                        System.out.printf("%s by %s in %s added to the collection!%n",name,composer,key);
                    }
                    break;


                case "Remove":
                    if(allPieces.containsKey(name)) {
                        allPieces.remove(name);
                        System.out.printf("Successfully removed %s!%n",name);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",name);
                    }
                    break;


                case "ChangeKey":
                    String changeKey = tokens[2];
                    if(!allPieces.containsKey(name)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",name);
                    } else {
                        allPieces.get(name).setKey(changeKey);
                        System.out.printf("Changed the key of %s to %s!%n",name,changeKey);
                    }
                    break;
            }
            line = scanner.nextLine();
        }

        List<Piece> sortedPieces = new ArrayList<>(allPieces.values());
        Collections.sort(sortedPieces,(a,b) -> {
            int byName = a.getName().compareTo(b.getName());
            if (byName ==0 ) {
                return a.getComposer().compareTo(b.getComposer());
            } else {
                return  byName;
            }
        });

        for (Piece sortedPiece : sortedPieces) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",sortedPiece.getName(),sortedPiece.getComposer(),sortedPiece.getKey());
        }

    }

    static class Piece {
        String name;
        String composer;
        String key;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }
    }
}
