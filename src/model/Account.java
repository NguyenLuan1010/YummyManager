package model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableStringProperty;

public class Account {
    private StringProperty id;
    private StringProperty Username;
    private StringProperty phone;
    private StringProperty password;
    private StringProperty type;
    private StringProperty status;
   

    public Account() {
    }

    public Account(String id,String Username, String phone, String password, String type, String status) {
        this.id = new SimpleStringProperty(id);
        this.Username = new SimpleStringProperty(Username);
        this.phone = new SimpleStringProperty(phone);
        this.password = new SimpleStringProperty(password);
        this.type = new SimpleStringProperty(type);
        this.status = new SimpleStringProperty(status);
    }

    public void setId(String id) {
        this.id.setValue(id);
    }
    public void setUsername(String Username) {
        this.Username.setValue(Username);
    }
    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    public void setType(String type) {
        this.type.setValue(type);
    }

    public void setStatus(String status) {
        this.status.setValue(status);
    }

    public String getId() {
        return id.getValue();
    }
    public String getUsername(){
        return Username.getValue();
    }

    public String getPhone() {
        return phone.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

    public String getType() {
        return type.getValue();
    }

    public String getStatus() {
        return status.getValue();
    }
    public StringProperty getIdProperty() {
        return id;
    }
    public StringProperty getUsernameProperty() {
        return Username;
    }
    public StringProperty getPhoneProperty() {
        return phone;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public StringProperty getTypeProperty() {
        return type;
    }

    public StringProperty getStatusProperty() {
        return status;
    }
}
