package Assignment4;

abstract class PaymentGateway {
    protected String apiKey;
    protected String connectionUrl;

    public PaymentGateway(String apiKey, String connectionUrl) {
        this.apiKey = apiKey;
        this.connectionUrl = connectionUrl;
    }

    public void connect(String gateway) {
        System.out.println("Connected to " + gateway + " API");
    }

    public void disconnect(String gateway) {
        System.out.println("Disconnected from " + gateway + " API");
    }
}
interface PaymentProcessor {
    void processPayment(double amount);
}

interface RefundProcessor {
    void processRefund(double amount);
}
class StripeGateway extends PaymentGateway implements PaymentProcessor, RefundProcessor {

    public StripeGateway(String apiKey, String connectionUrl) {
        super(apiKey, connectionUrl);
    }

    @Override
    public void processPayment(double amount) {
        connect("Stripe");
        System.out.println("Processing Stripe payment of $" + amount);
        disconnect("Stripe");
    }

    @Override
    public void processRefund(double amount) {
        connect("Stripe");
        System.out.println("Processing Stripe refund of $" + amount);
        disconnect("Stripe");
    }
}
class PayPalGateway extends PaymentGateway implements PaymentProcessor, RefundProcessor {

    public PayPalGateway(String apiKey, String connectionUrl) {
        super(apiKey, connectionUrl);
    }

    @Override
    public void processPayment(double amount) {
        connect("PayPal");
        System.out.println("Processing PayPal payment of $" + amount);
        disconnect("PayPal");
    }

    @Override
    public void processRefund(double amount) {
        connect("PayPal");
        System.out.println("Processing PayPal refund of $" + amount);
        disconnect("PayPal");
    }
}
class PaymentGatewayTest {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeGateway("stripe-api", "api.stripe.com");
        stripe.processPayment(100.0);

        RefundProcessor paypal = new PayPalGateway("paypal-api", "api.paypal.com");
        paypal.processRefund(50.0);
    }
}
