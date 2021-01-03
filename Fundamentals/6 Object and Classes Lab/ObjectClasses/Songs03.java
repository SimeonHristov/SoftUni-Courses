package com.company.Lab06.ObjectClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSongs = Integer.parseInt(scanner.nextLine());
        List<SongList> songs = new ArrayList<>();
//        for (int i = 0; i < numSongs; i++) {
//            String[] input = scanner.nextLine().split("_");
//            String type = input[0];
//            String name = input[1];
//            String time = input[2];
//
//            Song song = new Song();
//            song.setTypeList(type);
//            song.setName(name);
//            song.setTime(time);
//
//            songs.add(song);
//        }

        while (songs.size() < numSongs) {
            String[] input = scanner.nextLine().split("_");
            String type = input[0];
            String name = input[1];
            String time = input[2];

            SongList song = new SongList();
            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String toPrint = scanner.nextLine();

//        for (SongList song : songs) {
//            if (song.getTypeList().equals(toPrint)) {
//                System.out.println(song.getName());
//            } else {
//                System.out.println(song.getName());
//            }
//        }



//        if (toPrint.equals("all")) {
//            for (SongList song : songs) {
//                System.out.println(song.getName());
//            }
//        } else {
//            for (SongList song : songs) {
//                if(toPrint.equals(song.getTypeList())){
//                    System.out.println(song.getName());
//                }
//            }
//        }


        //Stream API to filter the collection:
        List<SongList> filteredSongs = songs.stream().filter(a -> a.getTypeList().equals(toPrint)).collect(Collectors.toList());

        if (toPrint.equals("all")) {
            for (SongList song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (SongList song : filteredSongs) {
                System.out.println(song.getName());
            }
        }
    }


    static class SongList {
        String typeList;
        String name;
        String time;

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

}
