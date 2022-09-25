package show;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;
//
public class Operations {
    private static final Scanner scanner = new Scanner(System.in);

    public static void levelFour(List<InfoCompany> companyes) {
        System.out.println("\nИспользование валюты (company id: code): ");
        System.out.println("Введите валюту (rub, eu, usd): ");
        String currency = scanner.nextLine();

        if (currency.equalsIgnoreCase("rub")
                || currency.equalsIgnoreCase("eu")
                || currency.equalsIgnoreCase("usd")){

            // Список ценных бумаг
            List<Security> securitiesUsingCurrency = companyes.stream().map(InfoCompany::getSecurities).flatMap(Collection::stream)
                    .filter(i -> i.getCurrency().contains(currency.toUpperCase()))
                    .distinct()
                    .collect(Collectors.toList());

            // фильтрация списка компаний
            companyes.stream().filter(i -> i.getSecurities().stream().anyMatch(securitiesUsingCurrency::contains))
                    .peek(i -> System.out.printf("id компании: %s (%s)%n", i.getId(), i.getName()))
                    .map(InfoCompany::getSecurities).flatMap(Collection::stream)
                    // вывод ценных бумаг
                    .filter(securitiesUsingCurrency::contains)
                    .forEach(i -> System.out.printf("%s (%s)%n", i.getCode(), i.getName()));
        } else {
            System.out.println("Неверный ввод!");
        }
    }

    public static void LevelThree(List<InfoCompany> companyes) {
        System.out.println("\nКомпании основанные после даты: ");
        System.out.println("Введите дату (dd.mm.yy, dd.mm.yyyy, dd/mm/yy, dd/mm/yyyy): ");
        String inputDate = scanner.nextLine();
        LocalDate date = convertToLocalDate(inputDate);
        if (date != null){
            System.out.printf("Вы ввели: %s%n", date);

            companyes.stream().filter(i -> convertToLocalDate(i.getFounded()).isAfter(date))
                    .forEach(i -> System.out.printf("%s - %s%n", i.getName(), i.getFounded()));
        } else {
            System.out.println("Неверный ввод!");
        }
    }

    public static void levelTwo(List<InfoCompany> companyes) {
        System.out.println("\nЦенные бумаги с истекшим сроком действия (code - name - expires):");
        List<Security> expired = companyes.stream().map(InfoCompany::getSecurities).flatMap(Collection::stream)
                .filter(i -> convertToLocalDate(i.getDate()).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        expired.forEach(i -> System.out.printf("%s - %s - %s%n", i.getCode(), i.getName(), i.getDate()));

        System.out.printf("Общее количество ценных бумаг с истекшим сроком действия: %s%n", expired.size());
    }

    public static void levelOne(List<InfoCompany> companyes) {
        System.out.println("Компания (имя - основаны в):");
        companyes.forEach(i -> System.out.printf("%s - %s%n", i.getName(), formatDate(i.getFounded())));
    }


    private static String formatDate(String inputDate){
        LocalDate date = convertToLocalDate(inputDate);
        if (date != null){
            return date.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        } else{
            return null;
        }
    }

    public static LocalDate convertToLocalDate(String inputDate){
        Map<String, String> patterns = new HashMap<>();
        patterns.put("\\d{1,2}/\\d{1,2}/\\d{2,4}", "dd/M/");
        patterns.put("\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}", "dd.M.");

        DateTimeFormatter formatter = null;
        LocalDate date = null;
        for(Map.Entry<String, String> pattern : patterns.entrySet()){
            if (inputDate.matches(pattern.getKey())){
                formatter = new DateTimeFormatterBuilder()
                        .appendPattern(pattern.getValue())
                        .appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 4, LocalDate.now().minusYears(80))
                        .toFormatter();
                break;
            }
        }
        if (formatter != null){
            try {
                date = LocalDate.parse(inputDate, formatter);
            }
            catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Companyes parseJson(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        Companyes companyes = null;
        try {
            companyes = mapper.readValue(new File(fileName), Companyes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyes;
    }

}
