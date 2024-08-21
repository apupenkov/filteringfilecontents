package ru.shiftcft.utils;

import ru.shiftcft.data.Basket;
import ru.shiftcft.data.BasketSorter;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

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
                System.out.println("Не удалось прочитать файл " + inputFilePath +
                        "\nПроверьте путь и название файла и повторите попытку");
            }
        }
        return basket;
    }

    public void writeDataToFile(String filePath, ArrayList<String> inputBasket, boolean append) {
        if (!inputBasket.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {
                for (String line : inputBasket) {
                    bw.write(line);
                }
            } catch (IOException e) {
                System.out.println("Не удалось записать данные в файл " + filePath);
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
