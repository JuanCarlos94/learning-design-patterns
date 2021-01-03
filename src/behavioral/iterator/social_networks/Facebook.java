package behavioral.iterator.social_networks;

import behavioral.iterator.iterators.FacebookIterator;
import behavioral.iterator.iterators.ProfileIterator;
import behavioral.iterator.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork {
    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if(cache != null){
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        simulateNetworkLatency();
        System.out.println("Facebook: Loading profile '" + profileEmail + "' over the network...");
        return findProfile(profileEmail);
    }

    public List<String> requestProfilesFriendsFromFacebook(String email, String type) {
        simulateNetworkLatency();
        System.out.println("Facebook: Loading '" + type + "' list of '" + email + "' over the network...");
        Profile profile = findProfile(email);
        if(profile != null){
            return profile.getContacts(type);
        }
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for(Profile profile : profiles){
            if(profile.getEmail().equals(profileEmail)){
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try{
            Thread.sleep(2500);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
