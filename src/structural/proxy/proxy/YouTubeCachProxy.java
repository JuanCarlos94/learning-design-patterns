package structural.proxy.proxy;

import structural.proxy.media_library.ThirdPartyYouTubeClass;
import structural.proxy.media_library.ThirdPartyYouTubeLib;
import structural.proxy.media_library.Video;

import java.util.HashMap;

public class YouTubeCachProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youTubeLib;
    private HashMap<String, Video> cachePopulars = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCachProxy(){
        this.youTubeLib = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if(cachePopulars.isEmpty()){
            cachePopulars = youTubeLib.popularVideos();
        } else {
            System.out.println("Retrieved list from cache");
        }
        return cachePopulars;
    }

    @Override
    public Video getVideo(String videoID) {
        Video video = cacheAll.get(videoID);
        if(video == null){
            video = youTubeLib.getVideo(videoID);
            cacheAll.put(videoID, video);
        } else {
            System.out.println("Retrieved video '" + videoID + "' from cache.");
        }
        return video;
    }

    public void reset(){
        cachePopulars.clear();
        cacheAll.clear();
    }
}
