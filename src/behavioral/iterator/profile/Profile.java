package behavioral.iterator.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private String name;
    private String email;
    private Map<String, List<String>> contacts = new HashMap<>();

    public Profile(String email, String name, String... contacts){
        this.email = email;
        this.name = name;

        for(String contact : contacts){
            String[] parts = contact.split(":");
            String contactType = "friend", contactEmail;
            if(parts.length == 1){
                contactEmail = parts[0];
            }
            else{
                contactType = parts[0];
                contactEmail = parts[1];
            }
            if(!this.contacts.containsKey(contactType)){
                this.contacts.put(contactType, new ArrayList<>());
            }
            this.contacts.get(contactType).add(contactEmail);
        }
    }

    public String getName(){
        return name;
    }

    public List<String> getContacts(String type) {
        if(!this.contacts.containsKey(type)){
            this.contacts.put(type, new ArrayList<>());
        }
        return contacts.get(type);
    }

    public String getEmail() {
        return email;
    }
}
