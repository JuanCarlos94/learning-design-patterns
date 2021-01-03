package behavioral.iterator.social_networks;

import behavioral.iterator.iterators.LinkedInIterator;
import behavioral.iterator.iterators.ProfileIterator;
import behavioral.iterator.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class LinkedIn implements SocialNetwork {
    private List<Profile> contacts;

    public LinkedIn(List<Profile> cache){
        if(cache != null){
            this.contacts = cache;
        } else {
            this.contacts = new ArrayList<>();
        }
    }

    public Profile requestContactInfoFromLinkedIn(String friendEmail) {
        simulateNetworkLatency();
        System.out.println("LinkedIn: loading profile '" + friendEmail + "' over the network...");
        return findContact(friendEmail);
    }

    private void simulateNetworkLatency() {
        try{
            Thread.sleep(2500);
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public List<String> requestRelatedContactsFromLinkedInAPI(String email, String type) {
        simulateNetworkLatency();
        System.out.println("LinkedIn: loading '" + type + "' list of '" + email + "' over the network...");
        Profile profile = findContact(email);
        if(profile != null){
            return profile.getContacts(type);
        }
        return null;
    }

    private Profile findContact(String email) {
        for(Profile profile : contacts){
            if(profile.getEmail().equals(email)){
                return profile;
            }
        }
        return null;
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new LinkedInIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new LinkedInIterator(this, "coworkers", profileEmail);
    }
}
