package ru.protomorphine;

import org.apache.commons.cli.*;
import ru.protomorphine.helpers.EncryptionHelper;

public class Main {

    /**
     *
     * Program entry point
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Let's Encrypt Data");

        Options cmdOptions = new Options();

        Option cypherOption = new Option("c", "cypher", true, "cypher");
        Option inputStringOption = new Option("i", "input-string", true, "String to encrypt");
        Option keyOption = new Option("k", "key", true, "Key to encrypt/decrypt data");

        cypherOption.setRequired(true);
        cmdOptions.addOption(cypherOption);
        inputStringOption.setRequired(true);
        cmdOptions.addOption(inputStringOption);
        keyOption.setRequired(true);
        cmdOptions.addOption(keyOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd = null;

        try {
            cmd = parser.parse(cmdOptions, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("encrypt", cmdOptions);

            System.exit(1);
        }

        String cypher = cmd.getOptionValue("cypher");
        String source = cmd.getOptionValue("input-string");
        String key = cmd.getOptionValue("key");


        switch (cypher) {
            case "rot" -> System.out.println(EncryptionHelper.encryptWithRotCypher(source, Integer.valueOf(key)));
            case "vigenere" -> System.out.println(EncryptionHelper.encryptWithVigenereCypher(source, key));
        }

    }
}