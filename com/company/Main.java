package com.company;

import com.company.fluentapi.impl.test;

public class Main {

    public static void main(String[] args)  throws Exception {

        System.out.println(new test()
                .param("name", "Akos Szalay")
                .param("email", "akos.szalay@mensa.hu")
                .param("repo", "https://github.com/akos-mensa/LPSolutions-test.git")
                .genHtml(prepTemplate()));

    }

    static String prepTemplate() {
        String templateString = String.join("\n",
"<!DOCTYPE html>",
        "<html>",
        "    <head>",
        "        <title> ${name} - Teszt Feladat</title>",
        "    </head>",
        "    <body>",
        "        <h1>Teszt Feladat</h1>",
        "        <p><a href=\"${repo}\">Megoldás</a></p>",
        "        <p>A feladat elkészítőjének adatai</p>",
        "        <table border=\"1px solid black\">",
        "            <tr>",
        "                <td>Név</td>",
        "                <td>${name}</td>",
        "            </tr>",
        "            <tr>",
        "                <td>Elérhetőség</td>",
        "                <td>${email}</td>",
        "            </tr>",
        "        </table>",
        "        <a href=\"http://lpsolutions.hu\">L&P Solutions</a>",
        "    </body>",
        "</html>"
        );
        return templateString;
    }

}
