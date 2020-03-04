package mpplibrary.service;

import mpplibrary.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserSession {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean hasBothPermission(){
        return user.getRole().getName().equalsIgnoreCase("BOTH");
    }

    public boolean hasAdminPermission(){
        return user.getRole().getName().equalsIgnoreCase("ADMIN");
    }

    public boolean hasLibrarianPermission(){
        return user.getRole().getName().equalsIgnoreCase("LIBRARIAN");
    }
}
