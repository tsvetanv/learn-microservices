package com.tsvetanv.customer;

import com.tsvetanv.clients.fraud.FraudCheckResponse;
import com.tsvetanv.clients.fraud.FraudClient;
import com.tsvetanv.clients.notification.NotificationClient;
import com.tsvetanv.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        // send notification
        notificationClient.createNotification(new NotificationRequest("Registered customer: " + customer.toString()));
    }
}
