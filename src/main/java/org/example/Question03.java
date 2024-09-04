package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Question03 {

    static double highestValue(ArrayList<Map<String, Double>>listMap){
        double highestValue = 0;
        for (Map<String, Double> map : listMap){
            double value = map.get("valor");
            if (value>highestValue)
                highestValue = value;
        }
        return highestValue;
    }
    static double calculateAverage(ArrayList<Map<String, Double>>listMap){
        listMap = listMap.stream().filter(map -> map.get("valor") != 0)
                .collect(Collectors.toCollection(ArrayList::new));
        return (listMap.stream()
                .mapToDouble(map -> map.get("valor")).sum())/listMap.size();
    }

    static double aboveAverage(ArrayList<Map<String, Double>>listMap){
        double average = calculateAverage(listMap), count = 0;
        for (Map<String, Double> map : listMap){
            if (map.get("valor") > average) count++;
        }
        return count;
    }

    static double lowestValue(ArrayList<Map<String, Double>>listMap){
        double lowestValue = highestValue(listMap);
        for (Map<String, Double> map : listMap){
            double value = map.get("valor");
            if (value<lowestValue)
                lowestValue = value;
        }
        return lowestValue;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = dataBase();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Map<String, Double>> mapArray = objectMapper.readValue(json, ArrayList.class);
        System.out.printf("O maior valor foi %s\n", highestValue(mapArray));
        System.out.printf("O menor valor foi %s\n",lowestValue(mapArray));
        System.out.printf("%s dias tiveram valores acima da média\n",aboveAverage(mapArray));
    }

    static String dataBase(){
        return """
                [
                	{
                		"dia": 1,
                		"valor": 22174.1664
                	},
                	{
                		"dia": 2,
                		"valor": 24537.6698
                	},
                	{
                		"dia": 3,
                		"valor": 26139.6134
                	},
                	{
                		"dia": 4,
                		"valor": 0.0
                	},
                	{
                		"dia": 5,
                		"valor": 0.0
                	},
                	{
                		"dia": 6,
                		"valor": 26742.6612
                	},
                	{
                		"dia": 7,
                		"valor": 0.0
                	},
                	{
                		"dia": 8,
                		"valor": 42889.2258
                	},
                	{
                		"dia": 9,
                		"valor": 46251.174
                	},
                	{
                		"dia": 10,
                		"valor": 11191.4722
                	},
                	{
                		"dia": 11,
                		"valor": 0.0
                	},
                	{
                		"dia": 12,
                		"valor": 0.0
                	},
                	{
                		"dia": 13,
                		"valor": 3847.4823
                	},
                	{
                		"dia": 14,
                		"valor": 373.7838
                	},
                	{
                		"dia": 15,
                		"valor": 2659.7563
                	},
                	{
                		"dia": 16,
                		"valor": 48924.2448
                	},
                	{
                		"dia": 17,
                		"valor": 18419.2614
                	},
                	{
                		"dia": 18,
                		"valor": 0.0
                	},
                	{
                		"dia": 19,
                		"valor": 0.0
                	},
                	{
                		"dia": 20,
                		"valor": 35240.1826
                	},
                	{
                		"dia": 21,
                		"valor": 43829.1667
                	},
                	{
                		"dia": 22,
                		"valor": 18235.6852
                	},
                	{
                		"dia": 23,
                		"valor": 4355.0662
                	},
                	{
                		"dia": 24,
                		"valor": 13327.1025
                	},
                	{
                		"dia": 25,
                		"valor": 0.0
                	},
                	{
                		"dia": 26,
                		"valor": 0.0
                	},
                	{
                		"dia": 27,
                		"valor": 25681.8318
                	},
                	{
                		"dia": 28,
                		"valor": 1718.1221
                	},
                	{
                		"dia": 29,
                		"valor": 13220.495
                	},
                	{
                		"dia": 30,
                		"valor": 8414.61
                	}
                ]
                """;
    }
}
