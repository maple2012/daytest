package com.java8.stream.Test.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTest {
    @Test
    public void builder(){
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(raoul,2012,1000),
                new Transaction(mario,2012,500),
                new Transaction(alan,2011,200)
        );
        // 查找 2012 金额倒序
        List<Transaction> transaction = transactionList.stream().filter(i->i.getYear() == 2012).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        // 哪些不同的城市
        List<String> cityArr = transactionList.stream().map(i->i.getTrader().getCity()).distinct().collect(Collectors.toList());

    }

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Trader{
    private String name;
    private String city;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Transaction{
    private Trader trader;
    private int year;
    private int value;

}
