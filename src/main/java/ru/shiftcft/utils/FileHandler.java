package ru.shiftcft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.shiftcft.data.Basket;
import ru.shiftcft.data.BasketSorter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final Logger logger = LogManager.getLogger(FileHandler.class);

    public Basket readInputFiles(ArrayList<String> filePaths) {
        Basket basket = new Basket();
        BasketSorter basketSorter = new BasketSorter();
        for (String inputFilePath : filePaths) {
            try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while((line = br.readLine()) != null) {
                    basketSorter.putLineToBasket(line, basket);
                }
            } catch (IOException e) {
                logger.error("Failed to read file {}", inputFilePath +
                        "\nCheck the path and file name and try again");
            }
        }
        return basket;
    }

    public void writeStringDataToFile(String filePath, List<String> inputBasket, boolean append) {
        if (!inputBasket.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {
                for (String line : inputBasket) {
                    bw.write(line + "\n");
                }
            } catch (IOException e) {
                logger.error("Failed to write data to file " + filePath);
            }
        }
    }

    public void writeIntegerDataToFile(String filePath, ArrayList<? extends Number> inputBasket, boolean append) {
        if (!inputBasket.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {
                for (Number line : inputBasket) {
                    bw.write(line + "\n");
                }
            } catch (IOException e) {
                logger.error("Failed to write data to file " + filePath);
            }
        }
    }

    public void mkDir(String path) {
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
    }
}