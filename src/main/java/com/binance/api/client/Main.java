package com.binance.api.client;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.account.NewOrderResponse;
import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.marketBuy;

public class Main {
    private static final String apiKey="7gojgicFxu54oIaOe9b479m72fWIjlNWBOne9fFRCuZzeylGuDylAKOKs7543kTq";
    private static final String secret="PdMJ55q5iGbf0gne7fh0oztnwKf2dtmBHxFFmcRAN99E17pZDDwx5ve3bQSvITVK";
    public static void main(String[] args) {

        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secret);
        BinanceApiRestClient client = factory.newRestClient();
        System.out.println("Подключились");
        long serverTime = client.getServerTime();
        System.out.println(serverTime);
//        TickerStatistics tickerStatistics = client.get24HrPriceStatistics("BTCUSDT");
//        System.out.println(tickerStatistics.getLastPrice());
        NewOrderResponse newOrderResponse = client.newOrder(marketBuy("LINKETH", "1000").newOrderRespType(NewOrderResponseType.FULL));
        List<Trade> fills = newOrderResponse.getFills();
        System.out.println(newOrderResponse.getClientOrderId());
    }
}
