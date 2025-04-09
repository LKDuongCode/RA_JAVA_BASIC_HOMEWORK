package practice_homeworks.business.model;

import java.time.LocalDateTime;

public class TransferLog {
    private int id;
    private int senderId;
    private int receiverId;
    private double amount;
    private LocalDateTime createdAt;
    private String status;

    public TransferLog(int id, int senderId, int receiverId, double amount, LocalDateTime createdAt, String status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.createdAt = createdAt;
        this.status = status;
    }

    public int getId() { return id; }

    public int getSenderId() { return senderId; }

    public int getReceiverId() { return receiverId; }

    public double getAmount() { return amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public String getStatus() { return status; }

}
