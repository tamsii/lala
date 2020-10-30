package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data

public class Order {
    private String balloonColor;
    private String baloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public Order(String balloonColor, String baloonSize) {
        this.balloonColor = balloonColor;
        this.baloonSize = baloonSize;
    }

    public Order(String balloonColor, String baloonSize, String clientName, String clientAddress, Long orderId) {
        this.balloonColor = balloonColor;
        this.baloonSize = baloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }

}
