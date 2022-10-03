package overclock.overclock.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Map;

public interface PayService {

        void saveOrder(String orderNumber, long timestamp, String signature, int price);

        String checkPcReturn(String resultCode, String resultMsg, String mid, String orderNumber, String authToken, String authUrl, String netCancelUrl, String charset, String merchantData) throws IllegalAccessException, IOException, InterruptedException;

        HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data);

}
