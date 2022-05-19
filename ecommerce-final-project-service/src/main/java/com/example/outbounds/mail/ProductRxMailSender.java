package com.example.outbounds.mail;

import com.example.domain.domain.Product;
import com.example.domain.domain.User;
import com.example.outbound_connectors.ProductNotificationOutPort;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Author: Joaquín Pereira Silvestre
 */
@Component
public class ProductRxMailSender implements ProductNotificationOutPort {

  @Override
  public void notifyNewProduct(List<User> users, Product product) {

    Observable.fromIterable(users)
        .flatMap(user -> Observable.just(user).subscribeOn(Schedulers.computation()).doOnNext(u -> sendMail(u, product)))
        .subscribe(user -> System.out.println("Sent notification of product " + product.getName() + " to " + user.getUsername()));
  }

  private void sendMail(User user, Product product) throws InterruptedException {

    // Simulates sending email
    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));

    System.out.println("");
    System.out.println("Thread: " + Thread.currentThread().getName());
    System.out.println("Sending notification of product " + product.getName() + " to " + user.getUsername());
  }
}
