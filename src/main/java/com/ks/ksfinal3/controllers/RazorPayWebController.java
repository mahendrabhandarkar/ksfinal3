package com.ks.ksfinal3.controllers;

import com.ks.ksfinal3.config.RazorPayConstants;
import com.razorpay.OrderClient;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.razorpay.RazorpayClient;

import java.util.Random;
import java.util.random.RandomGenerator;
/*
@Controller
@RequestMapping("/web/pay")
public class RazorPayWebController {

    public RazorPayConstants razorPayConstants;

    public static final Logger logger = LoggerFactory.getLogger(RazorPayWebController.class);

    // https://github.com/razorpay/razorpay-java-testapp/blob/master/src/main/java/com/razorpay/PaymentResource.java

    @GetMapping("/checkout")
    public String checkoutPage(Model model, HttpServletResponse response) {
        logger.info("API_KEY: {}", razorPayConstants.API_KEY);

        Order apiOrder = new Order();
        OrderClient apiOrderClient = new OrderClient();

        Random random = new Random();
        int number = random.nextInt(100000000);
        model.addAttribute("razorpayOrderId", number);
        return "pages/paybutton";
    }

    private RazorpayClient client;
    private int amount = 500;

    private String apiKey;
    private String secretKey;

    public PaymentResource(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        try {
            this.client = new RazorpayClient(this.apiKey, this.secretKey);
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public View getPaymentForm() throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", amount); // Note: The amount should be in paise.
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1);
        Order order = client.Orders.create(options);
        return new PaymentView(amount, (String) order.get("id"));
    }

    @POST
    @Path("/charge")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public View charge(MultivaluedMap<String, String> formParams) {
        String paymentId = formParams.getFirst("razorpay_payment_id");
        String razorpaySignature = formParams.getFirst("razorpay_signature");
        String orderId = formParams.getFirst("razorpay_order_id");
        JSONObject options = new JSONObject();

        if (StringUtils.isNotBlank(paymentId) && StringUtils.isNotBlank(razorpaySignature)
                && StringUtils.isNotBlank(orderId)) {
            try {
                options.put("razorpay_payment_id", paymentId);
                options.put("razorpay_order_id", orderId);
                options.put("razorpay_signature", razorpaySignature);
                boolean isEqual = Utils.verifyPaymentSignature(options, this.secretKey);

                if (isEqual) {
                    return new SuccessView(paymentId, orderId, "");
                }
            } catch (RazorpayException e) {
                System.out.println("Exception caused because of " + e.getMessage());
                return new SuccessView(paymentId, orderId, e.getMessage());
            }
        }
        return new SuccessView("", "", "Details not available");
    }
}
*/