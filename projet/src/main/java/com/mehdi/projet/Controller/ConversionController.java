package com.mehdi.projet.Controller;

import com.mehdi.projet.Service.ConversionData;
import com.mehdi.projet.ConversionResponse;
import jakarta.annotation.PostConstruct;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConversionController {

    private List<ConversionData> listeDonneesConversion = new ArrayList<>();

    private long idCounter = 1;

    @GetMapping("/convert/km-to-au/{km}")
    public ConversionResponse convertKmToAstronomicalUnits(@PathVariable double km) {
        double astronomicalUnits = km * 6.68459e-9;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("kmToAU");
        conversionData.setValeurOriginale(km);
        conversionData.setValeurConvertie(astronomicalUnits);
        conversionData.setUnite("Unité Astronomique");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(astronomicalUnits);
    }

    @GetMapping("/convert/km-to-cm/{km}")
    public ConversionResponse convertKmToCentimeters(@PathVariable double km) {
        double centimeters = km * 100000; // 1 km = 100000 cm
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("kmToCm");
        conversionData.setValeurOriginale(km);
        conversionData.setValeurConvertie(centimeters);
        conversionData.setUnite("centimètres");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(centimeters);
    }

    // Les autres méthodes de conversion suivront le même modèle avec un objet ConversionData créé pour chaque conversion et ajouté à la liste de données
    @GetMapping("/convert/celsius-to-fahrenheit/{celsius}")
    public ConversionResponse convertCelsiusToFahrenheit(@PathVariable double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("CelsiusToFah");
        conversionData.setValeurOriginale(celsius);
        conversionData.setValeurConvertie(fahrenheit);
        conversionData.setUnite("fahrenheit");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(fahrenheit);
    }

    @GetMapping("/convert/celsius-to-kelvin/{celsius}")
    public ConversionResponse convertCelsiusToKelvin(@PathVariable double celsius) {
        double kelvin = celsius + 273.15;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("CelsiusToKelvin");
        conversionData.setValeurOriginale(celsius);
        conversionData.setValeurConvertie(kelvin);
        conversionData.setUnite("kelvin");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(kelvin);
    }

    @GetMapping("/convert/fahrenheit-to-kelvin/{fahrenheit}")
    public ConversionResponse convertFahrenheitToKelvin(@PathVariable double fahrenheit) {
        double kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("FahToKelvin");
        conversionData.setValeurOriginale(fahrenheit);
        conversionData.setValeurConvertie(kelvin);
        conversionData.setUnite("kelvin");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(kelvin);
    }

    @GetMapping("/convert/joules-to-kilojoules/{joules}")
    public ConversionResponse convertJoulesToKilojoules(@PathVariable double joules) {
        double kilojoules = joules / 1000;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("JouleToKiloJoule");
        conversionData.setValeurOriginale(joules);
        conversionData.setValeurConvertie(kilojoules);
        conversionData.setUnite("kiloJoules");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(kilojoules);
    }

    @GetMapping("/convert/watt-hour-to-kilowatt-hour/{wattHour}")
    public ConversionResponse convertWattHourToKilowattHour(@PathVariable double wattHour) {
        double kilowattHour = wattHour / 1000;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("WattToKiloWatt");
        conversionData.setValeurOriginale(wattHour);
        conversionData.setValeurConvertie(kilowattHour);
        conversionData.setUnite("kiloWatt");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(kilowattHour);
    }

    @GetMapping("/convert/hertz-to-megahertz/{hertz}")
    public ConversionResponse convertHertzToMegahertz(@PathVariable double hertz) {
        double megahertz = hertz / 1000000;
        ConversionData conversionData = new ConversionData();
        conversionData.setId(idCounter++);
        conversionData.setTypeConversion("HertToMegaHertz");
        conversionData.setValeurOriginale(hertz);
        conversionData.setValeurConvertie(megahertz);
        conversionData.setUnite("megaHertz");
        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
        return new ConversionResponse(megahertz);
    }


    @PostMapping("/save-conversion-data")
    public void saveConversionData(@RequestBody ConversionData conversionData) {
        if (conversionData.getId() == null || conversionData.getTypeConversion() == null ||
                conversionData.getValeurOriginale() == 0.0 || conversionData.getValeurConvertie() == 0.0 ||
                conversionData.getUnite() == null) {
            // Ne sauvegarder que les conversions valides avec des valeurs non nulles
            return;
        }

        conversionData.setId(idCounter++);

        if (!listeDonneesConversion.contains(conversionData)) {
            listeDonneesConversion.add(conversionData);
            writeDataToJSONFile();
        }
    }

    // Méthode pour sauvegarder les données de conversion dans le fichier JSON
    private void writeDataToJSONFile() {
        JSONArray jsonArray = new JSONArray();
        for (ConversionData data : listeDonneesConversion) {
            if (data.getId() != null && data.getTypeConversion() != null &&
                    data.getValeurOriginale() != 0.0 && data.getValeurConvertie() != 0.0 &&
                    data.getUnite() != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", data.getId());
                jsonObject.put("typeConversion", data.getTypeConversion());
                jsonObject.put("valeurOriginale", data.getValeurOriginale());
                jsonObject.put("valeurConvertie", data.getValeurConvertie());
                jsonObject.put("unite", data.getUnite());
                jsonArray.add(jsonObject);
            }
        }

        try (FileWriter file = new FileWriter("donnees_conversion.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void loadExistingData() {
        try {
            File file = new File("donnees_conversion.json");
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));
                for (Object object : jsonArray) {
                    JSONObject jsonObject = (JSONObject) object;
                    ConversionData conversionData = new ConversionData();
                    conversionData.setId((Long) jsonObject.get("id"));
                    conversionData.setTypeConversion((String) jsonObject.get("typeConversion"));
                    conversionData.setValeurOriginale((double) jsonObject.get("valeurOriginale"));
                    conversionData.setValeurConvertie((double) jsonObject.get("valeurConvertie"));
                    conversionData.setUnite((String) jsonObject.get("unite"));
                    listeDonneesConversion.add(conversionData);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete-conversion/{id}")
    public void deleteConversion(@PathVariable Long id) {
        listeDonneesConversion.removeIf(conversion -> conversion.getId().equals(id));
        writeDataToJSONFile(); // Sauvegarde les données après la suppression
    }


    @GetMapping("/get-conversion-data")
    public List<ConversionData> getAllConversionData() {
        return listeDonneesConversion;
    }
}

