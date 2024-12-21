package com.ks.ksfinal3.repository.message;

import com.ks.ksfinal3.entity.message.Notification;
import com.ks.ksfinal3.entity.message.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Test User
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> findAllByStatus(NotificationStatus notificationStatus);


    public List<Notification> findAllByStatusNot(NotificationStatus notificationStatus);

}
