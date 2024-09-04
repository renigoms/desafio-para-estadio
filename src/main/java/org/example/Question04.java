package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question04 {

    static class Faturamento{
        private String UF;
        private double value;
        private double percentage;

        public Faturamento(String UF, double value, double percentage) {
            this.UF = UF;
            this.value = value;
            this.percentage = percentage;
        }

        public String getUF() {
            return UF;
        }

        public double getValue() {
            return value;
        }

        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }

        @Override
        public String toString() {
            return "Faturamento{" +
                    "UF='" + UF + '\'' +
                    ", value=" + value +
                    ", percentage=" + percentage +
                    '}';
        }
    }

    static List<Faturamento> calculatePercetage(List<Faturamento> listFaturamento){
        double total = listFaturamento.stream().mapToDouble(Faturamento::getValue).sum();
        listFaturamento.forEach((e) -> {
            double percentage = (e.getValue() * 100) / total;
            e.setPercentage(percentage);
        });
        return listFaturamento;


    }

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("SP",67836.43);
        map.put("RJ ",36678.66);
        map.put("MG ",29229.88);
        map.put("ES ",27165.48);
        map.put("Outros ",19849.53);

        ArrayList<Faturamento> faturamentosList = new ArrayList<>();

        map.forEach((key, value) -> {
            faturamentosList.add(new Faturamento(key, value, 0));
        });

        calculatePercetage(faturamentosList).forEach(e -> System.out.println(e.toString()));



    }
}
